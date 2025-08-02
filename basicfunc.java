package ArrayList;

import java.util.ArrayList;

public class basicfunc {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // add
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(16);
        System.out.println(list);

        //size
        int size = list.size();
        System.out.println(size);

        //set
        list.set(0, 30);
        list.set(4, 40);

        //get
        int ele= list.get(3);
        System.out.println(ele);

        //delete
        list.remove(3);

        System.out.println(list);
    }
}
