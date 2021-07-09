package com.demo.interfaces;

import java.util.Arrays;

public class EmployeeSortTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("yuan",200000);
        staff[1] = new Employee("jun",450000);
        staff[2] = new Employee("sen",360000);
        Arrays.sort(staff);//使用此方法Employee必须实现Comparable接口
        for (Employee e:
             staff) {
            System.out.println(e);
        }
    }
}
