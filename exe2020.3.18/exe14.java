import java.util.Scanner;
public class exe14 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the first 9 digits of an ISBN as integer:");
        String ISBN=input.nextLine();
        int sum=0;
        for(int i=0;i<9;i++){
            sum+=(ISBN.charAt(i)-'0')*(i+1);
        }
        int d10=sum%11;
        System.out.println("The ISBN-10 number is "+ISBN+(d10==10?"X":d10));
    }
}
