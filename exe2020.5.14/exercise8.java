import com.sun.org.apache.bcel.internal.generic.BIPUSH;

import javax.print.attribute.standard.Compression;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

abstract class GeometricObject implements Comparable {
    abstract public double getArea();

    abstract public double getPerimeter();

    abstract public GeometricObject max(GeometricObject o);

}

class Triangle extends GeometricObject {
    public double side1, side2, side3;
    public String color;
    public Boolean fill;

    public Triangle(double side1, double side2, double side3, String color, Boolean fill) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.color = color;
        this.fill = fill;
    }

    @Override
    public double getArea() {
        double p;
        double s;
        p = (side1 + side3 + side2) / 2;
        s = Math.sqrt(p * (p - side3) * (p - side2) * (p - side1));
        return s;
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public GeometricObject max(GeometricObject o) {
        return null;
    }

    @Override
    public String toString() {
        return " side1:" + side1 + " side2:" + side2 + " side3:" + side3 + " color:" + color + " filled:" + fill;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

class exe1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double side1 = in.nextDouble();
        double side2 = in.nextDouble();
        double side3 = in.nextDouble();
        String color = in.next();
        Boolean fill = in.nextBoolean();
        Triangle triangle = new Triangle(side1, side2, side3, color, fill);
        System.out.println(triangle.toString());
    }
}

class exe2 {
    public static void main(String[] args) {
        ArrayList<Number> numbers = new ArrayList<Number>(10);
        for (int i = 0; i < 10; i++) {
            numbers.add(i, Math.random() * 100);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(numbers.get(i));
        }
        System.out.println("================");
        shuffle(numbers);
        for (int i = 0; i < 10; i++) {
            System.out.println(numbers.get(i));
        }
    }

    public static void shuffle(ArrayList<Number> list) {
        Random random = new Random();
        for (int i = list.size() - 1; i > 1; i--) {
            int ran = random.nextInt(i);
            Number tmp = list.get(i);
            list.set(i, list.get(ran));
            list.set(ran, tmp);
        }
    }
}

class exe3 {
    public static void main(String[] args) {
        ArrayList<Number> numbers = new ArrayList<Number>(10);
        for (int i = 0; i < 10; i++) {
            numbers.add(i, Math.random() * 100);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(numbers.get(i));
        }
        sort(numbers);
        System.out.println("===================");
        for (int i = 0; i < 10; i++) {
            System.out.println(numbers.get(i));
        }
    }

    public static void sort(ArrayList<Number> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(i).doubleValue() > list.get(j).doubleValue()) {
                    Number tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }
        }
    }
}

class exe4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int month = in.nextInt();
        int year = in.nextInt();
        PrintCalendar printCalendar = new PrintCalendar(month, year);
        //printCalendar.print();
    }
}

class PrintCalendar {
    String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String[] weeks = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    int month, year;

    public PrintCalendar() {

    }

    public PrintCalendar(int month, int year) {
        print(month, year);
    }

    public static int getStartDay(int year, int month) {
        final int START_DAY_FOR_JAN_l_l800 = 3;
        int totalNumberOfDays = getTotalNumberOfDays(year, month);
        return (totalNumberOfDays + START_DAY_FOR_JAN_l_l800) % 7;
    }

    public static int getTotalNumberOfDays(int year, int month) {
        int total = 0;
        for (int i = 1800; i < year; i++)
            if (isleapYear(i))
                total = total + 366;
            else
                total = total + 365;
        for (int i = 1; i < month; i++)
            total = total + getNumberOfDaysInMonth(year, i);
        return total;
    }

