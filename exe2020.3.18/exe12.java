import java.util.Scanner;
public class exe12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a,b,c for the equation:");
        float a=input.nextFloat();
        float b=input.nextFloat();
        float c=input.nextFloat();
        double delta=b*b-4*a*c;
        if(delta<0){
            System.out.println("The equation has no real roots");
        }
        else if(delta==0){
            double root=((Math.pow(delta,0.5)-b)/(2*a));
            System.out.println("The equation has one root "+root);
        }
        else{
            double root1=((Math.pow(delta,0.5)-b)/(2*a));
            double root2=((-Math.pow(delta,0.5)-b)/(2*a));
            System.out.println("The equation has two roots "+root1+" and "+root2);
        }

    }
}
