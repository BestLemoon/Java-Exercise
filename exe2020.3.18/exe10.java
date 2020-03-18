import java.util.Scanner;
public class exe10 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the side:");
        float side=input.nextFloat();
        double area=Math.pow(3,0.5)*3/2*Math.pow(side,2);
        System.out.println("The area of the hexagon is "+area);
    }
}
