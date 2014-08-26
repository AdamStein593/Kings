package hypervolume3D;

/**
 * Represents an individual solution as part of a pareto front produced by a MOO solver.
 * 
 * @author Adam Stein
 */
public class Solution {
	private double x;
	private double y;
        private double z;
	
	public Solution (double x, double y, double z) {
                //Constructor 
		this.x = x;
		this.y = y;
                this.z = z;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
        
        public double getZ() {
		return z;
	}
}
