package com.biosh.owner.web;


import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @description
 * @date 2019/10/9
 */
public class MainClass {

    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(12);
        integers.add(123);

        LinkedList<Object> linkedList = new LinkedList<>();

        integers.forEach(integer -> {
            System.out.println(integer);
        });

        Float aFloat = new Float(0.0 / 0.0);
        System.out.println(aFloat);

        int n = 2;

        n |= 1;
        System.out.println(n);
//        System.out.println(Float.isNaN(1.0/0));

        System.out.println(1 << 30);

//        HashSet<Object> sets = new HashSet<>();
//        sets.add("asd");
//        sets.add("asdasd");
//
//        HashMap<Object, Object> map = new HashMap<>();
//        map.put("asd", "asd");
//
//        ArrayList<Object> objects1 = new ArrayList<>(sets);
//
//        objects1.forEach(o -> {
//            System.out.println(o);
//        });
//        Iterator<String> iterator = objects.iterator();
    }

}
