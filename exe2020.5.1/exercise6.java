import com.sun.org.glassfish.external.amx.AMX;
import javafx.scene.shape.Circle;
import java.net.CookieHandler;
import java.util.*;

class exe1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double side1 = in.nextDouble();
        double side2 = in.nextDouble();
        double side3 = in.nextDouble();
        Triangle triangle = new Triangle(side1, side2, side3);
        System.out.println(triangle.toString());
    }
}

class Triangle {
    public double side1;
    public double side2;
    public double side3;

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public Triangle() {
        side1 = 1.0;
        side2 = 1.0;
        side3 = 1.0;
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getArea() {
        double p = (this.side1 + this.side2 + this.side3) / 3.0;
        return Math.sqrt(p * (p - this.side1) * (p - this.side2) * (p - this.side3));
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public String toString() {
        return "Triangle:side1=" + side1 + " side2= " + side2 + " side3= " + side3;
    }
}

class Person {
    public String name;
    public String address;
    public String phoneNumber;
    public String email;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person {
    public String status;
    public final int dayi = 1;
    public final int daer = 2;
    public final int dasan = 3;
    public final int dasi = 4;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Employee extends Person {
    public String room;
    public int salary;
    public Date date;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Faculty extends Employee {
    public String time;
    public String level;

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Staff extends Employee {
    public String title;

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                '}';
    }
}

class exe3 {
    public static void main(String[] args) {
        Account account = new Account();
        checkingAccount checkingAccount = new checkingAccount();
        savingAccount savingAccount = new savingAccount();
        System.out.println(account.toString());
        System.out.println(checkingAccount.toString());
        System.out.println(savingAccount.toString());
    }
}

class Account {
    public String account;
    public double balance;
    public double rate;
    public Date date;

    public Account() {
        date = new Date();
    }

    public void save(double amount) {
        balance += amount;
    }

    public void withdrew(double amount) {
        balance -= amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account='" + account + '\'' +
                ", balance=" + balance +
                ", date=" + date +
                '}';
    }
}

class checkingAccount extends Account {
    public double Quota;

    public boolean check() {
        return -balance <= Quota;
    }
}

class savingAccount extends Account {
    public boolean check() {
        return balance > 0;
    }
}

class exe4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (true) {
            int num = in.nextInt();
            if (num != 0)
                list.add(num);
            else
                break;
        }
        System.out.println(max(list));
    }

    public static Integer max(ArrayList<Integer> list) {
        return Collections.max(list);
    }
}

class Course {
    private final String courseName;
    private ArrayList<String> students = new ArrayList<String>();
    private int numberOfStudents = 0;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        students.add(student);
    }

    public ArrayList<String> getStudents() {
        return students;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String student) {
        students.remove(student);
    }
}

class exe6 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Date());
        arrayList.add(new String());
        arrayList.add(new Circle());
        for (int i = 0; i < 3; i++) {
            System.out.println(arrayList.get(i).toString());
        }
    }
}

class exe7 {
    public static void shuffle(ArrayList list, Random rnd) {
        int size = list.size();
        if (list instanceof RandomAccess) {
            for (int i = size; i > 1; i--)
                Collections.swap(list, i - 1, rnd.nextInt(i));
        } else {
            Object[] arr = list.toArray();
            for (int i = size; i > 1; i--)
                Collections.swap(Arrays.asList(arr), i - 1, rnd.nextInt(i));
            ListIterator it = list.listIterator();
            for (int i = 0; i < arr.length; i++) {
                it.next();
                it.set(arr[i]);
            }
        }
    }
}

class exe8 {
    public static void main(String[] args) {
        Account1 account = new Account1("George", "account", 1122, 1.5, 1000);
        account.save(30);
        account.save(40);
        account.save(50);
        account.withdrew(5);
        account.withdrew(4);
        account.withdrew(3);
        System.out.println(account.name + " " + account.rate + " " + account.balance);
    }
}

class Account1 {
    public String account;
    public double balance;
    public double rate;
    public Date date;
    public int id;
    public String name;
    public ArrayList<Transaction> transactions;

    public Account1() {
        date = new Date();
    }

    public Account1(String name, String account, int id, double rate, double balance) {
        this.rate = rate;
        this.balance = balance;
        this.name = name;
        this.account = account;
        this.id = id;
    }

    public void save(double amount) {
        Transaction transaction = new Transaction();
        transaction.balance += amount;
        transactions.add(transaction);
    }

    public void withdrew(double amount) {
        Transaction transaction = new Transaction();
        transaction.balance -= amount;
        transactions.add(transaction);
    }
}

class Transaction {
    public double balance;
    public Date date;
    public char type;
    public double amount;
    public String description;

    public void Transaction(char type, double amount, double balance, String description) {

        this.type = type;
        if (type == 'w')
            this.balance = balance - amount;
        else
            this.balance = balance + amount;
        this.description = description;
    }
}

