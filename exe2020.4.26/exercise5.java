import sun.rmi.runtime.Log;

import java.awt.geom.Line2D;
import java.lang.invoke.MutableCallSite;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class exe1 {
    public static void main(String[] args) {
        Time time = new Time();
        System.out.println(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond());
        Time time1 = new Time(55550000);
        time1.setTime(55550000);
    }
}

class Time {
    private int hour;
    private int minute;
    private int second;
    public long totalMilliSeconds = System.currentTimeMillis();

    public Time() {
        long totalSeconds = totalMilliSeconds / 1000;
        second = (int) (totalSeconds % 60);
        long totalMinutes = totalSeconds / 60;
        minute = (int) (totalMinutes % 60);
        long totalHour = totalMinutes / 60;
        hour = (int) (totalHour % 24);
    }

    public Time(long time) {
        this.totalMilliSeconds = time;
    }

    public void setTime(long Time) {
        long H = Time / (60 * 60 * 1000);
        long M = (Time % (60 * 60 * 1000)) / 60;
        long S = (Time % (60 * 60 * 1000)) % 60;
        System.out.println("如果流逝的时间为" + Time + "毫秒，则转换为" + H + "小时、" + M + "分钟、" + S + "秒。");
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

}

class exe3 {
    public static void main(String[] args) {
        MyInteger n1 = new MyInteger(5);
        System.out.println("n1 is even? " + n1.isEven());
        System.out.println("n1 is prime? " + n1.isPrime());
        System.out.println("15 is prime? " + MyInteger.isPrime(15));
        char[] chars = {'3', '5', '3', '9'};
        System.out.println(MyInteger.parseInt(chars));
        String s = "3539";
        System.out.println(MyInteger.parseInt(s));
        MyInteger n2 = new MyInteger(24);
        System.out.println("n2 is odd? " + n2.isOdd());
        System.out.println("45 is odd? " + MyInteger.isOdd(45));
        System.out.println("n1 is equal to n2? " + n1.equals(n2));
        System.out.println("n1 is equal to 5? " + n1.equals(5));
    }
}

class MyInteger {
    public int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEven() {
        return value % 2 == 0;
    }

    public boolean isOdd() {
        return value % 2 != 0;
    }

    public boolean isPrime() {
        if (value != 1 && value != 2) {
            for (int i = 2; i <= value / 2; i++) {
                if (value % i == 0)
                    return false;
            }
        }
        return true;
    }

    public boolean isEven(int value) {
        return value % 2 == 0;
    }

    public static boolean isOdd(int value) {
        return value % 2 != 0;
    }

    public static boolean isPrime(int value) {
        if (value != 1 && value != 2) {
            for (int i = 2; i <= value / 2; i++) {
                if (value % i == 0)
                    return false;
            }
        }
        return true;
    }

    public boolean isEven(MyInteger value) {
        return value.isEven();
    }

    public boolean isOdd(MyInteger value) {
        return value.isOdd();
    }

    public boolean isPrime(MyInteger value) {
        return value.isPrime();
    }

    public boolean equals(int value) {
        return this.value == value;
    }

    public boolean equals(MyInteger value) {
        return value.equals(this.value);
    }

    public static int parseInt(char[] chars) {
        return Integer.parseInt(chars.toString());
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}

class exe4 {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint(0, 0);
        MyPoint p2 = new MyPoint(10, 30.5);
        System.out.println(p1.distance(p2));
    }
}

class MyPoint {
    public double x;
    public double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public MyPoint() {
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(MyPoint point) {
        return Math.sqrt(Math.pow(point.x - this.x, 2) + Math.pow(point.y - this.y, 2));
    }

    public double distance(double x, double y) {
        return Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
    }
}

class exe5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        StackOfInteger n = new StackOfInteger(num);
        int j = 0;
        for (int i = 2; i <= num; i++) {
            if (isPrime(i)) {
                while (num % i == 0) {
                    num /= i;
                    n.push(i);
                }
            }
        }
        n = StackOfInteger.sortStack(n);
        int size = n.getSize();
        for (int i = 0; i < size; i++) {
            System.out.print(n.pop() + " ");
        }
    }

