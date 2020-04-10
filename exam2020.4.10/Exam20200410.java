import java.util.Scanner;

class exe1 {
    public static void main(String[] args) {
        QuadraticEquation question = new QuadraticEquation();
        Scanner in = new Scanner(System.in);
        System.out.print("Please Enter the a,b,c in ax^2+bx+c=0:");
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        double delta = question.getDiscriminant(a, b, c);
        if (delta > 0) {
            System.out.println("root1: " + question.getRoot1(a, b, c) + " root2:" + question.getRoot2(a, b, c));
        } else if (delta == 0) {
            System.out.println("root: " + question.getRoot1(a, b, c));
        } else {
            System.out.println("The equation has no roots");
        }
    }
}

class QuadraticEquation {
    public double getDiscriminant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    public double getRoot1(double a, double b, double c) {
        return (Math.sqrt(getDiscriminant(a, b, c)) - b) / (2 * a);
    }

    public double getRoot2(double a, double b, double c) {
        return (-Math.sqrt(getDiscriminant(a, b, c)) - b) / (2 * a);
    }

}

class exe2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the pass you want to check: ");
        String pass = in.nextLine();
        if (checkPass(pass))
            System.out.println("Valid Password");
        else
            System.out.println("Invalid Password");
    }

    public static boolean checkPass(String pass) {
        int count = 0;
        boolean flag = false;
        if (pass.length() < 8)
            return false;
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isLetter(pass.charAt(i)))
                flag = true;
            if (Character.isDigit(pass.charAt(i)))
                count++;
        }
        if (count <= 2 || count == 0 || !flag)
            return false;
        return true;
    }
}