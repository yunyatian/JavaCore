package com.demo.inheritance;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Student extends People{
    private  String major;

    public Student(String name,String major) {
        super(name);
        this.major = major;
    }

    @Override
    public void getDescription() {
        System.out.println("我是"+super.getName());
    }
}
