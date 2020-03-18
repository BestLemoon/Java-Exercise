import java.util.Scanner;
public class exe21 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter three points for p0,p1 and p2:");
        float p0x=input.nextFloat();
        float p0y=input.nextFloat();
        float p1x=input.nextFloat();
        float p1y=input.nextFloat();
        float p2x=input.nextFloat();
        float p2y=input.nextFloat();
        float flag=(p1x-p0x)*(p2y-p0y)-(p2x-p0x)*(p1y-p0y);
        if(flag<0){
            System.out.printf("(%.1f,%.1f) is on the right side of the line from (%.1f,%.1f) to (%.1f,%.1f)",p2x,p2y,p0x,p0y,p1x,p1y);
        }
        else if(flag>0){
            System.out.printf("(%.1f,%.1f) is on the left side of the line from (%.1f,%.1f) to (%.1f,%.1f)",p2x,p2y,p0x,p0y,p1x,p1y);
        }
        else{
            System.out.printf("(%.1f,%.1f) is on the line from (%.1f,%.1f) to (%.1f,%.1f)",p2x,p2y,p0x,p0y,p1x,p1y);
        }

    }
}
