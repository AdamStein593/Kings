package hypervolume3D;

import java.util.List;

/**
 * Represents totalVolume set of solutions that make totalVolume pareto front
 * from an algorithm.
 *
 * @author Adam Stein
 *
 */

public class Front {

    private String solver;
    private List<Solution> listOfSolutions;

    public Front(String solver, List<Solution> listOfSolutions) {
        this.solver = solver;
        this.listOfSolutions = listOfSolutions;
    }

    public String getSolver() {
        return solver;
    }
    

    /**
     *
     * @param referencePoint an object which the list of solutions is compared
     * to when calculating hypervolume
     * @return the proportion that the area of the solutions take up when
     * compared to the area dominated by the reference point
     *
     */
    
    public double calculateHypervolume(Solution referencePoint) {
        double volume = calculateVolume(listOfSolutions, listOfSolutions);

        double hypervolume = volume / (referencePoint.getX() * referencePoint.getY() * referencePoint.getZ());
        return hypervolume;
    }
    

    /**
     * Recursive function that each time it is called has the largest Z value in
     * the tempListOfSolutions removed until the list is empty
     *
     * @param listOfSolutions the list of all the solutions on the pareto front
     * from an algorithm
     * @param tempListOfSolutions a list of some of the solutions on the pareto
     * front from an algorithm This list is edited by removing some solutions
     * for calculations such as area
     * @return the total volume dominated by the solutions
     */
    
    public double calculateVolume(List<Solution> listOfSolutions, List<Solution> tempListOfSolutions) {
        double area = calculateArea2D(tempListOfSolutions, listOfSolutions);
        double volumeOfSection;

        /*i is the index in the untouched listOfSolutions of the first object in the 
        tempListOfSolutions (excluding the 0,0,0 solutions at the start of the list)*/
        int i = listOfSolutions.indexOf(tempListOfSolutions.get(1));
        //To calculate the volume, the area needs to be multiplied by the difference in x between the term at index i and the term previos        
        volumeOfSection = area * (listOfSolutions.get(i).getX() - listOfSolutions.get(i - 1).getX()); 
        
        //The value in the list with the highest Z value is then removed
        tempListOfSolutions.remove(1);
        //If the only remaining object in the list is the 0,0,0 solution, then 0 can be returned 
        if (tempListOfSolutions.size() == 1) {
            return 0;
        }

        return volumeOfSection + calculateVolume(listOfSolutions, tempListOfSolutions);
    }
    

    /**
     * Function calculateArea2D is to calculate the area dominated by the
     * tempListOfSolutions in just the Y-Z plane as this can the be multiplied
     * by X to find the volume
     *
     * @param tempListOfSolutionsa list of some of the solutions on the pareto
     * front from an algorithm This list is edited by removing some solutions
     * for calculations such as area
     * @param listOfSolutions the list of all the solutions on the pareto front
     * from an algorithm
     * @return the 2D area from the tempListOfSolutions provided where the 2
     * dimensions are Z and Y
     */
    
    public double calculateArea2D(List<Solution> tempListOfSolutions, List<Solution> listOfSolutions) {
        double area = 0;
        tempListOfSolutions = removeDominated(tempListOfSolutions);
        for (int i = 1; i <= tempListOfSolutions.size() - 1; i++) {
            int a = listOfSolutions.indexOf(tempListOfSolutions.get(i));
            area += (tempListOfSolutions.get(i).getY() - listOfSolutions.get(i - 1)
                    .getY()) * tempListOfSolutions.get(i).getZ();
        }
        return area;
    }
    

    /**
     * Function to remove all the solutions in the tempListOfSolutions that are
     * dominated by other solutions in the Y and Z because dominated solutions
     * will complicate the calculate2DArea function
     *
     * @param tempListOfSolutionslist list of some of the solutions on the
     * pareto front from an algorithm This list is edited by removing some
     * solutions for calculations such as area
     * @return a list with no solutions completed dominated by others in both
     * the Y and Z
     */
    
    public List<Solution> removeDominated(List<Solution> tempListOfSolutions) {
        /*A secondary temporary list must be defined or the number of iterates in the for loop will 
         change as the lists are changing size becasue objects are being removed */
        List<Solution> listOfSolutions2 = tempListOfSolutions;
        for (int a = 1; a < tempListOfSolutions.size() - 1; a++) {
            for (int i = 0; i < tempListOfSolutions.size() - 1; i++) {
                //A solution is dominated if another solution has a greater Y and Z
                if (tempListOfSolutions.get(a).getY() < tempListOfSolutions.get(i).getY() && tempListOfSolutions.get(a).getZ() < tempListOfSolutions.get(i).getZ()) {
                    //Solution is removed if this is the case
                    listOfSolutions2.remove(tempListOfSolutions.get(a));
                }
            }
        }
        return listOfSolutions2;
    }
}