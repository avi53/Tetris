package view;

import javax.swing.*;
import java.awt.*;

/**
 * Score user, user information, Green
 */
public class westpiece extends JPanel {

    /** The background color. */


    public westpiece() {
        this.setBackground(Color.GREEN);
        this.setPreferredSize(new Dimension(100,100));
        addInsidePanel();
    }

    public void addInsidePanel(){
        JPanel insidePanel1 = new JPanel();
        insidePanel1.setLayout(new BorderLayout());
        insidePanel1.setPreferredSize(new Dimension(50,50));
        insidePanel1.add(new JLabel("User info: "));
        insidePanel1.setBackground(Color.GREEN);

        this.add(insidePanel1, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