    public static boolean isPrime(int num) {
        if (num != 1 && num != 2) {
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0)
                    return false;
            }
        }
        return true;
    }


}

class StackOfInteger {
    private int[] elements;
    private int size;
    public static final int DEFAULT_CAPACITY = 16;

    StackOfInteger() {
    }

    StackOfInteger(int capacity) {
        elements = new int[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        return elements[size - 1];
    }

    public void push(int value) {
        if (size >= elements.length) {
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        elements[size++] = value;
    }

    public int pop() {
        return elements[--size];
    }

    public int getSize() {
        return size;
    }

    public static StackOfInteger sortStack(StackOfInteger input) {
        StackOfInteger tmpStack = new StackOfInteger(input.getSize());
        while (!input.isEmpty()) {
            int tmp = input.pop();
            while (!tmpStack.isEmpty() && tmpStack.peek() < tmp) {
                input.push(tmpStack.pop());
            }
            tmpStack.push(tmp);
        }
        return tmpStack;
    }

}

class exe6 {
    public static void main(String[] args) {
        StackOfInteger nums = new StackOfInteger(120);
        int j = 0;
        for (int i = 1; i < 120; i++) {
            if (isPrime(i))
                nums.push(i);
        }
        nums = StackOfInteger.sortStack(nums);
        int size = nums.getSize();
        for (int i = 0; i < size; i++) {
            System.out.print(nums.pop() + " ");
        }
    }

    public static boolean isPrime(int num) {
        if (num != 1 && num != 2) {
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0)
                    return false;
            }
        }
        return true;
    }
}

class exe7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Account[] accounts = new Account[10];
        for (int i = 0; i < 10; i++) {
            accounts[i] = new Account(i, 100);
        }
        while (true) {
            System.out.print("Enter an id:");
            int id = in.nextInt();
            while (true) {
                boolean flag = false;
                System.out.println("Main menu");
                System.out.println("1:check balance");
                System.out.println("2:withdraw");
                System.out.println("3.deposit");
                System.out.println("4:exit");
                System.out.print("Enter a choice:");
                int n = in.nextInt();
                switch (n) {
                    case 1:
                        System.out.println("The balance is " + accounts[id].getBalance());
                        break;
                    case 2:
                        System.out.print("Enter an amount to withdraw:");
                        double amount = in.nextDouble();
                        accounts[id].withDraw(amount);
                        break;
                    case 3:
                        System.out.print("Enter an amount to deposit:");
                        amount = in.nextDouble();
                        accounts[id].deposit(amount);
                        break;
                    case 4:
                        flag = true;
                        break;
                }
                if (flag)
                    break;
            }
        }
    }
}

class Account {
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private final Date dateCreated;

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
        Tax tax = new Tax();
        for (int j = 0; j < 4; j++) {
            for (int i = 50000; i <= 60000; i += 1000) {
                System.out.print(tax.getTax(j, i) + " ");
            }
            System.out.println();
        }
    }
}

class Tax {
    public int getFilingStatus() {
        return filingStatus;
    }

    public void setFilingStatus(int filingStatus) {
        this.filingStatus = filingStatus;
    }

    public int[][] getBrackets() {
        return brackets;
    }

    public void setBrackets(int[][] brackets) {
        this.brackets = brackets;
    }

    public double[] getRates() {
        return rates;
    }

    public void setRates(double[] rates) {
        this.rates = rates;
    }

    public int filingStatus;
    public static int SINGLE_FILER = 0;
    public static int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW = 1;
    public static int MARRIED_SEPARATELY = 2;
    public static int HEAD_OF_HOUSEHOLD = 3;
    public int[][] brackets = {{27050, 65550, 136750, 297350}, {45200, 109250, 109251, 1666500, 297350}, {22600, 54625, 83250, 148675}, {36250, 93650, 151650, 297350}};
    public double[] rates = {0.15, 0.275, 0.305, 0.355, 0.391};
    public double taxableIncome;

    public Tax() {
    }

    public Tax(int filingStatus, double taxableIncome) {
        this.filingStatus = filingStatus;
        this.taxableIncome = taxableIncome;
    }