    public void print(int month, int year) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        int day = getStartDay(year, month);
        System.out.println("\t\t" + months[month - 1] + ", " + year);
        System.out.println("---------------------------------------------");
        for (int i = 0; i < 7; i++) {
            System.out.print(weeks[i] + " ");

        }
        System.out.println();
        int count = 0;
        for (int i = 0; i < day; i++) {
            System.out.print("\t");
            count++;
        }
        for (int i = 1; i <= getNumberOfDaysInMonth(year, month); i++) {
            System.out.printf("%4d", i);
            count++;
            if (count % 7 == 0 && count != 0)
                System.out.println();
        }
    }

    public void print() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        int month = gregorianCalendar.get(Calendar.MONTH);
        int year = gregorianCalendar.get(Calendar.YEAR);
        int day = gregorianCalendar.get(Calendar.DAY_OF_WEEK) + 1;
        System.out.println("\t\t" + months[month] + ", " + year);
        System.out.println("---------------------------------------------");
        for (int i = 0; i < 7; i++) {
            System.out.print(weeks[i] + " ");

        }
        System.out.println();
        int count = 0;
        for (int i = 0; i < day; i++) {
            System.out.print("\t");
            count++;
        }
        for (int i = 1; i <= getNumberOfDaysInMonth(year, month + 1); i++) {
            System.out.printf("%4d", i);
            count++;
            if (count % 7 == 0 && count != 0)
                System.out.println();
        }
    }

    public static int getNumberOfDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            return 31;
        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        if (month == 2) return isleapYear(year) ? 29 : 28;
        return 0;
    }

    public static boolean isleapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}

class exe5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Circle r1 = new Circle(in.nextDouble());
        Circle r2 = new Circle(in.nextDouble());
        System.out.println(r1.max(r2).getArea());
    }
}

class Circle extends GeometricObject implements Colorable {
    public double radius;

    public boolean isColorable() {
        return colorable;
    }

    public boolean colorable;

    public Circle(boolean colorable) {
        this.colorable = colorable;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public GeometricObject max(GeometricObject o) {
        return this.getArea() > o.getArea() ? this : o;
    }

    @Override
    public int compareTo(Object o) {
        Circle r = (Circle) o;
        return (int) (this.getArea() - r.getArea());
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }
}

class exe6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Circle r1 = new Circle(in.nextDouble());
        Circle r2 = new Circle(in.nextDouble());
        System.out.println(r1.compareTo(r2));
    }
}

interface Colorable {
    public void howToColor();
}

class Square extends GeometricObject {
    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return 0;
    }

    @Override
    public GeometricObject max(GeometricObject o) {
        return null;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

class exe7 {
    public static void main(String[] args) {
        Circle[] circles = {new Circle(true), new Circle(false), new Circle(true), new Circle(true), new Circle(false)};
        for (int i = 0; i < 5; i++) {
            if (circles[i].isColorable()) {
                circles[i].howToColor();
            } else
                System.out.println("Not Colorable");
        }
    }
}

class MyStack implements Cloneable {
    private ArrayList<Object> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public Object peek() {
        return list.get(getSize() - 1);
    }

    public Object pop() {
        Object o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public void push(Object o) {
        list.add(0);
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "list=" + list +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ArrayList<Object> listcp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listcp.add(list.get(i));
        }
        return super.clone();
    }
}


class Circle1 extends GeometricObject implements Comparable {
    private double radius;

    public Circle1() {
    }

    public Circle1(double radius) {
        this.radius = radius;
    }

    /**
     * Return radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Set a new radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    /** Return area */
    public double getArea() {
        return radius * radius * Math.PI;
    }

    /**
     * Return diameter
     */
    public double getDiameter() {
        return 2 * radius;
    }

    @Override
    /** Return perimeter */
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public GeometricObject max(GeometricObject o) {
        return null;
    }

    /* Print the circle info */
    public void printCircle() {
        System.out.println("the radius is " + radius);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle1 circle1 = (Circle1) o;
        return Double.compare(circle1.radius, radius) == 0;
    }
}

class Rectangle extends GeometricObject implements Comparable {
    private double width;
    private double height;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Set a new width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Set a new height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    /** Return area */
    public double getArea() {
        return width * height;
    }

    @Override
    /** Return perimeter */
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public GeometricObject max(GeometricObject o) {
        return null;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.getArea(), getArea()) == 0 &&
                Double.compare(rectangle.getArea(), getArea()) == 0;
    }
}

class Octagon extends GeometricObject implements Comparable, Cloneable {
    public double side;

    @Override
    public double getArea() {
        return (2 + 4.0 / Math.sqrt(2)) * side * side;
    }

    @Override
    public double getPerimeter() {
        return 8 * side;
    }

