import java.util.Scanner;
public class exe8 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the amount to be saved for each month:");
        float amount=input.nextFloat();
        System.out.print("Enter the annual interest rate:");
        float rate=input.nextFloat();
        System.out.print("Enter the number of month:");
        int months=input.nextInt();
        double sum=0;
        for(int i=0;i<months;i++){
            sum=(amount+sum)*(1+rate*0.01/12);
        }
        System.out.printf("After the %dth month,the account value is %f",months,sum);
    }
}
