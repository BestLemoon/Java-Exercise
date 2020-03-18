import java.util.Scanner;
public class exe6 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the amount of water in kilograms:");
        float amount=input.nextFloat();
        System.out.print("Enter the initial temperature:");
        float init_tmp=input.nextFloat();
        System.out.print("Enter the final temperature:");
        float final_tmp=input.nextFloat();
        float energy=amount*4184*(final_tmp-init_tmp);
        System.out.println("The energy needed is "+energy);
    }
}