    @Override
    public GeometricObject max(GeometricObject o) {
        return null;
    }

    @Override
    public int compareTo(Object o) {
        Octagon tmp = (Octagon) o;
        return (int) (this.side - tmp.side);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

class exe12 {
    public static void main(String[] args) {
        GeometricObject[] geometricObjects = {new Circle1(1), new Circle1(1), new Rectangle(1, 3), new Rectangle(1, 3)};
        System.out.println(sumArea(geometricObjects));
    }

    public static double sumArea(GeometricObject[] a) {
        double sumArea = 0;
        for (int i = 0; i < a.length; i++) {
            sumArea += a[i].getArea();
        }
        return sumArea;
    }
}

class Course implements Cloneable {
    private String courseName;
    private String[] students = new String[4];
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    public String[] getStudents() {
        return students;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String student) {
        // Left as an exercise in Exercise 10.9
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        String[] stucp = new String[students.length];
        for (int i = 0; i < students.length; i++) {
            stucp[i] = students[i];
        }
        return super.clone();
    }
}

class Rational extends Number implements Comparable<Rational> {
    // Data fields for numerator and denominator
    private long numerator = 0;
    private long denominator = 1;

    /**
     * Construct a rational with default properties
     */
    public Rational() {
        this(0, 1);
    }

    /**
     * Construct a rational with specified numerator and denominator
     */
    public Rational(long numerator, long denominator) {
        long gcd = gcd(numerator, denominator);
        this.numerator = (denominator > 0 ? 1 : -1) * numerator / gcd;
        this.denominator = Math.abs(denominator) / gcd;
    }

    /**
     * Find GCD of two numbers
     */
    private static long gcd(long n, long d) {
        long n1 = Math.abs(n);
        long n2 = Math.abs(d);
        int gcd = 1;

        for (int k = 1; k <= n1 && k <= n2; k++) {
            if (n1 % k == 0 && n2 % k == 0)
                gcd = k;
        }

        return gcd;
    }

    /**
     * Return numerator
     */
    public long getNumerator() {
        return numerator;
    }

    /**
     * Return denominator
     */
    public long getDenominator() {
        return denominator;
    }

    /**
     * Add a rational number to this rational
     */
    public Rational add(Rational secondRational) {
        long n = numerator * secondRational.getDenominator() +
                denominator * secondRational.getNumerator();
        long d = denominator * secondRational.getDenominator();
        return new Rational(n, d);
    }

    /**
     * Subtract a rational number from this rational
     */
    public Rational subtract(Rational secondRational) {
        long n = numerator * secondRational.getDenominator()
                - denominator * secondRational.getNumerator();
        long d = denominator * secondRational.getDenominator();
        return new Rational(n, d);
    }

    /**
     * Multiply a rational number to this rational
     */
    public Rational multiply(Rational secondRational) {
        long n = numerator * secondRational.getNumerator();
        long d = denominator * secondRational.getDenominator();
        return new Rational(n, d);
    }

    /**
     * Divide a rational number from this rational
     */
    public Rational divide(Rational secondRational) {
        long n = numerator * secondRational.getDenominator();
        long d = denominator * secondRational.numerator;
        return new Rational(n, d);
    }

    @Override
    public String toString() {
        if (denominator == 1)
            return numerator + "";
        else
            return numerator + "/" + denominator;
    }

    @Override // Override the equals method in the Object class
    public boolean equals(Object other) {
        if ((this.subtract((Rational) (other))).getNumerator() == 0)
            return true;
        else
            return false;
    }

    @Override // Implement the abstract intValue method in Number
    public int intValue() {
        return (int) doubleValue();
    }

    @Override // Implement the abstract floatValue method in Number
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override // Implement the doubleValue method in Number
    public double doubleValue() {
        return numerator * 1.0 / denominator;
    }

    @Override // Implement the abstract longValue method in Number
    public long longValue() {
        return (long) doubleValue();
    }

    @Override // Implement the compareTo method in Comparable
    public int compareTo(Rational o) {
        if (this.subtract(o).getNumerator() > 0)
            return 1;
        else if (this.subtract(o).getNumerator() < 0)
            return -1;
        else
            return 0;
    }
}

class Rational1 extends Number implements Comparable<Rational1> {
    // Data fields for numerator and denominator
    private BigInteger numerator = BigInteger.ZERO;
    private BigInteger denominator = BigInteger.ONE;

    /**
     * Construct a rational with default properties
     */
    public Rational1() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    /**
     * Construct a rational with specified numerator and denominator
     */
    public Rational1(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = gcd(numerator, denominator);
        this.numerator = (denominator.compareTo(BigInteger.ZERO) > 0 ? BigInteger.ONE : BigInteger.ONE.negate()).multiply(numerator).divide(gcd);
        this.denominator = denominator.abs().divide(gcd);
    }

    /**
     * Find GCD of two numbers
     */
    private static BigInteger gcd(BigInteger n, BigInteger d) {
        BigInteger n1 = n.abs();
        BigInteger n2 = d.abs();
        BigInteger gcd = BigInteger.ONE;
        BigInteger remainder = n1.remainder(n2);
        while (remainder.compareTo(BigInteger.ZERO) > 0) {
            n1 = n2;
            n2 = remainder;
            remainder = n1.remainder(n2);
        }
        return n2;
    }

    /**
     * Return numerator
     */
    public BigInteger getNumerator() {
        return numerator;
    }

    /**
     * Return denominator
     */
    public BigInteger getDenominator() {
        return denominator;
    }

    /**
     * Add a rational number to this rational
     */
    public Rational1 add(Rational1 secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator()).add(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational1(n, d);
    }

    /**
     * Subtract a rational number from this rational
     */
    public Rational1 subtract(Rational1 secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator()).subtract(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational1(n, d);
    }

    /**
     * Multiply a rational number to this rational
     */
    public Rational1 multiply(Rational1 secondRational) {
        BigInteger n = numerator.multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational1(n, d);
    }

    /**
     * Divide a rational number from this rational
     */
    public Rational1 divide(Rational1 secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator());
        BigInteger d = denominator.multiply(secondRational.numerator);
        return new Rational1(n, d);
    }

    @Override
    public String toString() {
        if (denominator.compareTo(BigInteger.ONE) == 0)
            return numerator + "";
        else
            return numerator + "/" + denominator;
    }

    @Override // Override the equals method in the Object class
    public boolean equals(Object other) {
        if ((this.subtract((Rational1) (other))).getNumerator().compareTo(BigInteger.ZERO) == 0)
            return true;
        else
            return false;
    }

    @Override // Implement the abstract intValue method in Number
    public int intValue() {
        return (int) doubleValue();
    }

    @Override // Implement the abstract floatValue method in Number
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override // Implement the doubleValue method in Number
    public double doubleValue() {
        return numerator.multiply(BigInteger.ONE).divide(denominator).doubleValue();
    }

    @Override // Implement the abstract longValue method in Number
    public long longValue() {
        return (long) doubleValue();
    }

    @Override // Implement the compareTo method in Comparable
    public int compareTo(Rational1 o) {
        if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) > 0)
            return 1;
        else if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) < 0)
            return -1;
        else
            return 0;
    }
}

