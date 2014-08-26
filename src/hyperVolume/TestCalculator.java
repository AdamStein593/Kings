package hyperVolume;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class TestCalculator {

	public static void main(String[] args) {
            List <Solution>solutionList = generateList();
                                          
            Solution reference =new Solution (5,5);                
            
            Front a =new Front("Algorithm A",solutionList);
                       
            double hypervolume=a.calculateHypervolume(reference);
            System.out.println("H("+a.getSolver()+"): "+hypervolume);           
	}
        
        public static List<Solution>generateList(){
            int i=0;
            List <Solution>list = new ArrayList();
            ////The first element of the list must be (0,0) to simplify the calculateHypervolume function by not having an if statement
            list.add(new Solution(0,0));
            try{
            BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Adam/Documents/Sixth Form/Work experience and summer school/Kings/Solutions.txt"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                //Skips over i=0 as there are no solutions on this line in the file
                if (i>0){
                    String[] parts = line.split(", ");
                    list.add(new Solution(Double.parseDouble(parts[0]),Double.parseDouble(parts[1])));
                }
                i++;
            }
            }catch(Exception e){
                System.out.println("Error");
            }
            return list;
        }
        
        

}
