package hypervolume3D;

import java.util.ArrayList;
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
        List<Solution> solutionList= new ArrayList(listOfSolutions);
        double volume = calculateVolume(solutionList, listOfSolutions.get(0));

        double hypervolume = volume / (referencePoint.getX() * referencePoint.getY() * referencePoint.getZ());
        return hypervolume;
    }
    

    /**
     * Recursive function that each time it is called has the largest Z value in
     * the solutionList removed until the list is empty
     *
     * @param solutionList the list of all the solutions on the pareto front
     * from an algorithm
     * @param lastRemoved the object that was the last removed from the solutionList
     * @return the total volume dominated by the solutions
     */
    
    public double calculateVolume(List<Solution> solutionList, Solution lastRemoved) {
        
        //If the only remaining object in the list is the 0,0,0 solution, then 0 can be returned 
        if (solutionList.size() == 1) {
            return 0;
        }
        
        double area = calculateArea2D(solutionList,lastRemoved);
        double volumeOfSection;

        //To calculate the volume, the area needs to be multiplied by the difference in x between the term at index i and the term previos        
        volumeOfSection = area * (solutionList.get(1).getX() - lastRemoved.getX()); 
        Solution toRemove=new Solution(solutionList.get(1).getX(),solutionList.get(1).getY(),solutionList.get(1).getZ());
        
        //The value in the list with the highest Z value is then removed
        solutionList.remove(1);
        

        return volumeOfSection + calculateVolume(solutionList, toRemove);
    }
    

    /**
     * Function calculateArea2D is to calculate the area dominated by the
     * tempListOfSolutions in just the Y-Z plane as this can the be multiplied
     * by X to find the volume
     *
     * @param lastRemoved the object that was the last removed from the solutionList
     * @return the total volume dominated by the solutions
     * @param solutionList2 a list of some of the solutions on the pareto
     * front from an algorithm This list is edited by removing some solutions
     * for calculations such as area
     * @return the 2D area from the tempListOfSolutions provided where the 2
     * dimensions are Z and Y
     */
    
    public double calculateArea2D(List<Solution> solutionList, Solution lastRemoved) {
        double area = 0;
        List<Solution>solutionList2 = new ArrayList(removeDominated(solutionList));
        if (solutionList2.size()==2 || solutionList2.get(1).getZ()>solutionList2.get(2).getZ()){
            for (int i = 1; i <= solutionList2.size() - 1; i++) {           
                    area += (solutionList2.get(i).getY() - solutionList2.get(i-1)
                        .getY()) * solutionList2.get(i).getZ();


            }
        }else{
            for (int i = 1; i <= solutionList2.size() - 2; i++) {           
                    area += (solutionList2.get(i).getY() - solutionList2.get(i+1)
                        .getY()) * solutionList2.get(i).getZ();


            }
            area+=solutionList2.get(solutionList2.size() - 1).getY()* solutionList2.get(solutionList2.size() - 1).getZ();
        }
        return area;
    }
    

    /**
     * Function to remove all the solutions in the solutionList that are
     * dominated by other solutions in the Y and Z because dominated solutions
     * will complicate the calculate2DArea function
     *
     * @param solutionList a list of some of the solutions on the pareto
     * front from an algorithm This list is edited by removing some solutions
     * for calculations such as area
     * @return a list with no solutions completed dominated by others in both
     * the Y and Z
     */
    
    public List<Solution> removeDominated(List<Solution> solutionList) {
        /*A secondary temporary list must be defined or the number of iterates in the for loop will 
         change as the lists are changing size becasue objects are being removed */
        List<Solution> solutionList2 = new ArrayList(solutionList);
        for (int i = 1; i < solutionList.size(); i++) {
            for (Solution solution: solutionList) {
                //A solution is dominated if another solution has a greater Y and Z
                if (solutionList.get(i).getY() < solution.getY() && solutionList.get(i).getZ() < solution.getZ()) {
                    //Solution is removed if this is the case           
                    solutionList2.remove(solutionList.get(i));
                }
            }
        }
        return solutionList2;
    }
}