class Calculator {
    public static void main(String[] aaaa) {
        System.out.println("Usage: java Calculator operand1 operator operand2");
        Scanner in = new Scanner(System.in);
        String args = in.nextLine();
        int result1 = 0;
        int result2 = 0;
        args = args.replace(" ", "");
        String[] strings = args.split("\\+|-|\\*|/");
//        for(int i=0;i<strings.length;i++){
//            System.out.println(strings[i]);
//        }
        int a = Integer.parseInt(strings[0]);
        int b = Integer.parseInt(strings[1]);
        int c = Integer.parseInt(strings[2]);
        int d = Integer.parseInt(strings[3]);
        switch (args.charAt(strings[0].length() + strings[1].length() + 1)) {
            case '+':
                result1 = a * d + b * c;
                result2 = b * d;
                break;
            case '-':
                result1 = a * d - b * c;
                result2 = b * d;
                break;
            case '*':
                result1 = a * b;
                result2 = c * d;
                break;
            case '/':
                result1 = a * d;
                result2 = b * c;
                break;
        }
        // Display result
        System.out.println(a + "/" + b + " " + args.charAt(strings[0].length() + strings[1].length() + 1) + " " + c + "/" + d + " = " + result1 + '/' + result2);
    }
}

class exe17 {
    public static void main(String[] args) {
        System.out.println("Enter the first complex number:");
        System.out.println("Enter the second complex number:");
        Scanner in = new Scanner(System.in);
        Complex complex1 = new Complex(in.nextDouble(), in.nextDouble());
        Complex complex2 = new Complex(in.nextDouble(), in.nextDouble());
        System.out.println(complex1.toString() + " + " + complex2 + " = " + complex1.add(complex2).toString());
        System.out.println(complex1.toString() + " - " + complex2 + " = " + complex1.substract(complex2).toString());
        System.out.println(complex1.toString() + " * " + complex2 + " = " + complex1.multiply(complex2).toString());
        System.out.println(complex1.toString() + " / " + complex2 + " = " + complex1.divide(complex2).toString());
        System.out.println("|" + complex1.toString() + "|" + " = " + complex1.abs());
    }
}

