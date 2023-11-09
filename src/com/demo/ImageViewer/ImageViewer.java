package com.demo.ImageViewer;

import com.sun.javafx.iio.ImageFrame;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ImageViewer {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ImageViewerFrame frame = new ImageViewerFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ImageViewerFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    public ImageViewerFrame(){

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        JLabel jLabel = new JLabel();
        add(jLabel);

        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(new File("."));

        JMenuBar jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);

        JMenu jMenu = new JMenu("File");
        jMenuBar.add(jMenu);

        JMenuItem openItem = new JMenuItem("Open");
        jMenu.add(openItem);

        openItem.addActionListener(event -> {
            int result = jFileChooser.showOpenDialog(null);

            if (result == jFileChooser.APPROVE_OPTION){
                String name = jFileChooser.getSelectedFile().getPath();
//                System.out.println(name);
                jLabel.setIcon(new ImageIcon(name));
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        jMenu.add(exitItem);
        exitItem.addActionListener(event -> System.exit(0));
    }

}
