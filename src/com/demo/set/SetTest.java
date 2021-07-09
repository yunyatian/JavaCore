package com.demo.set;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        Set words = new TreeSet<String>();
        long totalTime=0;
        try(Scanner in = new Scanner(Paths.get("MyFile.txt"), String.valueOf(StandardCharsets.UTF_8))){
            while (in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Iterator iterator = words.iterator();
        //因为set存储无序,所以读出来的结果与存储时的顺序不同
        for(int i = 0; i <= 20 && iterator.hasNext();i++){
            System.out.println(iterator.next());
        }
        System.out.println("...");
        System.out.println("words size："+words.size()+",Totaltime:"+totalTime);
        //证明set无序
//        for (int i = 0; i < 100000;i++){
//            words.add(i);
//        }
//        System.out.println(words);
    }
}
