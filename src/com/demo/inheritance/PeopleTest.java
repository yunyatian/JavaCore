package com.demo.inheritance;

import java.time.LocalDate;

public class PeopleTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        //LocalDate localDate = LocalDate.of(2021,3,13);
        LocalDate localDate = LocalDate.now();
        Manager boss = new Manager("yuan",100000,localDate,100000);
        staff[0] = boss;
        staff[1] = new Employee("hbkkn",68788,localDate);
        staff[2] = new Employee("fhfh",79848,localDate);
        for (Employee e: staff) {
            System.out.println("姓名："+e.getName()+" 薪水："+e.getSalary()+" 入职时间："+e.getHirDay());
        }
        People[] people = new People[2];
        people[0] = staff[1];
        people[1] = new Student("ghfdh","IT");
        for (People p:
             people) {
            p.getDescription();
        }
    }
}
