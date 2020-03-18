import java.util.Scanner;
public class exe7 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter speed v:");
        float v=input.nextFloat();
        System.out.print("Enter acceleration a:");
        float a=input.nextFloat();
        double s=v*v/(2.0*a);
        System.out.println("The minimum runway length for this airplane is "+s+" meters");
    }
}
