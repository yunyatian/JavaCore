package com.demo.stream;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CreatingStreams {
    public static <T> void show(String title, Stream<T> stream){
        final int SIZE = 10;
        //stream.limit是限定这个列表的长度，collect（Collectors.toList（））将获取的元素转换为列表
        List<T> firstElements= stream.limit(SIZE+1).collect(Collectors.toList());
        System.out.print(title+":");
        for (int i = 0; i < firstElements.size(); i++){
            if(i > 0) System.out.print(", ");
            if(i < SIZE) System.out.print(firstElements.get(i));
            else System.out.print("......");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("MyFile.txt");
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

        Stream words = Stream.of(contents.split("\\PL+"));
        show("words",words);

        Stream songs = Stream.of("gently","down","the","Stream");
        show("songs",songs);

        Stream silence = Stream.empty();
        show("silence",silence);

        //使用generate方法会生成一个无限流，这个无限流的内容分就是括号内定义的元素或者方法生成的
        Stream echos = Stream.generate(()->"Echo");
        show("Echos",echos);

        Stream random = Stream.generate(Math::random);
        show("random",random);

        //使用iterate方法也会生成一个无限流，根据其中传参的种子，然后调用传参的方法对这个种子进行操作，不断填充流的内容
        Stream integers = Stream.iterate(BigInteger.ONE,n->n.add(BigInteger.ONE));
        show("integers",integers);

        //cmpile方法决定如何分割模式，splitAsStream产生一个流，这个流是将输入的部分符合之前定义的分割模式的部分
        Stream wordsAnotherWay = Pattern.compile("\\PL+").splitAsStream(contents);
        show("wordsAnotherWay",wordsAnotherWay);

        //将文件的一行文字输出为一个流
        try(Stream lines = Files.lines(path,StandardCharsets.UTF_8)){
            show("lines",lines);
        }

        //获取文件所有根目录输出为一个流
        Iterable<Path> iterable = FileSystems.getDefault().getRootDirectories();
        Stream rootDirectories = StreamSupport.stream(iterable.spliterator(),false);
        show("rootDirectories",rootDirectories);

        Iterator iterator = Paths.get("user/share/dict/words").iterator();
        Stream pathComponents = StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED),
                                                false);
        show("pathComponents",pathComponents);

    }
}
