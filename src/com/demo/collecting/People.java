package com.demo.collecting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class People {
    private String name;
    private int id;

    @Override
    public String toString() {
        return  getClass().getName()+"[" +
                "id="+id+
                ",name=" + name +
                ']';
    }
}
