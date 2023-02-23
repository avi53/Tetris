package view;

import javax.swing.*;

public class guiwindow extends JPanel {
    JFrame frame = new JFrame();

    public guiwindow() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,600);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(false);
    }


}
