package view;

import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;


/**
 * Instructions, black border with text saying white text instructions.
 * @author David Hoang
 * @author Avinash Bavisetty
 * @author Yonas Omega
 * @author Jose Rodriguez
 * @version Winter 2023
 */
public class SouthPiece extends JPanel {
    /** South piece width.*/
    private static final int SOUTH_WIDTH = 100;

    /** South piece height.*/
    private static final int SOUTH_HEIGHT = 100;

    private static JTextField textField;



    /** A label to display the message. */
    private JLabel myMessageLabel1;
    /** A label to display the message. */
    private JLabel myMessageLabel2;

    /**
     * South piece constructor. Initialize the south piece panel.
     */
    public SouthPiece() {
        super();

        createSouthPiece();
    }

    /**
     * Create the south piece width, height, and set the color.
     */
    private void createSouthPiece() {
        setLayout(new GridLayout(4,3));
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(SOUTH_WIDTH, SOUTH_HEIGHT));
        myMessageLabel1 = new JLabel("Move Left: A ");
        myMessageLabel2 = new JLabel("Move Right: D ");

        myMessageLabel1.setVerticalAlignment(JLabel.TOP);
        myMessageLabel1.setHorizontalAlignment(JLabel.LEFT);
        myMessageLabel1.setForeground(Color.WHITE);
        add(myMessageLabel1);
        add(myMessageLabel2);


    }

}
