package com.demo.collecting;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResults {
    public  static Stream <String> noVowels() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("MyFile.txt")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));
        Stream<String> words = wordList.stream();

        //将流中的aeiouAEIOU替换成空格
        return words.map(s->s.replaceAll("[aeiouAEIOU]",""));
    }

    public static void show(String label, Set set){
        System.out.println(label+":"+set.getClass().getName());
        System.out.println("["
                //获取流中的10个元素，并将其实现toString方法之后转换为String
                +set.stream().limit(10).map(Object::toString).collect(Collectors.joining(","))
                +"]");
    }

    public static void main(String[] args) throws IOException {
        //生成无限流，再通过iterator方法将其转换为迭代器
        Iterator iter = Stream.iterate(0,n->n+1).limit(10).iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        //生成无限流，通过toArray方法将其转化为数组，也可以写成toArray(A::new)从而生成A类型的数组
        Object[] numbers = Stream.iterate(0,n->n+1).limit(10).toArray();
        System.out.println("Object array:"+numbers);
        for (Object o:
             numbers) {
            System.out.print(o+",");
        }
        System.out.println();

        try{
            Integer number = (Integer) numbers[0];
            System.out.println("number:"+number);
            System.out.println("The statement throws an exception");
            Integer[] number2 = (Integer[]) numbers;//Object不能强转为Integer类
        }catch(ClassCastException ex){
            System.out.println(ex);

        }

        Integer[] numbers3 = Stream.iterate(0,n->n+1).limit(10).toArray(Integer[]::new);
        System.out.println("Integer array:"+numbers3);
        for (Object o:
                numbers3) {
            System.out.print(o+",");
        }
        System.out.println();

        //通过Set手机流中的数据，toSet使用的是HashSet进行收集
        Set noVowelSet = noVowels().collect(Collectors.toSet());
        show("noVowelSet",noVowelSet);

        //同Collection(TreeSet::new)使用TreeSet来收集流中的元素
        TreeSet noVowelTreeSet = noVowels().collect(Collectors.toCollection(TreeSet::new));
        show("noVowelTreeSet",noVowelTreeSet);

        //joining方法使用String来收集流中的元素
        String result = noVowels().limit(10).collect(Collectors.joining());
        System.out.println("Joining:"+result);

        //joining方法可以在其中加入分隔符，从而使元素可以分割开
        result = noVowels().limit(10).collect(Collectors.joining(","));
        System.out.println("Joining the Commas:"+result);

        //summarizingInt方法可以对其内描述的内容进行求和操作，然后生成一个IntSummaryStatistics类
        IntSummaryStatistics summary = noVowels().collect(Collectors.summarizingInt(String::length));
        double averageWordLength = summary.getAverage();
        double maxWordLength = summary.getMax();
        System.out.println("Average word length :"+ averageWordLength);
        System.out.println("Max word length :"+ maxWordLength);
        System.out.println("forEach:");
        //流的foreach方法
        noVowels().limit(10).forEach(System.out::println);


    }
}
