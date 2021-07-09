package com.demo.lambda;

import java.util.Arrays;

public class LambdaTest {
    public static void main(String args[]){
        String plants[] = new String[]{"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune"};
        System.out.println(Arrays.toString(plants));
        System.out.println("排序后：");
        Arrays.sort(plants);
        System.out.println(Arrays.toString(plants));
        System.out.println("通过长度排序：");
        Arrays.sort(plants,(first,second) -> first.length()-second.length());
        System.out.println(Arrays.toString(plants));
    }
}
