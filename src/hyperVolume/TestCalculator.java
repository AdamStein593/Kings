package hyperVolume;

import java.util.ArrayList;
import java.util.List;

public class TestCalculator {

	public static void main(String[] args) {
            List <Solution>list = new ArrayList();
            
            Solution solution0 = new Solution(0,0);
            Solution solution1 = new Solution(1,3);
            Solution solution2 = new Solution(2,2);
            Solution solution3 = new Solution(3,1);

            Solution reference =new Solution (5,5);
            
            list.add(solution0);
            list.add(solution1);
            list.add(solution2);
            list.add(solution3);

            Front a =new Front("a",list);
            double vol=a.calculateHypervolume(reference);
            System.out.println(vol);

	}

}