    public double getTax(int filingStatus, double taxableIncome) {
        int index;
        double tax = 0;
        if (taxableIncome < brackets[filingStatus][0])
            tax = taxableIncome * rates[0];
        else {
            for (index = 0; index < 4; index++) {
                if (taxableIncome >= brackets[filingStatus][index])
                    break;
            }
            tax = brackets[filingStatus][0] * rates[0];
            for (int i = 0, j = 1; i < index; i++) {
                tax += (brackets[filingStatus][i + 1] - brackets[filingStatus][i]) * rates[j++];
            }
            if (index == 3)
                tax += (taxableIncome - brackets[filingStatus][3]) * rates[4];
        }
        return tax;
    }
}

class exe9 {
    public static void main(String[] args) {
        Course test = new Course("test");
        test.addStudent("a");
        test.addStudent("b");
        test.addStudent("c");
        System.out.println(Arrays.toString(test.getStudents()));
        test.dropStudent("b");
        System.out.println(Arrays.toString(test.getStudents()));
    }
}

class Course {
    private final String courseName;
    private String[] students = new String[100];
    private int numberOfStudents = 0;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        String[] tmp = new String[numberOfStudents];
        System.arraycopy(students, 0, tmp, 0, numberOfStudents);
        numberOfStudents++;
        students = new String[numberOfStudents];
        System.arraycopy(tmp, 0, students, 0, numberOfStudents - 1);
        students[numberOfStudents - 1] = student;
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
        for (int i = 0; i < numberOfStudents; i++) {
            if (student.equals(students[i])) {
                if (numberOfStudents - 1 - i >= 0)
                    System.arraycopy(students, i + 1, students, i, numberOfStudents - 1 - i);
                students[numberOfStudents - 1] = "";
                break;
            }
        }
    }
}

class exe10 {
    public static void main(String[] args) {
        Queue queue = new Queue();
        for (int i = 1; i <= 20; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 20; i++) {
            System.out.println(queue.dequeue());
        }
    }
}

class Queue {
    public int[] elements;
    public int size;
    public int index = 0;

    public Queue() {
        size = 8;
        elements = new int[size];
    }

    public void enqueue(int v) {
        if (index >= size) {
            int[] temp = new int[size * 2];
            System.arraycopy(elements, 0, temp, 0, size);
            elements = new int[size * 2];
            System.arraycopy(temp, 0, elements, 0, size * 2);
            size *= 2;
        }
        elements[index++] = v;
    }

    public int dequeue() {
        int num = elements[0];
        if (size - 1 >= 0) System.arraycopy(elements, 1, elements, 0, size - 1);
        size--;
        return num;
    }

    public boolean empty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}

class exe11 {
    public static void main(String[] args) {
        Circle2D cl = new Circle2D(2, 2, 5.5);
        System.out.println(cl.getArea());
        System.out.println(cl.getPerimeter());
        System.out.println(cl.contains(3, 3));
        System.out.println(cl.contains(new Circle2D(4, 5, 10.5)));
        System.out.println(cl.overlaps(new Circle2D(3, 5, 2.3)));
    }
}

class Circle2D {
    public double x;
    public double y;
    public double radius;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public Circle2D() {
        x = 0;
        y = 0;
        radius = 1;
    }

    public Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return Math.PI * radius * 2;
    }

    public boolean contains(double x, double y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2)) < radius;
    }

    public boolean contains(Circle2D circle) {
        return Math.sqrt(Math.pow(this.x - circle.x, 2) + Math.pow(this.y - circle.y, 2)) < radius - circle.radius;
    }

    public boolean overlaps(Circle2D circle) {
        return Math.sqrt(Math.pow(this.x - circle.x, 2) + Math.pow(this.y - circle.y, 2)) < radius + circle.radius && Math.sqrt(Math.pow(this.x - circle.x, 2) + Math.pow(this.y - circle.y, 2)) > radius - circle.radius;
    }
}

class exe12 {
    public static void main(String[] args) {
        Triangle2D t1 = new Triangle2D(new MyPoint(2.5, 2), new MyPoint(4.2, 3), new MyPoint(5, 3.5));
        System.out.println(t1.contains(3, 3));
        System.out.println(t1.contains(new Triangle2D(new MyPoint(2.9, 2), new MyPoint(4, 1), new MyPoint(1, 3.4))));
        System.out.println(t1.overlaps(new Triangle2D(new MyPoint(2, 5.5), new MyPoint(4, -3), new MyPoint(2, 6.5))));
    }
}

