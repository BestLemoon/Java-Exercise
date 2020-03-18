public class exe3 {
    public static void main(String[] args) {
        float pi=0,n=2;
        for(int i=1;i<1000000;i+=2,n++){
            pi+=(int)Math.pow(-1,n)*(1.0/i);
        }
        pi*=4;
        System.out.println(pi);
    }
}
