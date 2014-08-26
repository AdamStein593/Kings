package HypervolumeCalculationv2;
import java.util.ArrayList;
import java.util.List;
class MainHypervolume{
    public static void main(String[]args){
        List list = new ArrayList();
        int [] sol1= {1,3};
        int [] sol2= {2,2};
        int [] sol3= {3,1};
        Solutions solution1 = new Solutions(sol1);
        Solutions solution2 = new Solutions(sol2);
        Solutions solution3 = new Solutions(sol3);
        
        list.add(solution1);
        list.add(solution2);
        list.add(solution3);
        
        int a=(list.get(0)).area();
        int b=solution1.area();
        
              
    }
    
    
}