package com.demo.equal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@Data//创建所有的get和set方法
@AllArgsConstructor//创建有参构造器
@NoArgsConstructor//创建无参构造器
public class Employee{
    private String name;
    private double salary;
    private LocalDate hirDay;

    //加薪
    public double raiseSalary(double raisePercent){
        salary+=salary*raisePercent/100;
        return  salary;
    }


    @Override
    public boolean equals(Object otherObject){
        if(this==otherObject)//检测两个变量是否指向同一个实例化对象，若是的话，地址相同
            return true;
        if(otherObject==null)//将测对象是否为空
            return false;
        if(getClass()!=otherObject.getClass())//检测两个对象是否属于同一个类
            return false;
        Employee other = (Employee)otherObject;//将类进行强转
        //比较两个类的各个属性是否相同
        return Objects.equals(name,other.name)&&salary==other.salary&&Objects.equals(hirDay,other.hirDay);

    }

    @Override
    public int hashCode(){
        return Objects.hash(name,salary,hirDay);
    }

    @Override
    public String toString(){
        return getClass().getName()+"[name:"+name+"salary:"+salary+"hirDay:"+hirDay+"]";
    }
}
