import java.util.Scanner;
class Hypervolume{
    public static void main (String[]args){
        Scanner scan =new Scanner(System.in);
        
        boolean ListValid=false;
        //finding the number of solutions produced by the optimisation algorithm
        System.out.println("Enter numbr of solutions");
        int NumberOfSolutions=scan.nextInt();
        float [] ListOfX = new float[NumberOfSolutions+1];
        ListOfX[0]=0;
        float  [] ListOfY= new float[NumberOfSolutions+1];
        ListOfY[0]=0;
        //The first element of the array must be 0 so there is no out of bounds error in the CalculateArea function
        //The process of entering the solutions is repeated until they are judged to be valid
        while (ListValid==false){
        System.out.println("Enter solutions in accesnding order of x in the form x,y");                   
        scan.useDelimiter("[,\\s]");
        for (int i=1;i<=NumberOfSolutions;i++){
            ListOfX[i] = Float.valueOf(scan.next());
            ListOfY[i] = Float.valueOf(scan.next());
            }       
        ListValid=ListValidation(ListOfX,ListOfY);         
        }
           
        float  AreaOfSolutions= CalculateArea (ListOfX,ListOfY);
        
        boolean OptimumValid=false;
        float [] XOptimal =new float[2];
        XOptimal[0]=0;
        float [] YOptimal =new float[2];
        YOptimal[0]=0;
        //The first element of the array must be 0 so there is no out of bounds error in the CalculateArea function
        //XOptimal and YOptimal must be float lists so they can be used as arguments in the CalculateArea function
        while (OptimumValid==false){
            System.out.println("Enter optimum in the form x,y");
            scan.useDelimiter("[,\\s]");
            XOptimal[1]=Float.valueOf(scan.next());
            YOptimal[1]=Float.valueOf(scan.next());
            OptimumValid=OptimumValidation(XOptimal[1],YOptimal[1],ListOfX[ListOfX.length-1],ListOfY[1]);
        }
        float  AreaOfOptimal= CalculateArea (XOptimal,YOptimal);
        
        float Hyper= CalculateHypervolume (AreaOfSolutions,AreaOfOptimal);
        System.out.println("H(A): "+Hyper);
    }
    
    public static float  CalculateArea(float  [] ListOfX, float [] ListOfY ){
        // float [], float [] -> float
        // return the area underneath the point(s)
        
        // CalculateArea({0,1,2,3,4},{0,4,3,2,1}) = 10
        // CalculateArea({0,1,2},{0,2,1}) = 3
        // CalculateArea({0,1.2,2.8},{0,6,4}) = 13.6
        
        float  area=0f;
        for (int i=1;i<ListOfX.length;i++){
            area += (ListOfX [i]-ListOfX[i-1])*ListOfY[i];
        }
        return area;
    }
    
    public static float CalculateHypervolume(float  AreaOfSolutions, float  AreaOfOptimal ){
        //float, float -> float
        // returns the proportion that the area of the solutions take up when compared to the area of the optimal
        
        //CalculateHypervolume (7,20) = 0.35
        //CalculateHypervolume (10,25) = 0.4
        //CalculateHypervolume (27,35) = 0.77
        
        float HyperVolume = AreaOfSolutions/AreaOfOptimal;
        return HyperVolume;
    }
    
    public static boolean ListValidation(float [] ListOfX, float [] ListOfY){
        //float [], float [] -> boolean
        //returns true if all values are positive and X has been entered in ascending order and Y decreases as X increases
        
        //ListValidation({1,2,3},{3,2,1} = true
        //ListValidation({1,2,2},{2,2,1} = false
        //ListValidation({3,2,1},{1,2,3} = false
        //ListValidation({-1,2,3},{3,2,-1} = false
        
        for (int i=1;i<ListOfX.length;i++){
            if (ListOfX [i]<=ListOfX[i-1]){
                System.out.println("X was not ascending, please re-enter");
                return false;
            }
            if (ListOfY [i]>=ListOfY[i-1] && i!=1){
                //i=1 is excluded as ListOfY[0]=0 so impossible for Y to decrease and remain positive
                System.out.println("Y was not descending, please re-enter");
                return false;
            }
            if (ListOfX[i]<0 || ListOfY[i]<0){
                System.out.println("All values must be positive");
                return false;
            }
        }
        return true;
    }
    
    public static boolean OptimumValidation(float XOptimum, float YOptimum, float MaxX,float MaxY){
        //float,float,float,float -> boolean
        //returns true if and only if the X and Y value for the optimum are not lower than the max X and Y value given in the solutions
        
        //OptimumValidation(5,5,3,3) = true
        //OptimumValidation(4,2,4,2) = true
        //OptimumValidation(1,1,2,2) = false
        
        if (XOptimum<MaxX){
            System.out.println("The Optimum for X is too low");
            return false;
        }
        if (YOptimum<MaxY){
            System.out.println("The Optimum for Y is too low");
            return false;
        }
        return true;
    }
}