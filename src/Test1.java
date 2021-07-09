import com.Meiju;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) throws IOException {
//      \代表转义字符，表示其后的是自己本身的字符\"\"打印出来的是""
        System.out.println("\"\"");
        System.out.println("\\.|\\/|\\:");
        System.out.println(Instant.now().getClass().getName());
        System.out.println(Instant.now());
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(d);
        System.out.println("格式化后的日期：" + dateNowStr);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Instant.now());
        System.out.println(Instant.now().plus(1, ChronoUnit.HOURS));
        String string = "hive_xm";
//        仅仅在list内添加一个元素，且不能在添加其他元素
//        List<String> strings = Collections.singletonList(string);
        List<String> strings = new LinkedList<>();
        strings.add(string);
        strings.add("hive_ym");
        List<String> list1 = strings.stream().filter(s -> s.startsWith("hive_")).map(s -> s.split("hive_")[1]).collect(Collectors.toList());
        for (String str:list1) {
            System.out.println(str);
        }
//        System.out.println();
//        System.out.println(strings.size());

//        BigDecimal bigDecimal = new BigDecimal(2.0-1.1);//BigDecimal是不允许有任何误差的类
//        System.out.println(bigDecimal);
//        System.out.println("\u0022+\u0022yuan\u0022+\u0022");//\u0022代表“引号
//        double b = 0.98765;
//        System.out.println(Math.round(b));
//        BigDecimal bigDecimal1 = BigDecimal.valueOf(2);
//        System.out.println(bigDecimal1.divide(BigDecimal.valueOf(3),RoundingMode.HALF_UP));
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("asfdsa");
//        stringBuilder.append("rrr");
//        String string = stringBuilder.toString();
//        System.out.println(string);
//        PrintWriter out = new PrintWriter("MyFile.txt", String.valueOf(StandardCharsets.UTF_8));
//        out.println("hello!");
//        out.append("world.");
//        out.close();
//        Scanner in = new Scanner(Paths.get("MyFile.txt"),String.valueOf(StandardCharsets.UTF_8));
//        //System.out.println(in.nextLine());
//
//        Integer a=100;
//        Integer c=100;
//        System.out.println(a==c);//在-128到127之间的数值会被包装到固定的对象中故比较值为true
//
//        System.out.println(Meiju.valueOf("WE").name());
//        System.out.println(Meiju.valueOf("WE").getName());
//
//        Long seconds = Instant.now().getEpochSecond();
//        System.out.println(seconds);
//        Instant time = Instant.ofEpochSecond(seconds);
//        System.out.println(time);
//
//        System.out.println((char)('x'+1));
//        String string4 = "lmlk";
//        string4 = string4+"kk";
//        System.out.println(string4);

        char[] chars = new char[]{'b','1','c','2'};
        for (int i = 0; i < chars.length; i++){
//            System.out.println(chars[i]);
            if (i%2 != 0){
                System.out.print(chars[i-1]);
                long x = Long.parseLong(String.valueOf(chars[i]));
                chars[i] = (char)(chars[i-1]+x);
                System.out.print(chars[i]);
            }
        }
        String s = "dfmdfk";
        chars = s.toCharArray();
        System.out.println(chars);

        LinkedList list = new LinkedList();
        list.add("mm");
        System.out.println(list);
        list.remove();
        System.out.println(list);
        Instant time1 = Instant.now();
        Instant time2 = Instant.now();
        Long de = time1.getEpochSecond()-time2.getEpochSecond();
        Instant time3 =Instant.ofEpochSecond(de);
        System.out.println(time3);
    }
}