class Triangle2D {
    public MyPoint p1, p2, p3;

    public MyPoint getP1() {
        return p1;
    }

    public void setP1(MyPoint p1) {
        this.p1 = p1;
    }

    public MyPoint getP2() {
        return p2;
    }

    public void setP2(MyPoint p2) {
        this.p2 = p2;
    }

    public MyPoint getP3() {
        return p3;
    }

    public void setP3(MyPoint p3) {
        this.p3 = p3;
    }

    public Triangle2D() {
        p1 = new MyPoint(0, 0);
        p2 = new MyPoint(1, 1);
        p3 = new MyPoint(2, 5);
    }

    public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public double getArea() {
        return (p1.x * p2.y + p1.y * p3.x + p2.x * p3.y - p1.x * p3.y - p1.y * p2.x - p2.y * p3.x) / 2;
    }

    public boolean contains(double x, double y) {
        double maxX = Math.max(p1.getX(), Math.max(p2.getX(), p3.getX()));
        double minX = Math.min(p1.getX(), Math.min(p2.getX(), p3.getX()));
        double maxY = Math.max(p1.getY(), Math.max(p2.getY(), p3.getY()));
        double minY = Math.min(p1.getY(), Math.min(p2.getY(), p3.getY()));

        if (x < minX || x > maxX || y < minY || y > maxY) {
            return false;
        }

        Line2D side1 = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        Line2D side2 = new Line2D.Double(p1.getX(), p1.getY(), p3.getX(), p3.getY());
        Line2D side3 = new Line2D.Double(p2.getX(), p2.getY(), p3.getX(), p3.getY());

        if (side1.contains(x, y) || side2.contains(x, y) || side3.contains(x, y)) {
            return true;
        }

        double topY = -10;
        if (x == p1.getX()) {
            topY = p1.getY();
        } else if (x == p2.getX()) {
            topY = p2.getY();
        } else if (x == p3.getX()) {
            topY = p3.getY();
        }

        Line2D line;
        if (y < topY)
            line = new Line2D.Double(x, y, x, minY);
        else
            line = new Line2D.Double(x, y, x, maxY);

        int hits = 0;
        if (line.intersectsLine(side1))
            hits++;

        if (line.intersectsLine(side2))
            hits++;

        if (line.intersectsLine(side3))
            hits++;

        return hits % 2 != 0;
    }

    public boolean contains(Triangle2D t) {
        return contains(t.getP1().getX(), t.getP1().getY()) &&
                contains(t.getP2().getX(), t.getP2().getY()) &&
                contains(t.getP3().getX(), t.getP3().getY());
    }

    public boolean overlaps(Triangle2D t) {
        Line2D line1 = new Line2D.Double(t.p1.getX(), t.p1.getY(), t.p2.getX(), t.p2.getY());
        Line2D line2 = new Line2D.Double(t.p1.getX(), t.p1.getY(), t.p3.getX(), t.p3.getY());
        Line2D line3 = new Line2D.Double(t.p2.getX(), t.p2.getY(), t.p3.getX(), t.p3.getY());

        Line2D side1 = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        Line2D side2 = new Line2D.Double(p1.getX(), p1.getY(), p3.getX(), p3.getY());
        Line2D side3 = new Line2D.Double(p2.getX(), p2.getY(), p3.getX(), p3.getY());

        return contains(t) || t.contains(this) ||
                line1.intersectsLine(side1) ||
                line1.intersectsLine(side2) ||
                line1.intersectsLine(side3) ||
                line2.intersectsLine(side1) ||
                line2.intersectsLine(side2) ||
                line2.intersectsLine(side3) ||
                line3.intersectsLine(side1) ||
                line3.intersectsLine(side2) ||
                line3.intersectsLine(side3);
    }
}

