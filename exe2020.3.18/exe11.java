import java.util.Scanner;
public class exe11 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter balance and annual interest rate:");
        float balance=input.nextFloat();
        float rate=input.nextFloat();
        float interest=balance*(rate/1200);
        System.out.println("The interest is "+interest);
    }
}
