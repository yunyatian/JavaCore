package com.demo.inheritance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public  abstract class People {//抽象类
    public abstract void getDescription();
    private String name;


}
