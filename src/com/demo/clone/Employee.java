package com.demo.clone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Cloneable {//对象中如果要调用clone方法，就必须实现Cloneable接口，否则将会抛出异常
    private String name;
    private double salary;
    private Date hirDay;

    public void raiseSalary(double byPercent){
        salary += salary*byPercent/100;
    }

    public Employee clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();
        cloned.hirDay = (Date)hirDay.clone();//深度拷贝，因为hirDay也是可变的对象，所以需要单独进行拷贝，否则上一个拷贝出来的两个对象的hirDay仍旧指向同一个hirDAy对象
        return cloned;
    }

}
