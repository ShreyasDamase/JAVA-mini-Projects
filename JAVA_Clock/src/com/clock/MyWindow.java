package com.clock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;//
import java.awt.event.ActionListener;//
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyWindow extends JFrame {
    private  JLabel heading;

    private JLabel clockLable;
    private final Font font=new Font("",Font.BOLD,35);
    public MyWindow() {
        super.setTitle("My Clock");
        super.setSize(500, 500);
        super.setLocation(450,80);
        this.createGUI();
        this.startClock();
        super.setVisible(true);

    }
    public void createGUI()
    {
        heading =new JLabel("My Clock");
        clockLable =new JLabel("Clock");
        heading.setFont(font);
        this.setLayout(new GridLayout(2,1));
        this.add(heading);
        this.add(clockLable);
    }
    public void startClock()
    {
        //with Timer class
//        Timer timer =new Timer(100,new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                Date date = new Date();
//                SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss a G");
//                String dateTime=sdf.format(date);
//                 clockLable.setText(dateTime);
//            }
//        });
      //  timer.start();
        Thread t =new Thread(){
             public void run() {
                try {
                    while(true){

                            Date date = new Date();
                            SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss a G");
                            String dateTime=sdf.format(date);
                            clockLable.setText(dateTime);
                            //Thread.sleep(1000);
                            Thread.currentThread().sleep(1000);


                }
            } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
    };
        t.start();

}}
