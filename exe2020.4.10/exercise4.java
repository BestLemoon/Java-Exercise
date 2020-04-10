import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.GregorianCalendar;
import java.util.Scanner;

class exe1 {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.width = 4;
        r1.height = 40;
        Rectangle r2 = new Rectangle();
        r2.width = 3.5;
        r2.height = 35.9;
        System.out.println(r1.width + " " + r1.height + " " + r1.getArea() + " " + r1.getPerimeter());
        System.out.println(r2.width + " " + r2.height + " " + r2.getArea() + " " + r2.getPerimeter());
    }
}

class Rectangle {
    double width = 1, height = 1;

    double getArea() {
        return width * height;
    }

    double getPerimeter() {
        return 2 * (width + height);
    }
}

class exe2 {
    public static void main(String[] args) {
        Stock stock = new Stock();
        stock.symbol = "ORCL";
        stock.name = "OracleCorporation";
        stock.previousClosingPrice = 34.5;
        stock.currentPrice = 34.35;
        System.out.println(stock.getChangePercent());
    }
}

class Stock {
    String symbol;
    String name;
    double previousClosingPrice;
    double currentPrice;

    double getChangePercent() {
        return currentPrice / previousClosingPrice;
    }
}

class exe3 {
    public static void main(String[] args) {
        long l = 10000;
        Date date = new Date(l);
        System.out.println(l + ": " + date.toString());
        l *= 10;
        for (int i = 0; i < 7; i++) {
            date.setTime(l);
            System.out.println(l + ": " + date.toString());
            l *= 10;
        }
    }
}

class exe4 {
    public static void main(String[] args) {
        Random ran = new Random(1000);
        for (int i = 0; i < 50; i++) {
            System.out.println(ran.nextInt(100));
        }
    }
}

class exe5 {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();
        System.out.println(calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DAY_OF_MONTH));
        calendar.setTimeInMillis(1234567898765L);
        System.out.println(calendar.get(Calendar.YEAR) + "/" + calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.DAY_OF_MONTH));
    }
}

