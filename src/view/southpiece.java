package view;

import javax.swing.*;
import java.awt.*;

/**
 * Instructions, black border with text saying white text instructions
 */
public class southpiece extends JPanel {

    /** The background color. */


    public southpiece() {
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(100,100));
        addInsidePanel();
    }

    public void addInsidePanel(){
        JLabel userInfo = new JLabel("Instructions: ");
        userInfo.setBackground(Color.WHITE);

        this.add(userInfo, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
