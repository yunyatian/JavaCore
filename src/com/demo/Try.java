package com.demo;

public interface Try {
    void sdf();
    //接口内部可以有默认方法
    default void mg(){
        System.out.println("");
    }
}
