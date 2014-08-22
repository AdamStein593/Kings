package HypervolumeCalculation;

public class Solutions{
    private int [] cords=new int[2];
    public Solutions(int [] coordinates){
        cords[0]=coordinates[0];
        cords[1]=coordinates[1];
    }
    
    
   public int area(){
        int a=cords[0]*cords[1];
        return a;
    } 
}