class Complex implements Cloneable {
    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    double real, imaginary;

    public Complex() {
        real = 0;
        imaginary = 0;
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex(double real) {
        this.real = real;
        this.imaginary = 0;
    }

    public Complex add(Complex num) {
        Complex tmp = new Complex();
        tmp.real = this.real + num.real;
        tmp.imaginary = this.imaginary + num.imaginary;
        return tmp;
    }

    public Complex substract(Complex num) {
        Complex tmp = new Complex();
        tmp.real = this.real - num.real;
        tmp.imaginary = this.imaginary - num.imaginary;
        return tmp;
    }

    public Complex multiply(Complex num) {
        Complex tmp = new Complex();
        tmp.real = this.real * num.real - this.imaginary * num.imaginary;
        tmp.imaginary = this.imaginary * num.real + this.real * num.imaginary;
        return tmp;
    }

    public Complex divide(Complex num) {
        Complex tmp = new Complex();
        tmp.real = (this.real * num.real + this.imaginary * num.imaginary) / (Math.pow(num.imaginary, 2) + Math.pow(num.real, 2));
        tmp.imaginary = (this.imaginary * num.real - this.real * num.imaginary) / (Math.pow(num.imaginary, 2) + Math.pow(num.real, 2));
        return tmp;
    }

    public double abs() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
    }

    @Override
    public String toString() {
        return real + "+" + imaginary + "i";
    }
}

class exe18 {
    public static void main(String[] args) {
        Rational1 sum = new Rational1();
        for (int i = 1; i < 100; i++) {
            Rational1 rational = new Rational1(new BigInteger(String.valueOf(i)), new BigInteger(String.valueOf(i + 1)));
            sum.add(rational);
        }
        System.out.println(sum.toString());
    }
}

class exe19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String exp = in.nextLine();
        Double num = Double.parseDouble(exp);
        String[] nums = exp.split("\\.");
        Rational1 rnum = new Rational1(new BigDecimal(num).toBigInteger().multiply(new BigDecimal(Math.pow(10, nums[1].length())).toBigInteger()), new BigDecimal(Math.pow(10, nums[1].length())).toBigInteger());
        System.out.println(rnum.toString());
    }
}

class exe20 {
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
            System.out.println("The roots are " + question.getComplexRoot1(a, b, c).toString() + " and " + question.getComplexRoot2(a, b, c).toString());
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

    public Complex getComplexRoot1(double a, double b, double c) {
        double delta = 4 * a * c - b * b;
        Complex root1 = new Complex(-b / 2 / a, Math.sqrt(delta) / 2 / a);
        return root1;
    }

    public Complex getComplexRoot2(double a, double b, double c) {
        double delta = 4 * a * c - b * b;
        Complex root2 = new Complex(-b / 2 / a, -Math.sqrt(delta) / 2 / a);
        return root2;
    }
}

class exe21 {
    public static void main(String[] args) {
        System.out.println("Enter a,b,c:");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        double h = -b / a / 2.0;
        double k = c - a * h * h;
        System.out.println("h is " + h + " k is " + k);
    }
}












































































