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
    

    

    @Test
    public void testListIsUnchanged() {

        String fileName = "C:/Users/Adam/Documents/Sixth Form/Work experience and summer school/Kings/Solutions3D.txt";
        List<Solution> solutionList = generateList(fileName);

        Collections.sort(solutionList, new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                double x1 = o1.getX();
                double x2 = o2.getX();

                if (x1 > x2) {
                    return 1;
                }
                if (x1 == x2) {
                    return 0;
                } else {
                    return -1;
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

        Collections.sort(solutionList, new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                double x1 = o1.getX();
                double x2 = o2.getX();

                if (x1 > x2) {
                    return 1;
                }
                if (x1 == x2) {
                    return 0;
                } else {
                    return -1;
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
    
    
    @Test
    public void testAscendingXAscendingYDescendingZ() {

        String fileName = "C:/Users/Adam/Documents/Sixth Form/Work experience and summer school/Kings/Solutions3D.txt";
        List<Solution> solutionList = generateList(fileName);

        Collections.sort(solutionList, new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                double x1 = o1.getX();
                double x2 = o2.getX();

                if (x1 > x2) {
                    return 1;
                }
                if (x1 == x2) {
                    return 0;
                } else {
                    return -1;
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
    public void testAscendingXAscendingYAscendingZ() {

        String fileName = "C:/Users/Adam/Documents/Sixth Form/Work experience and summer school/Kings/testAscendingXAscendingYAscendingZ.txt";
        List<Solution> solutionList = generateList(fileName);

        Collections.sort(solutionList, new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                double x1 = o1.getX();
                double x2 = o2.getX();

                if (x1 > x2) {
                    return 1;
                }
                if (x1 == x2) {
                    return 0;
                } else {
                    return -1;
                }


            }
        });
        solutionList.add(0, new Solution(0, 0, 0));
        Solution reference = new Solution(5, 5, 5);

        Front a = new Front("Algorithm A", solutionList);
        double expResult = 0.216;
        double actualResult = a.calculateHypervolume(reference);
        assertEquals(expResult, actualResult, 0.01);

    }
    
    @Test
    public void testAscendingXDescendingYAscendingZ() {

        String fileName = "C:/Users/Adam/Documents/Sixth Form/Work experience and summer school/Kings/testAscendingXDescendingYAscendingZ.txt";
        List<Solution> solutionList = generateList(fileName);

        Collections.sort(solutionList, new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                double x1 = o1.getX();
                double x2 = o2.getX();

                if (x1 > x2) {
                    return 1;
                }
                if (x1 == x2) {
                    return 0;
                } else {
                    return -1;
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
    public void testAscendingXDescendingYDescendingZ() {

        String fileName = "C:/Users/Adam/Documents/Sixth Form/Work experience and summer school/Kings/testAscendingXDescendingYDescendingZ.txt";
        List<Solution> solutionList = generateList(fileName);

        Collections.sort(solutionList, new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                double x1 = o1.getX();
                double x2 = o2.getX();

                if (x1 > x2) {
                    return 1;
                }
                if (x1 == x2) {
                    return 0;
                } else {
                    return -1;
                }


            }
        });
        solutionList.add(0, new Solution(0, 0, 0));
        Solution reference = new Solution(5, 5, 5);

        Front a = new Front("Algorithm A", solutionList);
        double expResult = 0.16;
        double actualResult = a.calculateHypervolume(reference);
        assertEquals(expResult, actualResult, 0.01);

    }
    
    @Test
    public void testAscendingXRandomYRandomZ() {

        String fileName = "C:/Users/Adam/Documents/Sixth Form/Work experience and summer school/Kings/testAscendingXRandomYRandomZ.txt";
        List<Solution> solutionList = generateList(fileName);

        Collections.sort(solutionList, new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                double x1 = o1.getX();
                double x2 = o2.getX();

                if (x1 > x2) {
                    return 1;
                }
                if (x1 == x2) {
                    return 0;
                } else {
                    return -1;
                }


            }
        });
        solutionList.add(0, new Solution(0, 0, 0));
        Solution reference = new Solution(5, 5, 5);

        Front a = new Front("Algorithm A", solutionList);
        double expResult = 0.408;
        double actualResult = a.calculateHypervolume(reference);
        assertEquals(expResult, actualResult, 0.01);

    }
    
    
    
}
