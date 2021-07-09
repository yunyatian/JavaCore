package com.demo.map;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.*;

public class ChangeMapValue {
    public static void main(String[] args) throws IOException {
        List<String> list = new LinkedList();
//        Scanner in = new Scanner(System.in);
        Map<String, Integer> map = new TreeMap<>();
        try(Scanner in = new Scanner(Paths.get("MyFile.txt"), String.valueOf(StandardCharsets.UTF_8))) {
            while (in.hasNext()) {
                list.add(in.next());
            }
        }
//        in.close();
        for (String string:list
             ) {
//          使用merge方法，如果键原先不存在，那么会将键string与1关联起来，如果键已经存在，将会使用Integer：：sum函数组合将原来的值进行加1操作
            map.merge(string,1,Integer::sum);

              //使用getOrDefault方法，给查询不到的键值一个初值，键->0，如果能查询到，就返回查询到的值
//            map.put(string,map.getOrDefault(string,0)+1);

            //调用putIfAbsent方法，只有在键原先存在（或者映射到null时），才会放入一个值
//            map.putIfAbsent(string,0);
//            map.put(string,map.get(string)+1);

            //通过containsKey判断当前的键是否存在，如果存在，就对值加1，如果不存在，就给定一个初值
//            if (map.containsKey(string)){
//                map.put(string,map.get(string)+1);
//            }else{
//                map.put(string,1);
//            }
        }
//        System.out.println(map);
        for (String string1: map.keySet()
             ) {
            System.out.println(string1+"="+map.get(string1));
        }
    }
}
