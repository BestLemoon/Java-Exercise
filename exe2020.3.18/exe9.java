import java.util.Scanner;
public class exe9 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter weight in pounds:");
        float weight=input.nextFloat();
        System.out.print("Enter height in inches:");
        float height=input.nextFloat();
        double bmi=(weight*0.45359237)/Math.pow(height*0.0254,2);
        System.out.println("BMI is "+bmi);
    }
}
