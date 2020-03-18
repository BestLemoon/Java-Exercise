import java.util.Scanner;
public class exe16 {
    public static void main(String[] args) {
        String[] game={"scissor","rock","paper"};
        Scanner input=new Scanner(System.in);
        System.out.print("scissor(0),rock(1),paper(2):");
        int user=input.nextInt();
        int computer=(int)(Math.random()*3);
        if(user==computer){
            System.out.println("The computer is "+game[computer]+".You are "+game[user]+".It is draw");
        }
        else{
            if(user==0&&computer==2||user==1&&computer==0||user==2&&computer==1){
                System.out.println("The computer is "+game[computer]+".You are "+game[user]+".You won");
            }
            else {
                System.out.println("The computer is "+game[computer]+".You are "+game[user]+".You lost");
            }
        }
    }
}