class exe13 {
    public static void main(String[] args) {
        MyRectangle2D r1 = new MyRectangle2D(2, 2, 5.5, 4.9);
        System.out.println(r1.getArea());
        System.out.println(r1.getPerimeter());
        System.out.println(r1.contains(3, 3));
        System.out.println(r1.contains(new MyRectangle2D(4, 5, 10.5, 3.2)));
        System.out.println(r1.overlaps(new MyRectangle2D(3, 5, 2.3, 5.4)));
    }
}

class MyRectangle2D {
    public double x, y, width, height;

    public double getX() {
        return x;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
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

    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public boolean contains(double x, double y) {
        return (x > this.x - width / 2.0) && (x < this.x + width / 2.0) && (y < this.y + height / 2.0) && (y > this.y - height / 2.0);
    }

    public boolean contains(MyRectangle2D r) {
        return (r.x + r.width / 2.0 < this.x + this.width / 2.0) && (r.x - r.width / 2.0 > this.x - this.width / 2.0) && (r.y - r.height / 2.0 > this.y - this.height / 2.0) && (r.y + r.height / 2.0 < this.y + this.height / 2.0);
    }

    public boolean overlaps(MyRectangle2D r) {
        return !(this.x - this.width / 2.0 > r.x + r.width / 2.0 || this.x + this.width / 2.0 < r.x - r.width / 2.0 || this.y - this.height / 2.0 > r.y + r.height / 2.0 || this.y + this.height / 2.0 < r.y - r.height / 2.0);
    }
}

class exe14 {
    public static void main(String[] args) {
        MyDate date = new MyDate();
        MyDate date1 = new MyDate(34355555133101L);
        date.display();
        date1.display();
    }
}

class MyDate {
    public int year, month, day;

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public MyDate() {
        Calendar calendar = new GregorianCalendar();
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    public MyDate(long time) {
        Date date = new Date(time);
        this.year = date.getYear() + 1970;
        this.month = date.getMonth() + 1;
    }

    public void setDate(long Time) {
        new MyDate(Time + System.currentTimeMillis());
    }

    public void display() {
        System.out.println(this.year + " " + this.month + " " + this.day + " ");
    }

}

class exe15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[][] points = new double[5][2];
        for (int i = 0; i < 5; i++) {
            points[i][0] = in.nextDouble();
            points[i][1] = in.nextDouble();
        }
        System.out.println("(" + getRectangle(points).getX() + "," + getRectangle(points).getY() + ")" + getRectangle(points).getWidth() + " " + getRectangle(points).getHeight());
    }

    public static MyRectangle2D getRectangle(double[][] points) {
        double x_min = points[0][0], x_max = points[0][0], y_min = points[0][1], y_max = points[0][1];
        for (int i = 1; i < 5; i++) {
            if (points[i][0] >= x_max) {
                x_max = points[i][0];
            }
            if (points[i][0] <= x_min) {
                x_min = points[i][0];
            }
            if (points[i][1] >= y_max) {
                y_max = points[i][1];
            }
            if (points[i][1] <= y_min) {
                y_min = points[i][1];
            }
        }
        return new MyRectangle2D((x_max + x_min) / 2.0, (y_max + y_min) / 2.0, x_max - x_min, y_max - y_min);

    }


}

class exe16 {
    public static void main(String[] args) {
        int count = 0;
        BigDecimal num = new BigDecimal(10e50);
        while (count <= 10) {
            if (num.remainder(new BigDecimal(2)).compareTo(BigDecimal.ZERO) == 0 || num.remainder(new BigDecimal(3)).compareTo(BigDecimal.ZERO) == 0) {
                System.out.println(num);
                count++;
            }
            num.add(new BigDecimal(1));
        }
    }
}

class exe17 {
    public static void main(String[] args) {
        long longMax = (long) Math.sqrt(Long.MAX_VALUE);
        for (int i = 0; i < 10; i++) {
            BigInteger a = new BigInteger(longMax + i + 1 + "");
            System.out.println(a.multiply(a));
        }
    }
}

class exe18 {
    public static void main(String[] args) {
        BigInteger num = new BigInteger(String.valueOf(Long.MAX_VALUE));
        int count = 0;
        while (count < 5) {
            if (isPrime(num)) {
                System.out.println(num);
                count++;
            }
            num = num.add(BigInteger.ONE);
        }
    }

