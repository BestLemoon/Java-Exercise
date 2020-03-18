public class exe18 {
    public static void main(String[] args) {
        String []colors={"Clubs","Diamonds","Hearts","Spades"};
        String []nums={"Ace","1","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
        int num=(int)(Math.random()*13);
        int color=(int)(Math.random()*4);
        System.out.println("The card you picked is "+nums[num]+" of "+colors[color]);
    }
}
