package HomeWork2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arr = new MyArrayList<>(5);
        arr.myAdd(5);
        arr.myAdd(1);
        arr.myAdd(4);
        arr.myRemove(1);
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(9);
        arr.myAddAll(list);
        System.out.println(arr);

        MyHashSet<Integer> set = new MyHashSet<>(8);
        set.myAdd(4);
        set.myAdd(88);
        set.myAdd(44);
        set.myAdd(4);
        set.myRemove(88);
        set.myRemove(8);


    }
}
