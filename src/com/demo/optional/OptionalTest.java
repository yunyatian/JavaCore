package com.demo.optional;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class OptionalTest {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("MyFile.txt")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));

        //将文件输出为流，从中寻找到第一个包含fred的元素，实例化Optional类
        Optional<String> optionalValue = wordList.stream()
                                .filter(s-> s.contains("fred"))
                                .findFirst();
        //如果该实例化对象为空的话，输出orElse定义的内容或对象，如果不为空的话，就输出Optional对象
        System.out.println(optionalValue.orElse("No word")+" contain fred");

        //生成一个空的Optional对象
        Optional<String> optionalString = Optional.empty();
        String result = optionalString.orElse("N/A");
        System.out.println("result:"+result);

        //如果Optional对象为空的话，就调用orElseGet方法内的内容生成一个对象，如果存在，就产生原来的Optional
        result = optionalString.orElseGet(()-> Locale.getDefault().getDisplayName());
        System.out.println("result:"+result);

        try{
            //如果Optional对象为空的话，抛出一个异常
            result = optionalString.orElseThrow(IllegalStateException::new);
            System.out.println("result:"+result);
        }catch(Throwable throwable){
            throwable.printStackTrace();
        }

        //产生一个流，寻找其中包含red字符的元素，并将其中找到的第一个返还给Optional类
        optionalValue = wordList.stream().filter(s->s.contains("red")).findFirst();
        //ifPresent用来判断Optional对象是否为空，如果不为空的话，就将其中的操作予以实现
        optionalValue.ifPresent(s-> System.out.println(s+"contain red"));

//        HashSet results = new HashSet<String>();
//        optionalValue.ifPresent(results::add);
//        Optional<Boolean> added = optionalValue.map(results::add);
//        System.out.println(added);

        //Optional类的flatMap相当于调用方法
        System.out.println(inverse(4.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(-1.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(0.0).flatMap(OptionalTest::squareRoot));

        //相当于创建了一个-4.0的Optional对象，然后调用了inverse（-4.0）方法生成一个Optional，然后再用这个结果进行squareRoot运算
        Optional<Double> result2 = Optional.of(-4.0).flatMap(OptionalTest::inverse).flatMap(OptionalTest::squareRoot);
        System.out.println(result2);





    }

    public static Optional<Double> inverse(Double x){
        return x== 0 ? Optional.empty() : Optional.of(1/x);
    }

    public static Optional<Double> squareRoot(Double x){
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }
}