class exe6 {
    public static void main(String[] args) {
        int[] nums = new int[10000];
        Random ran = new Random(1000);
        Stopwatch watch = new Stopwatch();
        watch.start();
        for (int i = 0; i < 10000; i++) {
            nums[i] = ran.nextInt(10000);
        }
        for (int i = 0; i < 10000; i++) {
            for (int j = i + 1; j < 10000; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        watch.stop();
        System.out.println(watch.getElapsedTime());
    }
}

class Stopwatch {
    double startTime, endTime;

    Stopwatch() {
        startTime = System.currentTimeMillis();
    }

    void start() {
        startTime = System.currentTimeMillis();
    }

    void stop() {
        endTime = System.currentTimeMillis();
    }

    double getElapsedTime() {
        return endTime - startTime;
    }
}

class exe7 {
    public static void main(String[] args) {
        Account test = new Account(1122, 20000);
        test.setAnnualInterestRate(4.5);
        test.withDraw(2500);
        test.deposit(3000);
        System.out.println(test.getBalance() + "," + test.getMonthlyInterest() + "," + test.getDateCreated());
    }
}

class Account {
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated;

    public Account() {
        dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterest() {
        return balance * annualInterestRate / 1200.0;
    }

    public void withDraw(double money) {
        balance -= money;
    }

    public void deposit(double money) {
        balance += money;
    }
}

class exe8 {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.setSpeed(3);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        fan2.setSpeed(2);
        fan2.setColor("blue");
        fan2.setRadius(5);
        fan2.setOn(false);
        System.out.println(fan1.FanToString());
        System.out.println(fan2.FanToString());
    }
}

class Fan {
    int SLOW = 1;
    int MEDIUM = 2;
    int FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    String color;

    public Fan() {
        color = "blue";
        radius = 5;
        on = false;
        speed = SLOW;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean getOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String FanToString() {
        if (on)
            return "speed:" + speed + " color:" + color + " radius:" + radius;
        else
            return "fan is off" + " color:" + color + " radius:" + radius;
    }


}

class exe9 {
    public static void main(String[] args) {
        RegularPolygon r1 = new RegularPolygon();
        RegularPolygon r2 = new RegularPolygon(6, 4);
        RegularPolygon r3 = new RegularPolygon(10, 4, 5.6, 7.8);
        System.out.println(r1.getPerimeter() + " " + r1.getArea());
        System.out.println(r2.getPerimeter() + " " + r2.getArea());
        System.out.println(r3.getPerimeter() + " " + r3.getArea());
    }
}

class RegularPolygon {
    private int n;
    private double side;
    private double x;
    private double y;

    public RegularPolygon() {
        n = 3;
        side = 1;
        x = 0;
        y = 0;
    }

    public RegularPolygon(double side, int n) {
        this.side = side;
        this.n = n;
        x = 0;
        y = 0;
    }

    public RegularPolygon(double side, int n, double x, double y) {
        this.side = side;
        this.n = n;
        this.x = x;
        this.y = y;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getPerimeter() {
        return side * n;
    }

    public double getArea() {
        return (n * side * side) / (4 * Math.tan(Math.PI / n));
    }

}

class exe10 {
    public static void main(String[] args) {
        QuadraticEquation question = new QuadraticEquation();
        question.getA();
        question.getB();
        question.getC();
        double delta = question.getDiscriminant();
        if (delta > 0) {
            System.out.println(question.getRoot1() + " " + question.getRoot2());
        } else if (delta == 0) {
            System.out.println(question.getRoot1());
        } else {
            System.out.println("The equation has no roots");
        }

    }
}

class QuadraticEquation {
    private double a, b, c;
    Scanner in = new Scanner(System.in);

    public void getA() {
        a = in.nextDouble();
    }

    public void getB() {
        b = in.nextDouble();
    }

    public void getC() {
        c = in.nextDouble();
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    public double getRoot1() {
        return (Math.sqrt(getDiscriminant()) - b) / (2 * a);
    }

    public double getRoot2() {
        return (-Math.sqrt(getDiscriminant()) - b) / (2 * a);
    }

}

class exe11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        int e = in.nextInt();
        int f = in.nextInt();
        LinearEquation q = new LinearEquation(a, b, c, d, e, f);
        if (q.isSolvable()) {
            System.out.println(q.getX() + "," + q.getY());
        } else
            System.out.println("The equation has no solution.");
    }
}

class LinearEquation {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;

    public LinearEquation(int a, int b, int c, int d, int e, int f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public boolean isSolvable() {
        return a * d - b * c != 0;
    }

    public double getX() { return (e * d - b * f) * 1.0 / (a * d - b * c); }

    public double getY() {
        return (a * f - e * c) * 1.0 / (a * d - b * c);
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }

    public int getE() {
        return e;
    }

    public int getF() {
        return f;
    }


}

class exe12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x1 = in.nextDouble();
        double x2 = in.nextDouble();
        double y1 = in.nextDouble();
        double y2 = in.nextDouble();
        double x3 = in.nextDouble();
        double x4 = in.nextDouble();
        double y3 = in.nextDouble();
        double y4 = in.nextDouble();
        double a = y1 - y2;
        double b = x2 - x1;
        double e = y1 * x2 - x1 * y2;
        double c = y3 - y4;
        double d = x4 - x3;
        double f = y3 * x4 - x3 * y4;
        System.out.println((e * d - b * f) * 1.0 / (a * d - b * c)+","+(a * f - e * c) * 1.0 / (a * d - b * c));
    }
}

class exe13 {
    public static void main(String[] args) {
        System.out.println("Enter the number of rows and colums of the array :");
        Scanner input = new Scanner(System.in);
        int row = input.nextInt();
        int column = input.nextInt();
        System.out.println("Enter the array");
        double[][] array = new double[row][column];
        for(int i=0 ;i < array.length;i++){
            for(int j=0 ;j <array[i].length ;j++ ){
                array[i][j] = input.nextDouble();
            }
        }
        Location  location1=locateLargest(array);
        System.out.println("The location of the largets element is "+location1.maxValue+" at "+"("+location1.row+","+location1.column+")");
    }
    public static Location locateLargest(double[][] a) {
        Location location = new Location();
        int row = 0;
        int column = 0;
        double maxValue = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(a[i][j]>maxValue){
                    maxValue=a[i][j];
                    row =i;
                    column=j;
                }
            }
        }
        location.row = row;
        location.column = column;
        location.maxValue = maxValue;
        return location;
    }
}
class Location{
    public  int row;
    public int column;
    public  double maxValue;
}


















