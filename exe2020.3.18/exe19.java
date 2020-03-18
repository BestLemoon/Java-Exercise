import java.util.Scanner;
public class exe19 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter an integer:");
        int num=input.nextInt();
        System.out.println("Is "+num+"divisible by 5 and 6? "+(num%6==0&&num%5==0));
        System.out.println("Is "+num+"divisible by 5 or 6? "+(num%6==0||num%5==0));
        System.out.println("Is "+num+"divisible by 5 or 6?,but not both? "+(num%6==0&&num%5!=0||num%6!=0&&num%5==0));
    }
}
