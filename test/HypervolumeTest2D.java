/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import hyperVolume.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adam
 */
public class HypervolumeTest2D {
    
    public HypervolumeTest2D() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testCalculate() {
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
            double expResult=0.24;
            Front a = new Front("Algorithm A", list);
            double yourResult=a.calculateHypervolume(reference);
            assertEquals(expResult, yourResult, 0.01);
            
     }
     
     @Test
     public void testCalculate2() {
            List <Solution>list = new ArrayList();
            Solution solution0 = new Solution(0,0);
            Solution solution1 = new Solution(1,4);
            Solution solution2 = new Solution(2,3);
            Solution solution3 = new Solution(3,2);
            
            Solution reference =new Solution (6,6);
            
            list.add(solution0);
            list.add(solution1);
            list.add(solution2);
            list.add(solution3);
            double expResult=0.25;
            Front a = new Front("Algorithm A", list);
            double yourResult=a.calculateHypervolume(reference);
            assertEquals(expResult, yourResult, 0.01);
            
     }
     
     @Test
     public void testCalculate3() {
            List <Solution>list = new ArrayList();
            Solution solution0 = new Solution(0,0);
            Solution solution1 = new Solution(1,6);
            Solution solution2 = new Solution(2,2);
            Solution solution3 = new Solution(4,1);
            
            Solution reference =new Solution (10,10);
            
            list.add(solution0);
            list.add(solution1);
            list.add(solution2);
            list.add(solution3);
            double expResult=0.1;
            Front a = new Front("Algorithm A", list);
            double yourResult=a.calculateHypervolume(reference);
            assertEquals(expResult, yourResult, 0.01);
            
     }
}