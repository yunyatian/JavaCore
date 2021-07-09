package com.demo.stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveTypeStreams {
    public static void show(String title, IntStream stream){
        final int SIZE = 10;
        //将流转化为数组
        int[] firstElements = stream.limit(SIZE+1).toArray();
        System.out.print(title+":");
        for (int i= 0;i < firstElements.length; i++){
            if(i > 0 ) System.out.print(", ");
            if(i < SIZE) System.out.print(firstElements[i]);
            else System.out.print(".......");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        //generate生成一个无限流，其中内容是0-100内的任意值
        IntStream is1 = IntStream.generate(()->(int)(Math.random()*100));
        show("is1",is1);

        //5-10，不包括10
        IntStream is2 =IntStream.range(5,10);
        show("is2",is2);

        //5-10，包括10
        IntStream is3 = IntStream.rangeClosed(5,10);
        show("is3",is3);

        Path path = Paths.get("MyFile.txt");
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

        Stream<String> words = Stream.of(contents.split("\\PL+"));
        //将字符串长度作为元素转换为IntStream
        IntStream is4 = words.mapToInt(String::length);
        show("is4",is4);

        String sentence = "\uD835\uDD46 is the set of octonions.";
        System.out.println(sentence);
        //调用codePoints函数将码点数作为IntStream的元素
        IntStream codes = sentence.codePoints();
        //将Int流转化为Object流，并定义输出规范
        System.out.println(codes.mapToObj(c->String.format("%d",c)).collect(Collectors.joining(",")));

        //将0-100的IntStream通过boxed方法转换为Stream对象流
        Stream<Integer> integers = IntStream.range(0,100).boxed();
        //对象流调用mapToInt再将其转化为IntStream
        IntStream is5 = integers.mapToInt(Integer::intValue);
        show("is5",is5);

    }
}
