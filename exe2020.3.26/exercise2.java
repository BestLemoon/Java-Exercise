import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

class exe1{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter point 1(latitude and longitude) in degrees:");
        float point1x=in.nextFloat();
        float point1y=in.nextFloat();
        System.out.print("Enter point 1(latitude and longitude) in degrees:");
        float point2x=in.nextFloat();
        float point2y=in.nextFloat();
        double d=6371.01*Math.acos(Math.sin(Math.toRadians(point1x))*Math.sin(Math.toRadians(point2x))+Math.cos(Math.toRadians(point1x))*Math.cos(Math.toRadians(point2x))*Math.cos(Math.toRadians(Math.abs(point1y-point2y))));
        System.out.println("The distance between the two points is "+d+" km");
        in.close();
    }
}
class exe2{
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.print("Enter the number of sides:");
        int n=in.nextInt();
        System.out.print("Enter the side:");
        float side=in.nextFloat();
        double area=(n*side*side)/(4*Math.tan(Math.PI/n));
        System.out.println("The area of the polygon is "+area);
        in.close();
    }
}
class exe3{
    final static int r=40;
    public static void main(String[] args) {
        double alpha1=Math.random()*361;
        double alpha2=Math.random()*361;
        double alpha3=Math.random()*361;
        double p1x=r*Math.cos(alpha1);
        double p1y=r*Math.sin(alpha1);
        double p2x=r*Math.cos(alpha2);
        double p2y=r*Math.sin(alpha2);
        double p3x=r*Math.cos(alpha3);
        double p3y=r*Math.sin(alpha3);
        double a=Math.sqrt(Math.pow((p1x-p2x),2)+Math.pow((p1y-p2y),2));
        double b=Math.sqrt(Math.pow((p3x-p2x),2)+Math.pow((p3y-p2y),2));
        double c=Math.sqrt(Math.pow((p1x-p3x),2)+Math.pow((p1y-p3y),2));
        double angle1=Math.asin(a/2/r);
        double angle2=Math.asin(b/2/r);
        double angle3=Math.asin(c/2/r);
        System.out.printf("The three points is (%f,%f),(%f,%f) and (%f,%f)\n",p1x,p1y,p2x,p2y,p3x,p3y);
        System.out.println("The three angle is "+angle1+","+angle2+" and "+angle3);
    }
}
class exe4{
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.print("Enter an ASCII code:");
        int num=in.nextInt();
        System.out.printf("The character for ASCII code %d is %c\n",num,num);
        in.close();
    }
}
class exe5{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter a character:");
        char c=in.next().charAt(0);
        System.out.printf("The Unicode for the character %c is %d",c,(int)c);
        in.close();
    }
}
class exe6{
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.print("Enter a hex character:");
        String str=in.nextLine();
        boolean flag=true;
        for(int i=0;i<str.length();i++){
            if (!(str.charAt(i)>='0'&&str.charAt(i)<='9'||str.charAt(i)>'A'&&str.charAt(i)<='F')){
                flag=false;
                break;
            }
        }
        if(flag) {
            int num = Integer.parseInt(str, 16);
            String r = Integer.toBinaryString(num);
            System.out.println("The binary value is " + r);
        }
        else
            System.out.println(str+" is an invalid input");
    }
}
class exe7{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a letter grade:");
        String s=in.nextLine();
        char[] chars=s.toCharArray();
        char c=chars[0];
        if(c>='A'&&c<='D'){
            System.out.println("The numeric value for grade "+c+" is "+(Math.abs(c-'D')+1));
        }else if(c=='F'){
            System.out.println("The numeric value for grade "+c+" is 0");
        }else {
            System.out.println(c+" is an invalid grade");
        }
    }
}
class exe8{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an uppercase letter:");
        String s=in.nextLine();
        s=s.toLowerCase();
        char[] chars=s.toCharArray();
        char c=chars[0];
        if(c>='a'&&c<='z'){
            int dis=c-'a'+1;
            int num=0;
            switch (dis){
                case 1:
                case 2:
                case 3:num=2;
                    break;
                case 4:
                case 5:
                case 6:num=3;
                    break;
                case 7:
                case 8:
                case 9:num=4;
                    break;
                case 10:
                case 11:
                case 12:num=5;
                    break;
                case 13:
                case 14:
                case 15:num=6;
                    break;
                case 16:
                case 17:
                case 18:
                case 19:num=7;
                    break;
                case 20:
                case 21:
                case 22:num=8;
                    break;
                case 23:
                case 24:
                case 25:
                case 26:num=9;
                    break;
            }
            System.out.println("The corresponding number is "+num);
        }else {
            System.out.println(c+" is an invalid input");
        }
    }
}
class exe9{
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.print("Enter a year:");
        int year=in.nextInt();
        System.out.print("Enter a month (first three letters with the first letter in uppercase):");
        String month=in.next();
        int[] months={31,28,31,30,31,30,31,31,30,31,30,31};
        if(year%4==0&&year%100!=0||year%400==0)
            months[1]++;
        switch (month){
            case "Jan":
                System.out.println(month+" "+year+" has "+months[0]+" days");
                break;
            case "Feb":
                System.out.println(month+" "+year+" has "+months[1]+" days");
                break;
            case "Mar":
                System.out.println(month+" "+year+" has "+months[2]+" days");
                break;
            case "Apr":
                System.out.println(month+" "+year+" has "+months[3]+" days");
                break;
            case "May":
                System.out.println(month+" "+year+" has "+months[4]+" days");
                break;
            case "Jun":
                System.out.println(month+" "+year+" has "+months[5]+" days");
                break;
            case "Jul":
                System.out.println(month+" "+year+" has "+months[6]+" days");
                break;
            case "Aug":
                System.out.println(month+" "+year+" has "+months[7]+" days");
                break;
            case "Sep":
                System.out.println(month+" "+year+" has "+months[8]+" days");
                break;
            case "Oct":
                System.out.println(month+" "+year+" has "+months[9]+" days");
                break;
            case "Nov":
                System.out.println(month+" "+year+" has "+months[10]+" days");
                break;
            case "Dec":
                System.out.println(month+" "+year+" has "+months[11]+" days");
                break;
        }

    }
}
class exe10{
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.print("Enter a SSN:");
        String ssnString=in.next();
        if(ssnString.length() == 11)
        {
            if(Character.isDigit(ssnString.charAt(0))
                    && Character.isDigit(ssnString.charAt(1))
                    && Character.isDigit(ssnString.charAt(2))
                    && ssnString.charAt(3) == '-'
                    && Character.isDigit(ssnString.charAt(4))
                    && Character.isDigit(ssnString.charAt(5))
                    && ssnString.charAt(6) == '-'
                    && Character.isDigit(ssnString.charAt(7))
                    && Character.isDigit(ssnString.charAt(8))
                    && Character.isDigit(ssnString.charAt(9))
                    && Character.isDigit(ssnString.charAt(10)))
                System.out.println(ssnString + " is a valid social security number");
            else
                System.out.println(ssnString + " is an invalid social security number");
        }
        else
            System.out.println(ssnString + " is an invalid social security number");
    }
}
class exe11{
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.print("Enter string s1:");
        String s1=in.next();
        System.out.print("Enter string s2:");
        String s2=in.next();
        if(s1.indexOf(s2)!=-1){
            System.out.println(s2+" is a substring of "+s1);
        }else {
            System.out.println(s2 +" is not a substring of "+s1);
        }
    }
}
class exe12{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter employee's name:");
        String name=in.next();
        System.out.print("Enter number of hours worked in a week:");
        int hours=in.nextInt();
        System.out.print("Enter hourly pay rate:");
        double pay=in.nextDouble();
        System.out.print("Enter federal tax withholding rate:");
        double ftax=in.nextDouble();
        System.out.print("Enter state tax withholding rate:");
        double stax=in.nextDouble();
        System.out.println("Employee Name: "+name);
        System.out.println("Pay Rate:    $"+pay);
        System.out.println("Gross Pay:   $"+hours*pay);
        System.out.println("Deductions:");
        System.out.println("  Federal Withholding ("+ftax*100+"%):    $"+hours*pay*0.2);
        System.out.println("  State Withholding ("+stax*100+"%):     $"+hours*pay*0.09);
        System.out.println("  Total Deduction:      $"+hours*pay*0.29);
        System.out.println("Net Pay:   $"+hours*pay*(1-0.29));
    }
}
class exe13{
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.print("Enter the first city:");
        String fcity=in.nextLine();
        System.out.print("Enter the second city:");
        String scity=in.nextLine();
        System.out.print("Enter the third city:");
        String tcity=in.nextLine();
        if(fcity.compareTo(scity)<0){//f s
            if(scity.compareTo(tcity)<0){//f s t
                System.out.println("The three cities in alphabetical order are "+fcity+" "+scity+" "+tcity);
            }
            else{// t f s
                if(fcity.compareTo(tcity)>0)
                    System.out.println("The three cities in alphabetical order are "+tcity+" "+fcity+" "+scity);
                else
                    System.out.println("The three cities in alphabetical order are "+fcity+" "+tcity+" "+scity);
            }
        }else {// s f t
            if(scity.compareTo(tcity)<0){
                if(fcity.compareTo(tcity)<0)
                    System.out.println("The three cities in alphabetical order are "+scity+" "+fcity+" "+tcity);
                else
                    System.out.println("The three cities in alphabetical order are "+scity+" "+tcity+" "+fcity);
            }
            else{
                System.out.println("The three cities in alphabetical order are "+tcity+" "+scity+" "+fcity);
            }
        }
    }
}
class exe14{
    public static void main(String[] args) {
        String r="";
        r+=(char)('A'+(int)(Math.random()*26-1));
        r+=(char)('A'+(int)(Math.random()*26-1));
        r+=(char)('A'+(int)(Math.random()*26-1));
        r+=(int)(Math.random()*10);
        r+=(int)(Math.random()*10);
        r+=(int)(Math.random()*10);
        r+=(int)(Math.random()*10);
        System.out.println(r);
    }
}
class exe15{
    public static void main(String[] args) {
        System.out.println("千克\t\t\t磅");
        for(int i=1;i<200;i++){
            System.out.printf("%4d\t\t%4.1f\n",i,i*2.2);
        }
    }
}
class exe16{
    public static void main(String[] args) {
        System.out.println("英里\t\t\t千米");
        for(int i=1;i<=10;i++){
            System.out.printf("%4d\t\t%4.3f\n",i,i*1.609);
        }
    }
}
class exe17{
    public static void main(String[] args) {
        System.out.println("英里\t\t\t千米\t\t\t\t\t\t千米\t\t\t英里");
        for(int i=1,j=20;i<=10&&j<=65;i++){
            System.out.printf("%4d\t\t%4.3f",i,i*1.609);
            System.out.printf("\t\t\t\t\t%4d\t\t%4.3f\n",j,j/1.06);
            j+=5;
        }
    }
}
class exe18{
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.print("Enter the nums of students:");
        int num=in.nextInt();
        String[] name=new String[num];
        int[] score=new int[num];
        for(int i=0;i<num;i++){
            System.out.print("Enter the student's name:");
            name[i]=in.next();
            System.out.print("Enter the score:");
            score[i]=in.nextInt();
        }
        int max=score[0];
        int index=0;
        for(int i=1;i<num;i++){
         if(max<=score[i]){
             max=score[i];
             index=i;
         }
        }
        System.out.println(name[index]+"  "+score[index]);
    }
}
class exe19{
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.print("Enter the nums of students:");
        int num=in.nextInt();
        String[] name=new String[num];
        int[] score=new int[num];
        for(int i=0;i<num;i++){
            System.out.print("Enter the student's name:");
            name[i]=in.next();
            System.out.print("Enter the score:");
            score[i]=in.nextInt();
        }
        int max=score[0];
        int index=0;
        for(int i=1;i<num;i++){
            if(max<=score[i]){
                max=score[i];
                index=i;
            }
        }
        System.out.println(name[index]+"  "+score[index]);
        score[index]=0;
        max=score[0];
        for(int i=1;i<num;i++){
            if(max<=score[i]){
                max=score[i];
                index=i;
            }
        }
        System.out.println(name[index]+"  "+score[index]);
    }
}
class exe20{
    public static void main(String[] args) {
        int n=0;
        for(int i=33;i<=126;i++) {
            System.out.print((char)i+" ");
            n++;
            if(n%10==0)
                System.out.println();
        }
    }
}
class exe21{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter a num:");
        int num=in.nextInt();
        int i = 2,j=0;
        int[] nums=new int[num];
        while (true) {
            if (num % i == 0) {
                nums[j++]=i;
                num /= i;
            } else
                i++;
            if (num == 1)
                break;
        }
        Arrays.sort(nums);
        for(int k=0;k<nums.length;k++)
            if(nums[k]!=0)
                System.out.print(nums[k]+" ");
    }
}
class exe22{
    public static void main(String[] args) {
        int linenums=8;
        int line=0;
        while (line<linenums) {
            for (int i = 0; i < linenums - 1 - line; i++) {
                System.out.printf("%5s", ' ');
            }
            for (int i = 0; i < line + 1; i++) {
                System.out.printf("%5d", (int)Math.pow(2, i));
            }
            for (int i = line-1; i >= 0; i--) {
                System.out.printf("%5d", (int)Math.pow(2, i));
            }
            for (int i = 0; i < linenums- 1 - line; i++) {
                System.out.printf("%5s", ' ');
            }
            System.out.println();
            line++;
        }
    }
}
class exe23{
    public static void main(String[] args) {
        int numberOfYears;
        double loanAmount, rate, monthlyPayment, totalPayment, monthlyInterestRate, balance;
        Scanner in =new Scanner(System.in);
        System.out.print("Enter loan amount, for example 120000.95:");
        loanAmount=in.nextDouble();
        System.out.print("Enter number of years as an integer ,for example 5:");
        numberOfYears=in.nextInt();
        System.out.print("Enter yearly interest rate, for example 8.25:");
        rate=in.nextDouble();
        monthlyPayment = loanAmount * (rate / 1200)
                / (1-1/Math.pow(1 + (rate / 1200), numberOfYears * 12));
        totalPayment = monthlyPayment * numberOfYears * 12;
        balance = loanAmount;
        monthlyInterestRate = rate / 1200;
        System.out.printf("Monthly Payment: %.2f\n", monthlyPayment);
        System.out.printf("Total Payment: %.2f\n\n", totalPayment);
        System.out.println("Payment\t\tInterest\tPrincipal\tBalance");
        for (int i = 1; i <= numberOfYears * 12; i++)
        {
            double interest = monthlyInterestRate * balance;
            double principal = monthlyPayment - interest;
            balance = balance - principal;
            System.out.printf("%4d\t\t%4.2f\t\t%4.2f\t\t%4.2f\n", i, interest, principal, balance);
        }
    }
}
class exe24{
    public static void main(String[] args) {
        double sum=0;
        for(int i=1,j=3;i<=97&&j<=99;i+=2,j+=2){
            sum+=i*1.0/j;
        }
        System.out.println(sum);
    }
}
class exe25{
    public static void main(String[] args) {
        double sum=0;
        int[] nums=new int[10];
        for(int i=0;i<10;i++)
            nums[i]=(i+1)*10000;
        for(int n=0;n<10;n++) {
            sum=0;
            for (int i = 1,j=1; i <= nums[n];i+=2,j++){
                sum+=Math.pow(-1,j+1)*1.0/i;
            }
            sum*=4;
            System.out.println(sum);
        }
    }
}
class exe26{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter year:");
        int year=in.nextInt();
        System.out.print("Enter first day in week:");
        int weekday=in.nextInt();
        String[] months={"January","February","March","April","May","June","July","August","September","October","November","December"};
        String[] weeks={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        int[] days={31,28,31,30,31,30,31,31,30,31,30,31};
        if(year%4==0&&year%100!=0||year%400==0)
            days[1]++;
        int sum=0,week=weekday;
        for(int i=0;i<12;i++){
            System.out.println(months[i]+" 1, "+year +" is "+weeks[week]);
            sum+=days[i];
            week=(weekday+sum)%7;
        }
    }
}
class exe27{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter year:");
        int year=in.nextInt();
        System.out.print("Enter first day in week:");
        int weekday=in.nextInt();
        int[] days={31,28,31,30,31,30,31,31,30,31,30,31};
        String[] months={"January","February","March","April","May","June","July","August","September","October","November","December"};
        int[] weeks=new int[12];
        if(year%4==0&&year%100!=0||year%400==0)
            days[1]++;
        int sum=0,week=weekday;
        for(int i=0;i<12;i++){
            weeks[i]=week;
            sum+=days[i];
            week=(weekday+sum)%7;
        }
        for(int i=0;i<12;i++){
            System.out.println("\t\t\t"+months[i]+" "+year);
            System.out.println("------------------------------------------");
            System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
            for(int j=0;j<weeks[i];j++)
                System.out.print("\t");
            int flag=weeks[i];
            for(int k=1;k<=days[i];k++){
                System.out.printf("%4d",k);
                flag++;
                if(flag%7==0&&flag!=0)
                    System.out.println();
            }
            System.out.println();
        }
    }
}
class exe28{
    public static void main(String[] args) {
        for(int i=1;i<=10000;i++){
            int sum=0;
            for(int j=1;j<i;j++)
                if(i%j==0)
                    sum+=j;
            if(sum==i)
                System.out.println(i);
        }
    }
}
class exe29{
    public static void main(String[] args) {
        String[] game={"scissor","rock","paper"};
        Scanner input=new Scanner(System.in);
        int com_n=0,usr_n=0;
        while(com_n<=2||usr_n<=2) {
            System.out.print("scissor(0),rock(1),paper(2):");
            int user = input.nextInt();
            int computer = (int) (Math.random() * 3);
            if (user == computer) {
                System.out.println("The computer is " + game[computer] + ".You are " + game[user] + ".It is draw");
            } else {
                if (user == 0 && computer == 2 || user == 1 && computer == 0 || user == 2 && computer == 1) {
                    System.out.println("The computer is " + game[computer] + ".You are " + game[user] + ".You won");
                    usr_n++;
                } else {
                    System.out.println("The computer is " + game[computer] + ".You are " + game[user] + ".You lost");
                    com_n++;
                }
            }
        }
        input.close();
    }
}
class exe30{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter an decimal number:");
        int decimal=in.nextInt();
        String r="";
        while (decimal!=0){
            int tmp=decimal%8;
            r+=tmp+"";
            decimal/=8;
        }
        char[] r_reversed=r.toCharArray();
        for(int i=r_reversed.length-1;i>=0;i--)
            System.out.print(r_reversed[i]);
    }
}
class exe31{
    public static void main(String[] args) {
        System.out.println((30000-5000-5000*0.18)/0.12+10000);
    }
}
class exe32{
    public static void main(String[] args) {
        int positive=0,negetive=0;
        for(int i=0;i<1000000;i++) {
            int j = (int) (Math.random()*2);
            if (j == 0)
                positive++;
            else
                negetive++;
        }
        System.out.println(positive+"  "+negetive);
    }
}
class exe33{
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int num,max=0,count=0;
        System.out.print("Enter numbers:");
        while (true){
            num=in.nextInt();
            if(num>max) {
                max = num;
                count=1;
            }else if(num==max)
                count++;
            if(num==0)
                break;
        }
        System.out.println("The largest number is "+max);
        System.out.println("The occurrence count of the largest number is "+count);
    }
}
class exe34{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter ten numbers:");
        Double[] nums=new Double[10];
        for(int i=0;i<10;i++)
            nums[i]=in.nextDouble();
        double sum1=0,sum2=0;
        for(int i=0;i<10;i++)
            sum1+=nums[i];
        System.out.println("The mean is "+sum1/10.0);
        for(int i=0;i<10;i++)
            sum2+=Math.pow(nums[i],2);
        sum2-=Math.pow(sum1,2)/10.0;
        System.out.println("The standard deviation is "+Math.sqrt(sum2/9.0));
    }
}
class exe35{
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.print("Enter ISBN:");
        String ISBN=in.nextLine();
        char[] nums=ISBN.toCharArray();
        if(nums.length==12) {
            int flag = 10 - (nums[0] + 3 * nums[1] + nums[2] + 3 * nums[3] + nums[4] + 3 * nums[5] + nums[6] + 3 * nums[7] + nums[8] + 3 * nums[9] + nums[10] + 3 * nums[11]) % 10;
            if (flag == 10)
                System.out.println(ISBN + '0');
            else
                System.out.println(ISBN + flag + "");
        }else
            System.out.println(ISBN+" is not an invalid input");
    }
}
class exe36{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the first string:");
        String str1=in.nextLine();
        System.out.print("Enter the second string:");
        String str2=in.nextLine();
        String tmp;
        int i,j=0;
        for(i=0;;i++){
            tmp=str1.substring(0,i);
            boolean flag=str2.startsWith(tmp);
            if(flag==false)
                if(i==1)
                {
                    j=1;
                    break;
                }
            else
                break;
        }
        if(j==0)
            System.out.println(tmp.substring(0,i-1));
        else
            System.out.println(str1+" and "+str2+" has no common prefix");
    }
}



























