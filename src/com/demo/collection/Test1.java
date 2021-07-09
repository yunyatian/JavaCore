package com.demo.collection;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList();
        //Object object = new Object();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
        System.out.println(list.remove());
        list.removeAll(list);
        for (String s:list) {
            System.out.println(s);
        }

        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("a");
        linkedHashSet.add("b");
        linkedHashSet.add("a");
        linkedHashSet.add("c");
        linkedHashSet.add("a");
        System.out.println(linkedHashSet);
//        实现list列表的正向输出
//        Iterator  listIterator = list.iterator();
//        while (listIterator.hasNext()){
//            System.out.print(listIterator.next());
//        }
        //实现list链表反向输出
        ListIterator listIterator = list.listIterator(list.size());
        while(listIterator.hasPrevious()){
            System.out.print(listIterator.previous());
        }
    }

}
