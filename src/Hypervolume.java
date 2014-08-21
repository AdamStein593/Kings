import java.util.Scanner;
class Hypervolume{
    public static void main (String[]args){
        Scanner scan =new Scanner(System.in);
  
        
        float [] ListOfX = {0,4,3,2,1};
        float  [] ListOfY= {0,4,3,2,1};
        float  a= CalculateArea (ListOfX,ListOfY);
        
        float  [] XOptimal ={0,5};
        float  [] YOptimal ={0,5};
        float  b= CalculateArea (XOptimal,YOptimal);
        
        float Hyper= CalculateHypervolume (a,b);
        System.out.println(a);
        System.out.println(b);
        System.out.println(Hyper);
    }
    
    public static float  CalculateArea(float  [] x, float [] y ){
        float  area=0f;
        for (int i=1;i<x.length;i++){
            area += (x [i]-x[i-1])*y[i];
        }
        return area;
    }
    
    public static float CalculateHypervolume(float  a, float  b ){
        float HyperVolume = a/b;
        return HyperVolume;
    }
}