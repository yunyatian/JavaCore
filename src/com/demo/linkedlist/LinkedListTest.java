package com.demo.linkedlist;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest {
    public static void main(String[] args) {
        List list = new LinkedList();
        LinkedList list1 = new LinkedList();
        list1.add("yuan");
        list1.add("jun");
        list1.add("sen");
        LinkedList list2 = new LinkedList();
        list2.add("yang");
        list2.add("cai");
        list2.add("shi");
        list2.add("zheng");
        list2.add("yong");
        list2.add("yan");
        System.out.println(list1.toString());
        ListIterator alistIter = list1.listIterator();
        ListIterator blistIter = list2.listIterator();

        //将list2的元素插入list1中
        while(blistIter.hasNext()){
            if (alistIter.hasNext()){
                alistIter.next();
            }
            alistIter.add(blistIter.next());
        }
        System.out.println(list1);

        //将list2的元素进行每隔一个元素删除一个元素
        blistIter = list2.listIterator();//需要重新让blistIter回到表头，因为在上一个循环中已经遍历到了表的尾端
        while(blistIter.hasNext()){
            blistIter.next();
            if (blistIter.hasNext()){
                blistIter.next();
                blistIter.remove();
            }
        }
        System.out.println(list2);

        //删除list1中含有list2的元素
        list1.removeAll(list2);
        System.out.println(list1);
    }
}
