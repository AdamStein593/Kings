package hyperVolume;

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
	public double calculateHypervolume(Solution referencePoint){
		// TODO Actually implement algorithm
            double area=0;
            for (int i=1;i<=listOfSolutions.size()-1; i++){
                area+=(listOfSolutions.get(i).getX()-listOfSolutions.get(i-1).getX())*listOfSolutions.get(i).getY();
            }
            double hypervolume=area/(referencePoint.getX()*referencePoint.getY());
            return hypervolume;
	}
}