    public static boolean isPrime(BigInteger i) {
        for (BigInteger divisor1 = new BigInteger("2"); divisor1.compareTo(i.divide(new BigInteger("2"))) <= 0; divisor1 = divisor1.add(BigInteger.ONE)) {
            if (i.remainder(divisor1).compareTo(BigInteger.ZERO) == 0)
                return false;
        }
        return true;
    }
}

class exe19 {
    public static void main(String[] args) {
        for (int p = 2; p <= 100; p++) {
            if (isPrime(new BigInteger(String.valueOf(p))) && isPrime(new BigInteger(String.valueOf(Math.pow(p, 2) - 1))))
                System.out.println(p + "\t" + (Math.pow(p, 2) - 1));
        }
    }

    public static boolean isPrime(BigInteger i) {
        for (BigInteger divisor1 = new BigInteger("2"); divisor1.compareTo(i.divide(new BigInteger("2"))) <= 0; divisor1 = divisor1.add(BigInteger.ONE)) {
            if (i.remainder(divisor1).compareTo(BigInteger.ZERO) == 0)
                return false;
        }
        return true;
    }
}

class exe20 {
    public static void main(String[] args) {
        BigDecimal num = new BigDecimal(BigInteger.ONE);
        BigDecimal e = new BigDecimal(BigInteger.ONE);
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= i; j++)
                num.multiply(new BigDecimal(String.valueOf(j)));
            e.add(BigDecimal.ONE.divide(num));
        }
        System.out.println(e);
        num = new BigDecimal(BigInteger.ONE);
        e = new BigDecimal(BigInteger.ONE);
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= i; j++)
                num.multiply(new BigDecimal(String.valueOf(j)));
            e.add(BigDecimal.ONE.divide(num));
        }
        System.out.println(e);
        num = new BigDecimal(BigInteger.ONE);
        e = new BigDecimal(BigInteger.ONE);
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= i; j++)
                num.multiply(new BigDecimal(String.valueOf(j)));
            e.add(BigDecimal.ONE.divide(num));
        }
        System.out.println(e);
    }
}

class exe21 {
    public static void main(String[] args) {
        int count = 0;
        BigDecimal num = new BigDecimal(Long.MAX_VALUE);
        while (count <= 10) {
            if (num.remainder(new BigDecimal(5)).compareTo(BigDecimal.ZERO) == 0 || num.remainder(new BigDecimal(6)).compareTo(BigDecimal.ZERO) == 0) {
                System.out.println(num);
                count++;
            }
            num.add(new BigDecimal(1));
        }
    }
}

class MyString1 {
    private char[] chars;

    public MyString1(char[] chars) {
        this.chars = chars;
    }

    public MyString1() {
    }

    public char charAt(int index) {
        return chars[index];
    }

    public int length() {
        return chars.length;
    }

    public MyString1 substring(int begin, int end) {
        MyString1 str = new MyString1();
        for (int i = begin; i <= end; i++) {
            str.chars[i] = chars[i];
        }
        return str;
    }

    public MyString1 toLowerCase() {
        MyString1 str = new MyString1(this.chars);
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + 32);
        }
        return str;
    }

    public boolean equals(MyString1 s) {
        if (this.chars.length != s.chars.length)
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (this.chars[i] != s.chars[i])
                return false;
        }
        return true;
    }

    public static MyString1 valueOf(int i) {
        MyString1 s = new MyString1();
        int j = 0;
        while (i != 0) {
            s.chars[j++] = (char) (i / 10 + '0');
            i /= 10;
        }
        return s;
    }
}

class MyString2 {
    String s;

    public MyString2(String s) {
        this.s = s;
    }

    public int compare(String s) {
        int len1 = this.s.length();
        int len2 = s.length();
        int lim = Math.min(len1, len2);
        char v1[] = this.s.toCharArray();
        char v2[] = s.toCharArray();
        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }

    public MyString2 substring(int begin) {
        MyString2 str = new MyString2("");
        char[] chars = this.s.toCharArray();
        for (int i = begin; i < this.s.length(); i++) {
            str.s += chars[i];
        }
        return str;
    }

