import java.util.Scanner;
public class exe17 {
    public static void main(String[] args) {
        String[] week={"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
        Scanner input=new Scanner(System.in);
        System.out.print("Enter year:(e.g., 2012):");
        int year=input.nextInt();
        System.out.print("Enter month:1-12:");
        int month=input.nextInt();
        if(month==1||month==2){
            month+=12;
            year--;
        }
        System.out.print("Enter the day of the month:1-31:");
        int day=input.nextInt();
        int h=(day+26*(month+1)/10+year%1000+(year%1000)/4+year/100+1+5*(year/100+1))%7;
        System.out.println("Day of the week is "+week[h]);
    }
}
