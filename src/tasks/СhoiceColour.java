package tasks;
//
public class СhoiceColour {
    public static void printColor(){
        int value = 8;
       String colour = (value<=0)?"Красный":(value>0 && value <=100)?"Жёлтый":"Зелёный";
       System.out.println(colour);
    }
}
