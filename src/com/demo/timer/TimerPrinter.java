package com.demo.timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class TimerPrinter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone,the time is "
                            + Instant.ofEpochMilli(e.getWhen()));
        Toolkit.getDefaultToolkit().beep();//获得默认工具箱，并发出一声响铃
    }

}
