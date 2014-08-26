package hypervolumeV2;
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
return 0;
}
}