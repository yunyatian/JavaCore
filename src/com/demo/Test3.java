package com.demo;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test3 {
    public static void main(String args[]){
        List<String> list = new LinkedList<>();
        list.add("0201");
        list.add("0101");
        list.add("0102");
        list.add("1212");
        list.add("2002");
        System.out.println(Character.getNumericValue('9'));
        System.out.println(list.contains(new StringBuffer("0201").toString()));
        System.out.println((int)'9');
        String str = "werty";
        System.out.println(str.substring(0,5));
        int[] x = new int[]{1,2,3,4};
        List list1 = Arrays.asList(x);
        String[] deadends = new String[]{};
        List<String> deadendList = Arrays.asList(deadends);
    }
}
