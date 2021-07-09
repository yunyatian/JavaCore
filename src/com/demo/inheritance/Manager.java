package com.demo.inheritance;

import lombok.Data;

import java.time.LocalDate;
@Data
public class Manager extends Employee {//继承Employee类，获得他的属性和方法
    private int bonus;

    public Manager(String name, double salary, LocalDate localDate, int bonus) {
        super(name, salary, localDate);//调用父类构造函数
        this.bonus = bonus;
    }

    //方法重写
    @Override
    public double getSalary() {
        return super.getSalary()+bonus;
    }
}
