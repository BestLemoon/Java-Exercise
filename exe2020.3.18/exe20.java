import java.util.Scanner;
public class exe20 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the exchange rate from dollars to RMB:");
        float rate=input.nextFloat();
        System.out.print("Enter 0 to convert dollars to RMB and 1 vice versa:");
        int flag=input.nextInt();
        switch (flag){
            case 0:
                System.out.print("Enter the dollar amount:");
                float amount1=input.nextFloat();
                double sum1=amount1*rate;
                System.out.println("$"+amount1+" is "+sum1+" Yuan");
                break;
            case 1:
                System.out.print("Enter the dollar amount:");
                float amount2=input.nextFloat();
                double sum2=amount2/rate;
                System.out.println(amount2+" Yuan is "+"$"+sum2);
                break;
            default:
                System.out.println("Incorrect input");
                break;
        }




    }
}
