package view;

import java.awt.*;
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



    /** A label to display the message. */
    private JLabel myMessageLabel;

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


        setLayout(new FlowLayout());
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(SOUTH_WIDTH, SOUTH_HEIGHT));
        myMessageLabel = new JLabel(" Instructions");
        myMessageLabel.setForeground(Color.WHITE);
        add(myMessageLabel);

    }

}
