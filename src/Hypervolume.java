import java.util.Scanner;
class Hypervolume{
    public static void main (String[]args){
        Scanner scan =new Scanner(System.in);
  
        
        float [] ListOfX = {0,1,2,3,4};
        float  [] ListOfY= {0,4,3,2,1};
        float  AreaOfSolutions= CalculateArea (ListOfX,ListOfY);
        
        float  [] XOptimal ={0,5};
        float  [] YOptimal ={0,5};
        float  AreaOfOptimal= CalculateArea (XOptimal,YOptimal);
        
        float Hyper= CalculateHypervolume (AreaOfSolutions,AreaOfOptimal);
        System.out.println(Hyper);
    }
    
    public static float  CalculateArea(float  [] x, float [] y ){
        // float [], float [] -> float
        // return the area underneath the point(s)
        
        // CalculateArea({0,1,2,3,4},{0,4,3,2,1}) = 10
        // CalculateArea({0,1,2},{0,2,1}) = 3
        // CalculateArea({0,1.2,2.8},{0,6,4}) = 13.6
        
        float  area=0f;
        for (int i=1;i<x.length;i++){
            area += (x [i]-x[i-1])*y[i];
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
}