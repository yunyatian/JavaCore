package com.demo.charpter3;

public class Message {
    public static void main(String[] args) {
        if(args.length == 0 || args[0] == "-h"){
            System.out.print("Hello");
        } else if (args[0] == "-g") {
            System.out.print("Goodbye,");
        }
        for (int i = 1; i < args.length; i++) {
            System.out.print("" + args[i]);
        }
        System.out.println("!");
    }
}
