import java.util.Scanner;
public class exe13 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int a=(int)(Math.random()*10);
        int b=(int)(Math.random()*10);
        int c=(int)(Math.random() * 10);
        System.out.print("Please enter the sum of "+a+" and "+b+" and "+c+":");
        int sum=input.nextInt();
        if(sum==a+b+c){
            System.out.println("Right!");
        }
        else{
            System.out.println("Wrong!");
        }


    }
}
