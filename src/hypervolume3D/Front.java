package hypervolume3D;

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
        public int a=0;

	public Front(String solver, List<Solution> listOfSolutions) {
		this.solver = solver;
		this.listOfSolutions = listOfSolutions;
	}
        
        
        
        public String getSolver() {
		return solver;
	}
        /**
         * 
         * @param referencePoint double 
         * @return (double) the proportion that the area of the solutions take up when compared to the area of the optimal
         * 
         */
	public double calculateHypervolume(Solution referencePoint){		
            double volume=volume(listOfSolutions);
            
            double hypervolume=volume/(referencePoint.getX()*referencePoint.getY()*referencePoint.getZ());
            return hypervolume;
	}
        public double volume(List<Solution> listOfSolutions){
            
            
            listOfSolutions.remove(0);           
            return a+=volume(listOfSolutions);
        }
}