class exe9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] nums = new int[n][n];
        ArrayList row = new ArrayList();
        ArrayList column = new ArrayList();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = new Random().nextInt(2);
            }
        }
        int count;
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i][j] == 1)
                    count++;
            }
            row.add(count);
        }
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j][i] == 1)
                    count++;
            }
            column.add(count);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }
        System.out.println("The Largest row index:" + row.indexOf(Collections.max(row)));
        System.out.println("The Largest column index:" + row.indexOf(Collections.max(row)) + "," + column.indexOf(Collections.max(column)));
    }
}

class MyStack<E> {
    private int MAX_DEPTH = 10;
    private int depth = 0;
    private E[] stack = (E[]) new Object[MAX_DEPTH];

    public void push(E e) {
        if (depth == MAX_DEPTH - 1) {
            throw new RuntimeException("栈已满，无法再添加元素。");
        }
        stack[depth++] = e;
    }

    protected E pop() {
        if (depth == 0) {
            throw new RuntimeException("栈中元素已经被取完，无法再取。");
        }
        return stack[--depth];
    }

    protected E peek() {
        if (depth == 0) {
            throw new RuntimeException("栈中元素已经被取完，无法再取。");
        }
        return stack[depth - 1];
    }
}

class exe11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入5个数字： ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(input.nextInt());
        }
        sort(list);
        System.out.println(list);
    }

    public static void sort(ArrayList<Integer> list) {
        java.util.Collections.sort(list);
    }
}

class exe12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入5个数字： ");
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(input.nextDouble());
        }
        System.out.println("它们的和为： " + sum(list));
    }

    public static double sum(ArrayList<Double> list) {
        double sum = 0;
        int leng = list.size();
        for (int i = 0; i < leng; i++) {
            sum += list.get(i);
        }
        return sum;
    }
}

class exe13 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.print("Enter ten integers: ");
        for (int i = 0; i < 10; i++) {
            list.add(input.nextInt());
        }
        removeDuplicate(list);
    }

    public static void removeDuplicate(ArrayList<Integer> list) {
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!newList.contains(list.get(i))) {
                newList.add(list.get(i));
            }
        }
        System.out.print("The distinct integers are: ");
        for (int i = 0; i < newList.size(); i++) {
            System.out.print(" " + newList.get(i));
        }
    }
}

class exe14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter five integers for list1: ");
        int t1;
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            t1 = input.nextInt();
            list1.add(t1);
        }
        System.out.print("Enter five integers for list2: ");
        int t2;
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            t2 = input.nextInt();
            list2.add(t2);
        }
        union(list1, list2);
    }

    public static void union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        list1.addAll(list2);
        System.out.print("The combined list is ");
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + " ");
        }
    }
}

class exe15{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the number of the points:");
        int sides=in.nextInt();
        System.out.println("Enter the coordinates of the points:");
        Double[][] points=new Double[sides+1][2];
        for(int i=0;i<sides;i++){
            points[i][0]=in.nextDouble();
            points[i][1]=in.nextDouble();
        }
        System.out.println(getArea(points));
    }
    public static double getArea(Double[][] p){
        p[p.length-1]=p[0];
        double s=0;
        for(int i=0;i<p.length-1;i++){
            s+=(p[i][0] + p[i + 1][0]) * (p[i + 1][1] - p[i][1]);
        }
        return 0.5*Math.abs(s);
    }
}
class exe16 {
    public static void main(String[] args) {
        int number1 = (int) (Math.random() * 10);
        int number2 = (int) (Math.random() * 10);
        ArrayList<Integer> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.print("What is " + number1 + " + " + number2 + "?");
        int answer = input.nextInt();
        while (number1 + number2 != answer) {
            if (!list.contains(answer)) {
                list.add(answer);
            } else {
                System.out.println("You already entered " + answer);
            }
            System.out.print("Wrong answer.Try again.What is " + number1 + " + " + number2 + "? ");
            answer = input.nextInt();
        }
        System.out.println("You got it!");
    }
}

class exe17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.print("Enter an integer m: ");
        int number = input.nextInt();
        input.close();
        int m = number;
        int i = 2;
        System.out.print("因子为： ");
        while (number != 1) {
            if (number % i == 0) {
                number = number / i;
                System.out.print(i + " ");
                list.add(i);
            } else {
                i++;
            }
        }
        System.out.println();
        System.out.println("检查 list数组里的情况： " + list.toString());
        ArrayList<Integer> newList = new ArrayList<>();
        int[] countArray = new int[1000];
        for (int j = 0; j < list.size(); j++) {
            if (!newList.contains(list.get(j))) {
                newList.add(list.get(j));
                countArray[list.get(j)]++;
            } else {
                countArray[list.get(j)]++;
            }
        }
        System.out.println("检查 newList数组里的情况： " + newList.toString());
        System.out.println();
        int n = 1;
        for (int j = 0; j < newList.size(); j++) {
            if (countArray[newList.get(j)] % 2 != 0) {
                n = n * newList.get(j);
            }
        }
        System.out.println("The smallest number m*n to " + "be a perfect square is " + n);
        System.out.println(" m*n is " + m * n);
    }
}







































