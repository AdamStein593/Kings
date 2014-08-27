package hypervolume3D;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;

public class TestCalculator {

    public static void main(String[] args) {
        String fileName="C:/Users/Adam/Documents/Sixth Form/Work experience and summer school/Kings/Solutions3D.txt";
        List<Solution> solutionList = generateList(fileName);
        
        //Sorting the generated list in descending values of Z
        Collections.sort(solutionList, new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                double z1 = o1.getZ();
                double z2 = o2.getZ();

                if (z1 > z2) {
                    return -1;
                }
                if (z1 == z2) {
                    return 0;
                } else {
                    return 1;
                }


            }
        });
        solutionList.add(0,new Solution(0,0,0));
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
        //i is the current line number
        int i = 0;
        List<Solution> list = new ArrayList();
        ////The first element of the list must be (0,0) to simplify the calculateHypervolume function by not having an if statement
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = null;
            while ((line = reader.readLine()) != null) {
                //Skips over i=0 as there are no solutions on this line in the file
                if (i > 0) {
                    String[] parts = line.split(", ");
                    list.add(new Solution(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]),Double.parseDouble(parts[2])));
                }
                i++;
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return list;
    }
}