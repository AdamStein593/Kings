package generalHypervolumeCalculator;

import java.util.List;

/**
 * Represents an individual solution as part of a pareto front produced by a MOO solver.
 * 
 * @author Adam Stein
 */
public class Solution {
	private List<Double> solution;
	
	public Solution (List<Double> solution) {
                //Constructor 
		this.solution=solution;
	}
	
	public double get(int index) {
		return solution.get(index);
	}
        
        public int getLength() {
		return solution.size();
	}
		
}
