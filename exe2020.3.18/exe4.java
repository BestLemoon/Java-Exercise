public class exe4 {
    public static void main(String[] args) {
        long current_nums=312032486;
        long totalSeconds=365*24*60*60;
        long birth=totalSeconds/7;
        long death=totalSeconds/13;
        long immigrants=totalSeconds/45;
        for(int i=1;i<=5;i++){
            current_nums+=birth;
            current_nums-=death;
            current_nums+=immigrants;
            System.out.println(current_nums);
        }
    }
}
