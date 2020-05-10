import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

import java.util.Date;
import java.util.Scanner;

class exe1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char expression = '\u0000';
        int a = 0, b = 0;
        try {
            a = Integer.parseInt(in.next());
            expression = in.next().charAt(0);
            b = Integer.parseInt(in.next());
        } catch (Exception e) {
            System.out.println("Wrong input :" + e.getMessage().substring(19, e.getMessage().length() - 1));
            System.exit(0);
        }
        int result = 0;
        switch (expression) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
        }
        System.out.println(a + " " + expression + " " + b + " = " + result);
    }
}

class exe2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Enter two integer");
            int a = 0, b = 0;
            try {
                a = Integer.parseInt(in.next());
                b = Integer.parseInt(in.next());

            } catch (Exception e) {
                System.out.println("Wrong numbers.Try again");
                continue;
            }
            System.out.println(a + "+" + b + "=" + (a + b));
        }
    }
}

class Loan {
    private double annuallnterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;
    private Object IllegalArgumentException;

    public double getAnnuallnterestRate() {
        return annuallnterestRate;
    }

    public void setAnnuallnterestRate(double annuallnterestRate) throws Throwable {
        if (annuallnterestRate <= 0) {
            throw (Throwable) IllegalArgumentException;
        }
        this.annuallnterestRate = annuallnterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) throws Throwable {
        if (numberOfYears <= 0) {
            throw (Throwable) IllegalArgumentException;
        }
        this.numberOfYears = numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) throws Throwable {
        if (loanAmount <= 0) {
            throw (Throwable) IllegalArgumentException;
        }
        this.loanAmount = loanAmount;
    }

    public Loan() {
        this(2.5, 1, 1000);
    }

    public Loan(double annualinterestRate, int numberOfYears, double loanAmount) {
        this.annuallnterestRate = annualinterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new java.util.Date();
    }

    public double getMonthlyPayment() {
        double monthlyinterestRate = annuallnterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyinterestRate / (1 - (1 / Math.pow(1 + monthlyinterestRate, numberOfYears * 12)));
        return monthlyPayment;
    }

    public double getTotalPayment() {
        double totalPayment = getMonthlyPayment() * numberOfYears * 12;
        return totalPayment;
    }

    public Date getLoanDate() {
        return loanDate;
    }
}

class IllegalTriangleException extends Exception {
    private double side1, side2, side3;

    public IllegalTriangleException(double side1, double side2, double side3) {
        super("Invalid Triangle:" + side1 + side2 + side3);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
}

class Hex2Dec {
    private static Object NumberFormatException;

    public static void main(String[] args) throws Throwable {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a hex number: ");
        String hex = input.nextLine();
        for (int i = 0; i < hex.length(); i++) {
            if (!(hex.charAt(i) >= '0' && hex.charAt(i) <= '9' || hex.charAt(i) >= 'A' && hex.charAt(i) <= 'F')) {
                throw (Throwable) NumberFormatException;
            }
        }
        System.out.println("The decimal value for hex number " + hex + " is " + hexToDecimal(hex.toUpperCase()));
    }

    public static int hexToDecimal(String hex) {
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            decimalValue = decimalValue * 16 + hexCharToOecimal(hexChar);
        }
        return decimalValue;
    }

    public static int hexCharToOecimal(char ch) {
        if (ch >= 'A' && ch <= 'F')
            return 10 + ch - 'A';
        else
            return ch - '0';
    }
}

class bin2Dec {
    private static Object NumberFormatException;

    public static void main(String[] args) throws Throwable {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a bin number: ");
        String bin = input.nextLine();
        for (int i = 0; i < bin.length(); i++) {
            if (!(bin.charAt(i) >= '0' && bin.charAt(i) <= '1')) {
                throw (Throwable) NumberFormatException;
            }
        }
        System.out.println("The decimal value for bin number" + bin + " is " + binToDecimal(bin));
    }

    public static int binToDecimal(String bin) {
        int result = 0, j = 0;
        for (int i = bin.length() - 1; i >= 0; i--) {
            result += Math.pow(2, j++) * (bin.charAt(i) - '0');
        }
        return result;
    }
}

class exe8 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println(Hex2Dec(in.nextLine()));
    }

    public static int Hex2Dec(String hex) throws BinaryFormatException {
        if (!isHex(hex)) {
            throw new BinaryFormatException(hex + " is not a hex number.");
        }
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            decimalValue = decimalValue * 16 + hexCharToOecimal(hexChar);
        }
        return decimalValue;
    }
    public static int hexCharToOecimal(char ch) {
        if (ch >= 'A' && ch <= 'F')
            return 10 + ch - 'A';
        else
            return ch - '0';
    }
    public static boolean isHex(String hex) {
        for (int i = 0; i < hex.length(); i++) {
            if (!(hex.charAt(i) >= '0' && hex.charAt(i) <= '9' || hex.charAt(i) >= 'A' && hex.charAt(i) <= 'F')) {
                return false;
            }
        }
        return true;
    }

}

class HexFormatException extends IllegalArgumentException {
    HexFormatException(String s) {
        super(s);
    }
}

class exe9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(bin2Dec(in.nextLine()));
    }

    public static int bin2Dec(String binary) throws BinaryFormatException {
        if (!isBinary(binary)) {
            throw new BinaryFormatException(binary + " is not a binary number.");
        }
        int power = 0;
        int decimal = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {

            if (binary.charAt(i) == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }
        return decimal;
    }

    public static boolean isBinary(String binary) {

        for (char ch : binary.toCharArray()) {
            if (ch != '1' && ch != '0') return false;
        }
        return true;
    }

}

class BinaryFormatException extends IllegalArgumentException {

    BinaryFormatException(String s) {
        super(s);
    }
}

class exe10 {
    public static void main(String[] args) {
        try {
            int[] Array=new int[Integer.MAX_VALUE];
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}













