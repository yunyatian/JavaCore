package com.demo.inheritance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data//创建所有的get和set方法
@AllArgsConstructor//创建有参构造器
@NoArgsConstructor//创建无参构造器
public class Employee extends People{
    private String name;
    private double salary;
    private LocalDate hirDay;

    //加薪
    public double raiseSalary(double raisePercent){
        salary+=salary*raisePercent/100;
        return  salary;
    }

    @Override
    public void getDescription() {
        System.out.println("我是"+this.getName());
    }
}
