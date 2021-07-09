package com.demo.equal;

import java.time.LocalDate;

public class EqualTest {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Alice",1500, LocalDate.of(2021,3,13));
        Employee employee2 = employee1;
        Employee employee3 = new Employee("Alice",1500, LocalDate.of(2021,3,13));
        Employee employee4 = new Employee("Bob",1000, LocalDate.of(2021,3,12));
        System.out.println("employee1==employee2:"+(employee1==employee2));//两个变量指向同一个实例化对象
        System.out.println("employee1==employee3:"+(employee1==employee3));//两个变量指向不同的实例化对象，==比的是地址，不同实例化对象指向不同的地址
        System.out.println("employee1.equals(employee3):"+employee1.equals(employee3));//equals比的是内容
        System.out.println("employee1.equals(employee4):"+employee1.equals(employee4));

        Manager boss = new Manager("Lisa",100000,LocalDate.now(),100000);
        Manager bigboss = new Manager("Lisa",100000,LocalDate.now(),100000);
        System.out.println("boss.toString:"+boss);
        System.out.println("bigboss.equals(boss):"+ bigboss.equals(boss));
        System.out.println("employee1.hashCode():"+employee1.hashCode());
        System.out.println("employee3.hashCode():"+employee3.hashCode());
        System.out.println("boss.hashCode():"+boss.hashCode());
        System.out.println("bigboss.hashCode():"+bigboss.hashCode());//对象相同散列码相同

        System.out.println("employee1.equals(boss):"+employee1.equals(boss));

        //StringBuilder stringBuilder = new StringBuilder("abcd");
        //StringBuilder stringBuilder1 = new StringBuilder("abcd");
        //System.out.println(stringBuilder.hashCode());
        //System.out.println(stringBuilder1.hashCode());
    }
}
