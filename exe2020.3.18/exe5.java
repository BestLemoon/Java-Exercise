import java.util.Scanner;
public class exe5 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter an integer between 0 and 1000:");
        int num=input.nextInt();
        int num1=num;
        int sum=0;
        while (num!=0){
            sum+=num%10;
            num/=10;
        }
        System.out.println("The sum of all digitals in "+num1+" is "+sum);
    }
}
