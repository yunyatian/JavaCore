package com.demo.equal;

import com.demo.inheritance.Employee;
import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object otherObject){
        if(!super.equals(otherObject))
            return false;
        Manager other = (Manager)otherObject;
        return bonus==other.bonus;
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(),bonus);
    }

    @Override
    public String toString(){
        return super.toString()+"[bonus:"+bonus+"]";
    }
}
