import java.util.HashSet;

public class hashset {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        set.add("apple");
        set.add("banana");
        set.add("apple");  
        set.add("orange");

        System.out.println(set); 
    }
}
