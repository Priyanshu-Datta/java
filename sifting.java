package bitmanipulation;

public class sifting {
    public static void main(String[] args) {
        int n = 1;
        for(int i=0;i<32;i++){
            System.out.println(n);
            n = n<<1;
        }
    }
}
