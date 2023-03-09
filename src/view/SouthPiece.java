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
    /** A label to display the message.2 */
    private JLabel myMessageLabel2;

    /** A label to display the message. 3 */
    private JLabel myMessageLabel3;

    /** A label to display the message. 4 */
    private JLabel myMessageLabel4;

    /** A label to display the message. 5 */
    private JLabel myMessageLabel5;

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
        setLayout(new GridLayout(5,3));
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(SOUTH_WIDTH, SOUTH_HEIGHT));

        createMsgLabels();
        setColorMsgLabel();
        addMsgLabels();

    }

    /**
     * Helper method to Initialize message labels.
     */
    private void createMsgLabels(){
        myMessageLabel1 = new JLabel("Move Left: A ");
        myMessageLabel2 = new JLabel("Move Right: D ");
        myMessageLabel3 = new JLabel("Rotate: W");
        myMessageLabel4= new JLabel("Move Down: S");
        myMessageLabel5 = new JLabel("Drop: space");
    }
    /**
     * Helper method to set Message colors.
     */
    private void setColorMsgLabel(){
        myMessageLabel1.setForeground(Color.WHITE);
        myMessageLabel2.setForeground(Color.WHITE);
        myMessageLabel3.setForeground(Color.WHITE);
        myMessageLabel4.setForeground(Color.WHITE);
        myMessageLabel5.setForeground(Color.WHITE);
    }

    /**
     * Helper method to add message labels to panel.
     */
    private void addMsgLabels (){
        add(myMessageLabel1);
        add(myMessageLabel2);
        add(myMessageLabel3);
        add(myMessageLabel4);
        add(myMessageLabel5);

    }
}
