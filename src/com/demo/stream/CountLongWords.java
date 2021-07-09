package com.demo.stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CountLongWords {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("MyFile.txt")), StandardCharsets.UTF_8);

//        List<String> words = Arrays.asList(contents.split("\\PL+"));//\\PL+的意思是以非字母进行分割
        //平常数组创建流
        Stream<String> words = Stream.of(contents.split("\\PL+"));


        long count = 0;
//        for (String w:words
//             ) {
//            if (w.length()>12) count++;
//        }
//        System.out.println(count);

        count = words.filter(w -> w.length()>12).count();
//        count = words.stream().filter(w -> w.length()>12).count();
        System.out.println(count);

//        count = words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println(count);
    }
}
