package hypervolume3D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Represents a set of solutions that make a pareto front from an algorithm.
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
     * Calculates the hypervolume of a pareto front
     *
     * @param referencePoint an object which the list of solutions is compared
     * to when calculating hypervolume
     * @return the proportion that the area of the solutions take up when
     * compared to the area dominated by the reference point
     *
     */
    public double calculateHypervolume(Solution referencePoint) {
        List<Solution> solutionList = new ArrayList(listOfSolutions);

        double volume = calculateVolume(solutionList, new Solution (0,0,0));

        double hypervolume = volume / (referencePoint.getX() * referencePoint.getY() * referencePoint.getZ());
        return hypervolume;
    }

    /**
     * Recursive function that each time it is called has the solution with the
     * smallest X value in the solutionList removed until the list is empty
     *
     * @param solutionList a list of some of the solutions on the pareto front
     * from an algorithm.
     * @param lastRemoved the object that was the last removed from the
     * solutionList
     * @return the total volume dominated by the solutions
     */
    public double calculateVolume(List<Solution> solutionList, Solution lastRemoved) {
        
        
        //If the list is empty, then 0 can be returned 
        if (solutionList.isEmpty()) {
            return 0;
        }

        double area = calculateArea2D(solutionList);
        //To calculate the volume, the area needs to be multiplied by the difference in x between the first solution in the list and the last removed solution       
        double volumeOfSection = area * (solutionList.get(0).getX() - lastRemoved.getX());
        
        //The value in the list with the lowest X value is then removed
        Solution toRemove = solutionList.remove(0);
        
        return volumeOfSection + calculateVolume(solutionList, toRemove);
    }

    /**
     * Calculates the area dominated by the tempListOfSolutions in just the Y-Z
     * plane as this can the be multiplied by X to find the volume
     *
     * @param solutionList a list of some of the solutions on the pareto front
     * from an algorithm
     * @param lastRemoved the object that was the last removed from the
     * solutionList
     * @return the 2D area from the tempListOfSolutions provided where the 2
     * dimensions are Z and Y
     */
    public double calculateArea2D(List<Solution> solutionList) {
        double area = 0;
        //Duplicate list made so when a solution is removed from one list, it doesn't affect the other list
        List<Solution> solutionList2 = new ArrayList(removeDominated(solutionList));
        //Solutions to be sorted in ascending values of Y to allow the calculation of area to be in just one loop
        Collections.sort(solutionList2, new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                double y1 = o1.getY();
                double y2 = o2.getY();

                if (y1 > y2) {
                    return 1;
                }
                if (y1 == y2) {
                    return 0;
                } else {
                    return -1;
                }


            }
        });
        // The first object in the list is set as a solution with 0,0,0 to simplify the loop
        solutionList2.add(0,new Solution(0,0,0));
        for (int i = 1; i <= solutionList2.size() - 1; i++) {
            area += (solutionList2.get(i).getY() - solutionList2.get(i - 1)
                    .getY()) * solutionList2.get(i).getZ();
        }
        // The dummy solution is then removed as it's no longer needed
        solutionList2.remove(0);
        return area;
    }

    /**
     * Function to remove all the solutions in the solutionList that are
     * dominated by other solutions in the Y and Z because dominated solutions
     * will complicate the calculate2DArea function
     *
     * @param solutionList a list of some of the solutions on the pareto front
     * from an algorithm 
     * @return a list with no solutions completed dominated by others in both
     * the Y and Z
     */
    public List<Solution> removeDominated(List<Solution> solutionList) {
        /*A secondary temporary list must be defined or the number of iterates in the for loop will 
         change as the lists are changing size becasue objects are being removed */
        List<Solution> solutionList2 = new ArrayList(solutionList);
        for (Solution solution : solutionList) {
            for (Solution solution2 : solutionList) {
                /*A solution is dominated if another solution has a greater or equal to Y and Z.
                 * the statement can not be solutionList.get(i).getY() <= solution.getY() && solutionList.get(i).getZ() <= solution.getZ()
                 * or all solutions willl be removed when a solution is checked against itself
                 */
                if ((solution.getY() <= solution2.getY() && solution.getZ() < solution2.getZ())
                        || (solution.getY() < solution2.getY() && solution.getZ() <= solution2.getZ())) {
                    //Solution is removed if this is the case           
                    solutionList2.remove(solution);
                }
            }
        }
        return solutionList2;
    }
}