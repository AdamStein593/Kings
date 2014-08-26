package hyperVolume;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class TestCalculator {

	public static void main(String[] args) {
            List <Solution>list = new ArrayList();
            
            List <Solution>list2=list2();
            
            Solution solution0 = new Solution(0,0);
            Solution solution1 = new Solution(1,3);
            Solution solution2 = new Solution(2,2);
            Solution solution3 = new Solution(3,1);

            Solution reference =new Solution (5,5);
            
            //Adding the solutions to be the list
            list.add(solution0);
            list.add(solution1);
            list.add(solution2);
            list.add(solution3);          
            
            Front a =new Front("Algorithm A",list);
            
            double hypervolume=a.calculateHypervolume(reference);
            System.out.println("H("+a.getSolver()+"): "+hypervolume);

	}
        
        public static List<Solution>list2(){
            int i=0;
            List <Solution>list3 = new ArrayList();
            list3.add(new Solution(0,0));
            try{
            BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Adam/Documents/Sixth Form/Work experience and summer school/Kings/Solutions.txt"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (i>0){
                    String[] parts = line.split(", ");
                    list3.add(new Solution(Double.parseDouble(parts[0]),Double.parseDouble(parts[1])));
                }
                i++;
            }
            }catch(Exception e){
                System.out.println("Error");
            }
            return list3;
        }
        
        

}
