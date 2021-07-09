package com.demo.timer;

import javax.swing.*;

public class TimeTest {
    public static void main(String[] args) {
        TimerPrinter listener = new TimerPrinter();
        Timer timer = new Timer(1000,listener);
        timer.start();//start方法会调用监听器的ActionPerformed方法
        JOptionPane.showMessageDialog(null,"Quit program");
        System.exit(0);
    }
}
