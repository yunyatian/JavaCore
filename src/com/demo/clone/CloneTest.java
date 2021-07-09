package com.demo.clone;

import java.util.Date;
import java.util.GregorianCalendar;

public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date(2021,3,13);
        Employee employee = new Employee("yuanjunsen",1000000,date);
        Employee copy = employee.clone();
        copy.raiseSalary(100);
        copy.setHirDay(new GregorianCalendar().getTime());
        System.out.println(employee.getSalary());
        System.out.println(copy.getSalary());
        System.out.println(copy.getHirDay());
        System.out.println(employee.getHirDay());
    }
}
