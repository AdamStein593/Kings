package hypervolume3D;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;

public class TestCalculator {

    public static void main(String[] args) {
        String currentDirectory = new File("").getAbsolutePath();       
        String fileName=currentDirectory +"/testFiles/Solutions3D.txt";
        
        List<Solution> solutionList = generateList(fileName);
        
        //Sorting the generated list in ascending values of X
        Collections.sort(solutionList, new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                double x1 = o1.getX();
                double x2 = o2.getX();

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
         
        
        Solution reference = new Solution(5, 5, 5);

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
                    String[] parts = line.split(", ");
                    list.add(new Solution(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]),Double.parseDouble(parts[2])));
                } 
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        return list;
    }
}