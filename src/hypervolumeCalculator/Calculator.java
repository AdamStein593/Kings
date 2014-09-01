package hypervolumeCalculator;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;

public class Calculator {

    public static void main(String[] args) {
        String currentDirectory = new File("").getAbsolutePath();       
        String fileName=currentDirectory +"/testFiles/Solutions3D.txt";
        
        List<Solution> solutionList = generateList(fileName);
        
        //Sorting the generated list in ascending values of X
        Collections.sort(solutionList, new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                double x1 = o1.get(0);
                double x2 = o2.get(0);

                if (x1 > x2) {
                    return 1;
                }
                if (x1 == x2) {
                    return 0;
                } else {
                    return -1;
                }


            }
        });
         
        List <Double>ref =new ArrayList();
        for (int i=0;i<=solutionList.get(0).getLength()-1;i++){
            ref.add(5.0);
        }
        Solution reference = new Solution(ref);

        Front a = new Front("Algorithm A", solutionList);       

        double hypervolume = a.calculateHypervolume(reference);
        System.out.println("H(" + a.getSolver() + "): " + hypervolume);
         
    }

    /**
     * Generates a list of solution objects from a list of solutions in the file "Solutions3D.txt"
     *
     * @return a list of Solution objects
     * 
     * Expected file format:
     * Objective 1, Objective2, Objective 3
     * x, y, z
     * x, y, z
     * x, y, z
     * .....
     * 
     */
    public static List<Solution> generateList(String fileName) {
        List<Solution> list = new ArrayList();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = null;
            //First line skipped as there are no solutions here
            line = reader.readLine();
            
            while ((line = reader.readLine()) != null) { 
                    List<Double> objectiveValues = new ArrayList();
                    String[] parts = line.split(", ");
                        for (int i=0; i<=parts.length-1;i++){
                            objectiveValues.add(Double.parseDouble(parts[i]));
                        }
                    list.add(new Solution(objectiveValues));
                } 
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        return list;
    }
}
