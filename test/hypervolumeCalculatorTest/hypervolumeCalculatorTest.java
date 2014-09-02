/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hypervolumeCalculatorTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import hypervolumeCalculator.*;
import java.util.List;
import static hypervolumeCalculator.Calculator.generateList;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Adam
 */
public class hypervolumeCalculatorTest {
    
    public hypervolumeCalculatorTest() {
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

        String currentDirectory = new File("").getAbsolutePath();       
        String fileName=currentDirectory +"/testFiles/Solutions3D.txt";
        
        List<Solution> solutionList = generateList(fileName);
        
        
        Collections.sort(solutionList, new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                double x1 = o1.get(0);
                double x2 = o2.get(0);

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
         
        List <Double>ref =new ArrayList();
        for (int i=0;i<=solutionList.get(0).getLength()-1;i++){
            ref.add(5.0);
        }
        Solution reference = new Solution(ref);

        Front a = new Front("Algorithm A", solutionList);
        double actualResult1 = a.calculateHypervolume(reference);
        double actualResult2 = a.calculateHypervolume(reference);
        assertEquals(actualResult1, actualResult2, 0.01);

    }

    @Test
    public void testRemoveDominated() {
        String currentDirectory = new File("").getAbsolutePath();       
        String fileName=currentDirectory +"/testFiles/testRemoveDominated.txt";
        
        List<Solution> solutionList = generateList(fileName);
        
        Collections.sort(solutionList, new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                double x1 = o1.get(0);
                double x2 = o2.get(0);

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
         
        List <Double>ref =new ArrayList();
        for (int i=0;i<=solutionList.get(0).getLength()-1;i++){
            ref.add(5.0);
        }
        Solution reference = new Solution(ref);

        Front a = new Front("Algorithm A", solutionList);
        double expResult = 0.192;
        double actualResult = a.calculateHypervolume(reference);
        assertEquals(expResult, actualResult, 0.01);

    }
    
    @Test
    public void testAscendingXAscendingYDescendingZ() {
        
        String currentDirectory = new File("").getAbsolutePath();       
        String fileName=currentDirectory +"/testFiles/Solutions3D.txt";
        
        List<Solution> solutionList = generateList(fileName);
        
        
        Collections.sort(solutionList, new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                double x1 = o1.get(0);
                double x2 = o2.get(0);

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
         
        List <Double>ref =new ArrayList();
        for (int i=0;i<=solutionList.get(0).getLength()-1;i++){
            ref.add(5.0);
        }
        Solution reference = new Solution(ref);

        Front a = new Front("Algorithm A", solutionList);       

        double expResult = 0.112;
        double actualResult = a.calculateHypervolume(reference);
        assertEquals(expResult, actualResult, 0.01);
    }
    
    @Test
    public void testAscendingXAscendingYAscendingZ() {
        String currentDirectory = new File("").getAbsolutePath();       
        String fileName=currentDirectory +"/testFiles/testAscendingXAscendingYAscendingZ.txt";

        List<Solution> solutionList = generateList(fileName);

        Collections.sort(solutionList, new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                double x1 = o1.get(0);
                double x2 = o2.get(0);

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
         
        List <Double>ref =new ArrayList();
        for (int i=0;i<=solutionList.get(0).getLength()-1;i++){
            ref.add(5.0);
        }
        Solution reference = new Solution(ref);

        Front a = new Front("Algorithm A", solutionList);
        double expResult = 0.216;
        double actualResult = a.calculateHypervolume(reference);
        assertEquals(expResult, actualResult, 0.01);

    }
    
    @Test
    public void testAscendingXDescendingYAscendingZ() {
        String currentDirectory = new File("").getAbsolutePath();       
        String fileName=currentDirectory +"/testFiles/testAscendingXDescendingYAscendingZ.txt";
        List<Solution> solutionList = generateList(fileName);

        Collections.sort(solutionList, new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                double x1 = o1.get(0);
                double x2 = o2.get(0);

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
         
        List <Double>ref =new ArrayList();
        for (int i=0;i<=solutionList.get(0).getLength()-1;i++){
            ref.add(5.0);
        }
        Solution reference = new Solution(ref);

        Front a = new Front("Algorithm A", solutionList);
        double expResult = 0.112;
        double actualResult = a.calculateHypervolume(reference);
        assertEquals(expResult, actualResult, 0.01);

    }
    
    @Test
    public void testAscendingXDescendingYDescendingZ() {
        String currentDirectory = new File("").getAbsolutePath();       
        String fileName=currentDirectory +"/testFiles/testAscendingXDescendingYDescendingZ.txt";
        
        List<Solution> solutionList = generateList(fileName);

        Collections.sort(solutionList, new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                double x1 = o1.get(0);
                double x2 = o2.get(0);

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
         
        List <Double>ref =new ArrayList();
        for (int i=0;i<=solutionList.get(0).getLength()-1;i++){
            ref.add(5.0);
        }
        Solution reference = new Solution(ref);

        Front a = new Front("Algorithm A", solutionList);
        double expResult = 0.16;
        double actualResult = a.calculateHypervolume(reference);
        assertEquals(expResult, actualResult, 0.01);

    }
    
    @Test
    public void testAscendingXRandomYRandomZ() {
        String currentDirectory = new File("").getAbsolutePath();       
        String fileName=currentDirectory +"/testFiles/testAscendingXRandomYRandomZ.txt";
        List<Solution> solutionList = generateList(fileName);

        Collections.sort(solutionList, new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                double x1 = o1.get(0);
                double x2 = o2.get(0);

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
         
        List <Double>ref =new ArrayList();
        for (int i=0;i<=solutionList.get(0).getLength()-1;i++){
            ref.add(5.0);
        }
        Solution reference = new Solution(ref);

        Front a = new Front("Algorithm A", solutionList);
        double expResult = 0.528;
        double actualResult = a.calculateHypervolume(reference);
        assertEquals(expResult, actualResult, 0.01);

    }
    
    @Test
    public void test2D() {
        String currentDirectory = new File("").getAbsolutePath();       
        String fileName=currentDirectory +"/testFiles/Solutions.txt";
        List<Solution> solutionList = generateList(fileName);

        Collections.sort(solutionList, new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                double x1 = o1.get(0);
                double x2 = o2.get(0);

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
         
        List <Double>ref =new ArrayList();
        for (int i=0;i<=solutionList.get(0).getLength()-1;i++){
            ref.add(5.0);
        }
        Solution reference = new Solution(ref);

        Front a = new Front("Algorithm A", solutionList);
        double expResult = 0.24;
        double actualResult = a.calculateHypervolume(reference);
        assertEquals(expResult, actualResult, 0.01);

    }
}