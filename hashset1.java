package hashing;

import java.util.HashSet;
import java.util.Iterator;

public class hashset1 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        // add
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(3);
        set.add(3);
        set.add(4);
        set.add(4);

        System.out.println(set);

        //size
        System.out.println("the size is: "+ set.size());

        //Iterator
        Iterator it = set.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
