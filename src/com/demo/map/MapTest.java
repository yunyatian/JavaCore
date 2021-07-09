package com.demo.map;

import com.demo.interfaces.Employee;

import java.time.Instant;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map staff = new HashMap<String, Employee>();

        //LinkedHashMap会记忆插入元素的顺序
//        Map staff = new LinkedHashMap<String,Employee>();
        staff.put("144-25-5464",new Employee("Amy Lee",78900));
        staff.put("567-24-2546",new Employee("Harry Hacker",34567));
        staff.put("157-62-7935",new Employee("Gary Cooper",57392));
        staff.put("456-62-5527",new Employee("Francesca Cruz",85634));

        Instant time = Instant.now();
        System.out.println(time);

        //更改map输出形式
        Map<String,String> stringMap = new HashMap<>();
        stringMap.put("sdfds","csavs");
        stringMap.put("asdfs","afsf");
        Set<String> keySet = stringMap.keySet();
        //将set集合转换为数组
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        //给数组排序(升序)
//        Arrays.sort(keyArray);
        //因为String拼接效率会很低的，所以转用StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keyArray.length; i++) {
            // 参数值为空，则不参与签名 这个方法trim()是去空格
            if ((String.valueOf(staff.get(keyArray[i]))).trim().length() > 0) {
                sb.append(keyArray[i]).append(":").append(String.valueOf(stringMap.get(keyArray[i])).trim());
            }
            if (i != keyArray.length - 1) {
                sb.append(",");
            }
        }
        System.out.println(sb.toString());


        System.out.println(staff);

        //通过键来删除相对应的值
        staff.remove("567-24-2546");

        //put放入的键是之前已经定义好的话，那么会覆盖之前的值，并返回被覆盖的值，如果键不是之前定义好的，那么会返回null
        System.out.println(staff.put("456-62-5527",new Employee("Francesca Miller",85634)));

        //通过键来获取相对应的值
        System.out.println(staff.get("157-62-7935"));

        //lambda语句实现遍历map
        staff.forEach((k,v) ->
                System.out.println("key=" + k +",value=" + v));


        Map<Integer,Integer> map = new HashMap();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        System.out.println(map.computeIfPresent(2,Integer::sum));
//        System.out.println(map.compute(1,Integer::sum));
//        map.replaceAll(Integer::sum);
        System.out.println(map);
        //map.enrtySet返回一个键值对的Set集合
        //map.keySet返回一个键的Set集合
        //map.values返回一个值的Collection
        //以上生成的键值集合对其操作，map会相应产生影响
//        Set set = map.entrySet();
//        System.out.println(set);
        for (Map.Entry entry:map.entrySet()
             ) {
            System.out.println("key="+entry.getKey()+",value="+entry.getValue());
            System.out.println(entry);
        }


    }
}
