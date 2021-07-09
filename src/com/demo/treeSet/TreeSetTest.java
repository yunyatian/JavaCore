package com.demo.treeSet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        Set parts = new TreeSet();
        parts.add(new Item("perfect",01));
        parts.add(new Item("good",02));
        parts.add(new Item("nice",03));

        System.out.println(parts);
        TreeSet sortByDescription = new TreeSet<Item>(Comparator.comparing(Item::getDescription));//自动生成根据Item的描述进行排序的比较器
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}
