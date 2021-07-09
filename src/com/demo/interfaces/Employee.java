package com.demo.interfaces;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@Data//创建所有的get和set方法
@AllArgsConstructor//创建有参构造器
@NoArgsConstructor//创建无参构造器
public class Employee implements Comparable<Employee>{
    private String name;
    private double salary;

    //加薪
    public double raiseSalary(double raisePercent){
        salary+=salary*raisePercent/100;
        return  salary;
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(salary,o.salary);
    }
}
