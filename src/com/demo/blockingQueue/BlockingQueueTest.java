package com.demo.blockingQueue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BlockingQueueTest {
    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 10;
    private static final Path DUMMY = Paths.get("");
    //ArrayBlockingQueue是一个指定容量的阻塞队列。该队列实现为一个循环数组
    private static BlockingQueue<Path> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    public static void main(String args[]){
        try(Scanner in = new Scanner(System.in)){
            System.out.print("输入目录：");
            String directory = in.nextLine();
            System.out.print("请输入关键字：");
            String keyboard = in.nextLine();

            //创建一个Runnable
            Runnable enumerator = () ->
            {
                try {
                    enumerate(Paths.get(directory));
                    queue.put(DUMMY);
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            };
            //通过Runnable实例化一个Thread线程，调用线程的start方法，会启动Runnable里面书写的方法即run方法
            new Thread(enumerator).start();
            //for循环的意义未知，但去掉仍能运行
            for (int i = 0; i <= SEARCH_THREADS; i++){
                Runnable searcher = () ->
                {
                    try{
                        boolean done = false;
                        while(!done){
                            Path file = queue.take();
                            if(file == DUMMY){
                                queue.put(file);
                                done = true;
                            }else{
                                search(file,keyboard);
                            }
                        }
                    } catch (InterruptedException | IOException e) {
                        e.printStackTrace();
                    }
                };
                new Thread(searcher).start();
            }
        }
    }

    private static void search(Path file, String keyboard) throws IOException {
        try(Scanner in = new Scanner(file, String.valueOf(StandardCharsets.UTF_8))){
            int lineNumber = 0;
            while(in.hasNextLine()){
                lineNumber++;
                String line = in.nextLine();
                if(line.contains(keyboard)){
                    System.out.printf("%s:%d:%s%n",file,lineNumber,line);
                }
            }
        }
    }

    private static void enumerate(Path path) throws IOException, InterruptedException {
        try(Stream<Path> children = Files.list(path)) {
            for(Path child: children.collect(Collectors.toList())){
                //会一直寻找到子目录为止
                if (Files.isDirectory(child)){
                    enumerate(child);
                }else{
                    queue.put(child);
                }
            }
        }
    }
}
