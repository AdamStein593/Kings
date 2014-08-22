package HypervolumeV1;

import java.util.Scanner;
class Hypervolume{
    public static void main (String[]args){
        Scanner scan =new Scanner(System.in);
        
        //Obtaining all the solutions from the user and ensuring what they enter is valid
        boolean listValid=false;
        System.out.println("Enter numbr of solutions");
        int numberOfSolutions=scan.nextInt();
        //The first element of the array must be 0 to simplify the calculateArea function by not having an if statement
        float [] listOfX = new float[numberOfSolutions+1];
        listOfX[0]=0;
        float  [] listOfY= new float[numberOfSolutions+1];
        listOfY[0]=0;
        while (listValid==false){
            System.out.println("Enter solutions in accesnding order of x in the form x,y");                   
            scan.useDelimiter("[,\\s]");
            for (int i=1;i<=numberOfSolutions;i++){
                listOfX[i] = Float.valueOf(scan.next());
                listOfY[i] = Float.valueOf(scan.next());
                }       
            listValid=ListValidation(listOfX,listOfY); 
            if (listValid==false){
                System.out.println("Problem with list entered. Please try again");
            }
        }
           
        float  areaOfSolutions= calculateArea (listOfX,listOfY);
        
        //The first element of the array must be 0  to simplify the calculateArea function by not having an if statement
        //xOptimal and yOptimal must be float lists so they can be used as arguments in the CalculateArea function
        boolean optimumValid=false;
        float [] xOptimal =new float[2];
        xOptimal[0]=0;
        float [] yOptimal =new float[2];
        yOptimal[0]=0;
        while (optimumValid==false){
            System.out.println("Enter optimum in the form x,y");
            scan.useDelimiter("[,\\s]");
            xOptimal[1]=Float.valueOf(scan.next());
            yOptimal[1]=Float.valueOf(scan.next());
            optimumValid=optimumValidation(xOptimal[1],yOptimal[1],listOfX[listOfX.length-1],listOfY[1]);
            if (listValid==false){
                System.out.println("Problem with list entered. Please try again");
            }
        }
        float  areaOfOptimal= calculateArea (xOptimal,yOptimal);
        
        float hyper= calculateHypervolume (areaOfSolutions,areaOfOptimal);
        System.out.println("H(A): "+hyper);
    }
    /**
     * 
     * @param ListOfX float list
     * @param ListOfY float list
     * @return (float) the area underneath the point(s)
     * 
     * CalculateArea({0,1,2,3,4},{0,4,3,2,1}) = 10
     * CalculateArea({0,1,2},{0,2,1}) = 3
     * CalculateArea({0,1.2,2.8},{0,6,4}) = 13.6
     */
    public static float  calculateArea(float  [] ListOfX, float [] ListOfY ){
        
        float  area=0f;
        for (int i=1;i<ListOfX.length;i++){
            area += (ListOfX [i]-ListOfX[i-1])*ListOfY[i];
        }
        return area;
    }
    /**
     * 
     * @param areaOfSolutions float
     * @param areaOfOptimal float
     * @return (float) the proportion that the area of the solutions take up when compared to the area of the optimal
     * 
     * CalculateHypervolume (7,20) = 0.35
     * CalculateHypervolume (10,25) = 0.4
     * CalculateHypervolume (27,35) = 0.77
     */
    public static float calculateHypervolume(float  areaOfSolutions, float  areaOfOptimal ){
        
        float hypervolume = areaOfSolutions/areaOfOptimal;
        return hypervolume;
    }
    
    /**
     * 
     * @param listOfX float list
     * @param listOfY float list
     * @return true if all values are positive and X has been entered in ascending order and Y decreases as X increases
     * 
     * listValidation({1,2,3},{3,2,1} = true
     * listValidation({1,2,2},{2,2,1} = false
     * listValidation({3,2,1},{1,2,3} = false
     * listValidation({-1,2,3},{3,2,-1} = false
     */
    
    public static boolean ListValidation(float [] listOfX, float [] listOfY){
     
        for (int i=1;i<listOfX.length;i++){
            if (listOfX [i]<=listOfX[i-1]){
                return false;
            }
            if (listOfY [i]>=listOfY[i-1] && i!=1){
                //i=1 is excluded as ListOfY[0]=0 so impossible for Y to decrease and remain positive
                return false;
            }
            if (listOfX[i]<0 || listOfY[i]<0){
                return false;
            }
        }
        return true;
    }
    
    /**
     * 
     * @param xOptimum float
     * @param yOptimum float
     * @param maxX float
     * @param maxY float
     * @return true if and only if the X and Y value for the optimum are not lower than the max X and Y value given in the solutions
     * 
     * optimumValidation(5,5,3,3) = true
     * optimumValidation(4,2,4,2) = true
     * optimumValidation(1,1,2,2) = false
     */
    
    public static boolean optimumValidation(float xOptimum, float yOptimum, float maxX,float maxY){
          
        if (xOptimum<maxX){
            return false;
        }
        if (yOptimum<maxY){
            return false;
        }
        return true;
    }
}