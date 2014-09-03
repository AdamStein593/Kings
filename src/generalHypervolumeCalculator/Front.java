package generalHypervolumeCalculator;

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
     * 
     * @param referencePoint
     * @return 
     */
    public double calculateHypervolume(Solution referencePoint) {
        List<Solution> solutionList = new ArrayList(listOfSolutions);
                
        double dominated=0;
        if (referencePoint.getLength()==2){
            dominated=calculateArea2D(solutionList,0);
        }
        else{
            dominated=calculateDominated(solutionList);
        }
              
        double dominatedByRef=1;
        for (int i=0;i<referencePoint.getLength();i++){
            dominatedByRef*=referencePoint.get(i);
        }

        double hypervolume = dominated / (dominatedByRef);
        return hypervolume;
    }

    /**
     * 
     * @param solutionList
     * @param dimensionalIndicator
     * @return 
     */   
    public double calculateArea2D(List<Solution> solutionList,int dimensionalIndicator) {
        double area = 0;
        List<Solution> solutionList2 = new ArrayList(removeDominated(solutionList,dimensionalIndicator));
        Collections.sort(solutionList2, new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                
                double y1 = o1.get(o1.getLength()-2);
                double y2 = o2.get(o2.getLength()-2);

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
        
        List <Double>empty =new ArrayList();
        for (int i=0;i<=solutionList.get(0).getLength()-1;i++){
            empty.add(0.0);
        }
        solutionList2.add(0,new Solution(empty));
        for (int i = 1; i <= solutionList2.size() - 1; i++) {
            int a= solutionList2.get(i).getLength()-1;
            area += (solutionList2.get(i).get(a-1) - solutionList2.get(i - 1)
                    .get(a-1)) * solutionList2.get(i).get(a);
        }
        
        solutionList2.remove(0);
        return area;
    }

    /**
     * Function to remove irrelevant solutions for the calculateArea2D function
     * @param solutionList is a list of all the solutions on the pareto front
     * @param dimensionalIndicator will be 0 if there are only 2 dimensions to each solution. It will be 1 if each solution has greater than 2 dimensions
     * This is necessary for the remove dominated function so that it knows what index to start at
     * @return a list that has no solutions that are completely dominated by another starting from the second index in the list
     * assuming it has more than 2 dimensions. In the 2 dimensional case it returns a list with no completely dominated solutions
     * starting from the first index
     */
    public List<Solution> removeDominated(List<Solution> solutionList,int dimensionalIndicator) {
        List<Solution> solutionList2 = new ArrayList(solutionList);
        
        for (Solution solution : solutionList) {
            
            for (Solution solution2 : solutionList) {
                int lessThan=0;
                int equal=0;
                for (int i=dimensionalIndicator;i<solutionList.get(0).getLength();i++){                  
                    if (solution.get(i)<solution2.get(i)) {
                        lessThan++;
                    }
                    else if (solution.get(i)==solution2.get(i)) {
                        equal++;
                    }
                    /*remove solutions where all its solutions are dominated by at least one other solution
                    lessThan can't equal 0 because that means that a solution would remove itself if it was 
                    the only element left in the list*/
                    if (lessThan+equal==solutionList.get(0).getLength()-(dimensionalIndicator) && lessThan!=0){
                        solutionList2.remove(solution);
                    }
                }
               
            }
        }
        return solutionList2;
    }
    /**
     * Function to calculate the total area dominated by all the solutions in the list
     * @param solutionList is a list of all the solutions on the pareto front
     * @return the total area dominated by all the solutions
     */
    public double calculateDominated(List<Solution> solutionList){
        List<Double> areaList=new ArrayList(); 
        
        double dominate=0;
        for (int i=0;i<listOfSolutions.get(0).getLength()-1;i++){
                     
            if (i!=0){ 
                List<Solution> solutionList2=new ArrayList(listOfSolutions);
             
                
                for(int j=0;j<solutionList2.size();j++){
                    if(j==0){
                        //Multiplying the correspoinding area to the first solution
                        dominate+=areaList.get(j)*solutionList2.get(j).get(i-1);
                    }
                    else{
                        /*For each term in the list excluding the first solution, multiply the corresponding area to the differnece in the current dimension
                         * between the current term and the previous term 
                         */
                        dominate+=areaList.get(j)*(solutionList2.get(j).get(i-1)-solutionList2.get(j-1).get(i-1));
                    }
                }    
                
            }
            else{
                //Calculates all the 2D area first
                for (int j=0; j<listOfSolutions.size();j++){
                    areaList.add(calculateArea2D(solutionList,1));
                    solutionList.remove(0);
                }

            }
        }
        
        return dominate;
    }
}