    public MyString2 toUpperCase() {
        MyString2 str = new MyString2("");
        char[] chars = this.s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            str.s += (char) (chars[i] - 32);
        }
        return str;
    }

    public char[] toChars() {
        char[] chars = new char[this.s.length()];
        for (int i = 0; i < this.s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        return chars;
    }

    public static MyString2 valueOf(boolean b) {
        return b ? new MyString2("true") : new MyString2("false");
    }
}

class exe25 {
    public static void main(String[] args) {
        String[] strings = split("a#b#gf#e", "#");
        for (String s : strings
        ) {
            if (s != null)
                System.out.println(s);
        }
    }

    public static String[] split(String s, String regex) {
        String tmps = "";
        String[] strings = new String[s.length()];
        int len = regex.length();
        int index = 0, j = 0;
        for (int i = 0; i < s.length() - len; i += len) {
            if (s.substring(i, i + len).equals(regex)) {
                tmps = s.substring(index, i);
                strings[j++] = tmps;
                strings[j++] = regex;
                index = j;
            }
        }
        return strings;
    }
}

class exe26 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        s = s.replaceAll(" ", "");
        int index = 0;
        double result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!(s.charAt(i) <= '9' && s.charAt(i) >= '0')) {
                index = i;
                break;
            }
        }
        int a = Integer.parseInt(s.substring(0, index));
        int b = Integer.parseInt(s.substring(index, s.length()));
        switch (s.charAt(index)) {
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
        System.out.println(a + " " + s.charAt(index) + " " + b + "=" + result);

    }
}

class MyStringBuild1 {
    private String string;

    public MyStringBuild1(String s) {
        string = s;
    }

    public String toString() {
        return string;
    }

    public MyStringBuild1 append(MyStringBuild1 s) {
        String new_string = string + s.toString();
        return new MyStringBuild1(string);
    }

    public MyStringBuild1 append(int i) {
        String new_string = string + Integer.toString(i);
        return new MyStringBuild1(string);
    }

    public int length() {
        return string.length();
    }

    public char charAt(int index) {
        return string.toCharArray()[index];
    }

    public MyStringBuild1 toLowerCase() {
        return new MyStringBuild1(string.toLowerCase());
    }

    public MyStringBuild1 substring(int begin, int end) {
        char[] tmp = string.toCharArray();
        char[] new_char = new char[end - begin];
        System.arraycopy(tmp, begin, new_char, 0, end - begin);
        return new MyStringBuild1(new String(new_char));
    }
}

class MyStringBuilder2 {
    private String string;

    public MyStringBuilder2(String s) {
        string = s;
    }

    public MyStringBuilder2(char[] chars) {
        this(new String(chars));
    }

    public String toString() {
        return string;
    }

    public MyStringBuilder2 toUpperCase() {
        char[] tmp = string.toCharArray();
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] >= 'a' && tmp[i] <= 'z') {
                tmp[i] = (char) (tmp[i] - 'a' + 'A');
            }
        }
        return new MyStringBuilder2(tmp);
    }

    public MyStringBuilder2 substring(int begin) {
        char[] tmp = string.toCharArray();
        char[] new_char = new char[string.length() - begin];
        System.arraycopy(tmp, begin, new_char, 0, string.length() - begin);
        return new MyStringBuilder2(new String(new_char));
    }

    public MyStringBuilder2 substring(int begin, int end) {
        char[] tmp = string.toCharArray();
        char[] new_char = new char[end - begin];
        System.arraycopy(tmp, begin, new_char, 0, end - begin);
        return new MyStringBuilder2(new String(new_char));
    }

    public MyStringBuilder2 insert(int offset, MyStringBuilder2 s) {
        MyStringBuilder2 before = this.substring(0, offset);
        MyStringBuilder2 after = this.substring(offset);
        return new MyStringBuilder2(before.toString() + s.toString() + after.toString());
    }

    public MyStringBuilder2 reverse() {
        char[] tmp = string.toCharArray();
        char[] new_tmp = new char[tmp.length];
        for (int i = 0, k = tmp.length - 1; k >= 0; k--, i++) {
            new_tmp[i] = tmp[k];
        }
        return new MyStringBuilder2(new_tmp);
    }
}
















