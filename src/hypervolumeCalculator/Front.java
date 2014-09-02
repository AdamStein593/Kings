package hypervolumeCalculator;

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
    private int sorter;
    

    public Front(String solver, List<Solution> listOfSolutions) {
        this.solver = solver;
        this.listOfSolutions = listOfSolutions;
    }

    public String getSolver() {
        return solver;
    }

    
    public double calculateHypervolume(Solution referencePoint) {
        List<Solution> solutionList = new ArrayList(listOfSolutions);
        
        List <Double>empty =new ArrayList();
        for (int i=0;i<=solutionList.get(0).getLength()-1;i++){
            empty.add(0.0);
        }
        double dominated=0;
        if (referencePoint.getLength()==2){
            dominated=calculateArea2D(solutionList,solutionList.get(0).getLength()-3);
        }
        else{
            dominated=calculateVolume2(solutionList);
        }
              
        double dominatedByRef=1;
        for (int i=0;i<referencePoint.getLength();i++){
            dominatedByRef*=referencePoint.get(i);
        }

        double hypervolume = dominated / (dominatedByRef);
        return hypervolume;
    }

       
    public double calculateArea2D(List<Solution> solutionList,int index) {
        double area = 0;
        List<Solution> solutionList2 = new ArrayList(removeDominated(solutionList,index));
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

    
    public List<Solution> removeDominated(List<Solution> solutionList,int indexOfCurrentCord) {
        List<Solution> solutionList2 = new ArrayList(solutionList);
        
        for (Solution solution : solutionList) {
            
            for (Solution solution2 : solutionList) {
                int lessThan=0;
                int equal=0;
                for (int i=indexOfCurrentCord+1;i<solutionList.get(0).getLength();i++){                  
                    if (solution.get(i)<solution2.get(i)) {
                        lessThan++;
                    }
                    else if (solution.get(i)==solution2.get(i)) {
                        equal++;
                    }
                    
                    if (lessThan+equal==solutionList.get(0).getLength()-(indexOfCurrentCord+1) && lessThan!=0){
                        solutionList2.remove(solution);
                    }
                }
               
            }
        }
        return solutionList2;
    }
    
    public double calculateVolume2(List<Solution> solutionList){
        List<Double> list=new ArrayList(); 
        double vol=0;
        for (int i=0;i<listOfSolutions.get(0).getLength()-1;i++){
                     
            if (i!=0){ 
                sorter=i;

                Collections.sort(solutionList, new Comparator<Solution>() {
                    @Override
                    public int compare(Solution o1, Solution o2) {
                        double x1 = o1.get(sorter);
                        double x2 = o2.get(sorter);

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
                for(int j=0;j<listOfSolutions.size();j++){
                    if(j==0){
                    vol+=list.get(j)*listOfSolutions.get(j).get(i-1);
                    }
                    else{
                        vol+=list.get(j)*(listOfSolutions.get(j).get(i-1)-listOfSolutions.get(j-1).get(i-1));
                    }
                }    
                
            }
            else{                                       
                for (int j=0; j<listOfSolutions.size();j++){
                    list.add(calculateArea2D(solutionList,0));
                    solutionList.remove(0);
                }

            }
        }
        
        return vol;
    }
}