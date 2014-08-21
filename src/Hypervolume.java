import java.util.Scanner;
class Hypervolume{
    public static void main (String[]args){
        Scanner scan =new Scanner(System.in);
        
        
        System.out.println("Enter numbr of solutions");
        int NumberOfSolutions=scan.nextInt();
        float [] ListOfX = new float[NumberOfSolutions+1];
        ListOfX[0]=0;
        float  [] ListOfY= new float[NumberOfSolutions+1];
        ListOfY[0]=0;
        System.out.println("Enter solutions in accesnding order of x in the form x,y");                   
        scan.useDelimiter("[,\\s]");
        for (int i=1;i<=NumberOfSolutions;i++){
            ListOfX[i] = Float.valueOf(scan.next());
            ListOfY[i] = Float.valueOf(scan.next());
        }
        
        System.out.println(ListValidation(ListOfX,ListOfY));
           
        float  AreaOfSolutions= CalculateArea (ListOfX,ListOfY);
        
        System.out.println("Enter optimum in the form x,y");
        scan.useDelimiter("[,\\s]");
        float  [] XOptimal ={0,Float.valueOf(scan.next())};
        float  [] YOptimal ={0,Float.valueOf(scan.next())};
        float  AreaOfOptimal= CalculateArea (XOptimal,YOptimal);
        
        float Hyper= CalculateHypervolume (AreaOfSolutions,AreaOfOptimal);
        System.out.println(Hyper);
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
        for (int i=1;i<ListOfX.length;i++){
            if (ListOfX [i]<=ListOfX[i-1]){
                return false;
            }
            if (ListOfY [i]>=ListOfY[i-1] && i!=1){
                return false;
            }
        }
        return true;
    } 
}