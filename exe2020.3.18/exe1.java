public class exe1 {
    public static void main(String[] args) {
        System.out.println("a\ta^2\ta^3\t");
        for(int i=1;i<5;i++){
            System.out.printf("%-4d%-4d%-4d\n",i,(int)Math.pow(i,2),(int)Math.pow(i,3));
        }
    }
}
