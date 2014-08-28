/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hypervolume3DTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import hypervolume3D.*;
import static hypervolume3D.TestCalculator.generateList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Adam
 */
public class Hypervolume3DTest {

    public Hypervolume3DTest() {
    }

    @BeforeClass
    public static void setUpClass() {
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
    public void testAscendingXAscendingYDescendingZ() {

        String fileName = "C:/Users/Adam/Documents/Sixth Form/Work experience and summer school/Kings/Solutions3D.txt";
        List<Solution> solutionList = generateList(fileName);

        //Sorting the generated list in descending values of Z
        Collections.sort(solutionList, new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                double z1 = o1.getZ();
                double z2 = o2.getZ();

                if (z1 > z2) {
                    return -1;
                }
                if (z1 == z2) {
                    return 0;
                } else {
                    return 1;
                }


            }
        });
        solutionList.add(0, new Solution(0, 0, 0));
        Solution reference = new Solution(5, 5, 5);

        Front a = new Front("Algorithm A", solutionList);
        double expResult = 0.112;
        double actualResult = a.calculateHypervolume(reference);
        assertEquals(expResult, actualResult, 0.01);

    }

    @Test
    public void testListIsUnchanged() {

        String fileName = "C:/Users/Adam/Documents/Sixth Form/Work experience and summer school/Kings/Solutions3D.txt";
        List<Solution> solutionList = generateList(fileName);

        //Sorting the generated list in descending values of Z
        Collections.sort(solutionList, new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                double z1 = o1.getZ();
                double z2 = o2.getZ();

                if (z1 > z2) {
                    return -1;
                }
                if (z1 == z2) {
                    return 0;
                } else {
                    return 1;
                }


            }
        });
        solutionList.add(0, new Solution(0, 0, 0));
        Solution reference = new Solution(5, 5, 5);

        Front a = new Front("Algorithm A", solutionList);
        double actualResult1 = a.calculateHypervolume(reference);
        double actualResult2 = a.calculateHypervolume(reference);
        assertEquals(actualResult1, actualResult2, 0.01);

    }

    @Test
    public void testRemoveDominated() {

        String fileName = "C:/Users/Adam/Documents/Sixth Form/Work experience and summer school/Kings/testRemoveDominated.txt";
        List<Solution> solutionList = generateList(fileName);

        //Sorting the generated list in descending values of Z
        Collections.sort(solutionList, new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                double z1 = o1.getZ();
                double z2 = o2.getZ();

                if (z1 > z2) {
                    return -1;
                }
                if (z1 == z2) {
                    return 0;
                } else {
                    return 1;
                }


            }
        });
        solutionList.add(0, new Solution(0, 0, 0));
        Solution reference = new Solution(5, 5, 5);

        Front a = new Front("Algorithm A", solutionList);
        double expResult = 0.192;
        double actualResult = a.calculateHypervolume(reference);
        assertEquals(expResult, actualResult, 0.01);

    }
}
