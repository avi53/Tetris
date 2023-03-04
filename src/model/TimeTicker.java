package model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeTicker extends JLabel implements ActionListener {
    private Timer timer;
    private int count = 0;

    public TimeTicker() {
        timer = new Timer(1000, this); // 1000 ms = 1 second
    }
    public void startTimer() {
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        count++;
        setText("Tick count: " + count);
        System.out.println(count);
    }
}