package HypervolumeCalculationv2;
import java.util.ArrayList;
import java.util.List;
public class Solutions{
    List<Integer> list = new ArrayList<Integer>();
    public Solutions(int [] coordinates){
        list.add(coordinates[0]);
        list.add(coordinates[1]);
        
    }
        
   public int area(){
        int a=list.get(0)*list.get(1);
        return a;
   } 
   
   
}
