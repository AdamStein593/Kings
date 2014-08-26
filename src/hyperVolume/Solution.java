package hyperVolume;

/**
 * Represents an individual solution as part of a pareto front produced by a MOO solver.
 * 
 * @author Adam Stein
 */
public class Solution {
	private double x;
	private double y;
	
	public Solution (double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
}
