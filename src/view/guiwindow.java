package view;

import javax.swing.*;


import java.awt.*;

public class guiwindow extends JPanel {
    JFrame frame = new JFrame();

    public guiwindow() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,600);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(true);
        frame.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        JPanel colorPanel = new JPanel();

        colorPanel.setBackground(Color.GRAY);

        colorPanel.setPreferredSize(new Dimension(300, 300));

        centerPanel.add(colorPanel);

        frame.add(centerPanel, BorderLayout.CENTER);

        JPanel eastPanel = new JPanel();

        JPanel colorPanel2 = new JPanel();

        colorPanel2.setBackground(Color.BLACK);

        colorPanel2.setPreferredSize(new Dimension(100, 500));



        westpiece westpiece = new westpiece();
        southpiece southpiece = new southpiece();
        eastPanel.add(colorPanel2);

        frame.add(westpiece, BorderLayout.WEST);
        frame.add(southpiece, BorderLayout.SOUTH);
        frame.add(eastPanel, BorderLayout.EAST);
    }

}
