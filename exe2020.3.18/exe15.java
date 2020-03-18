import java.util.Scanner;
public class exe15 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter a three-digit integer:");
        int num=input.nextInt();
        if(num%10==num/100){
            System.out.println(num+" is a palindrome");
        }
        else{
            System.out.println(num+" is not a palindrome");
        }
    }
}
