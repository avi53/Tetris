package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;




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

    /** how many rows grid should have. */
    private static final int ROWS = 6;
    /** how many columns grid should have. */
    private static final int COL = 2;

    /** Image Size. */

    private static final int IMG_SZE = 1200;
    /** A label to display the message. */
    private JLabel myMessageLabel1;
    /** A label to display the message 2. */
    private JLabel myMessageLabel2;

    /** A label to display the message. 3 */
    private JLabel myMessageLabel3;

    /** A label to display the message. 4 */
    private JLabel myMessageLabel4;

    /** A label to display the message. 5 */
    private JLabel myMessageLabel5;

    /** A label to display the message. 6 */
    private JLabel myMessageLabel6;

    /** A label to display the message. 6 */
    private JLabel myMessageLabel7;

    /** Background image. */
    private  Image myBackground;



    /**
     * South piece constructor. Initialize the south piece panel.
     */
    public SouthPiece() {
        super();

        try {
            myBackground = ImageIO.read(new File("src/image/image.jpg"));
        } catch (final IOException e) {
            e.printStackTrace();
        }

        createSouthPiece();
    }

    /**
     * Create the south piece width, height, and set the color.
     */
    private void createSouthPiece() {
        setLayout(new GridLayout(ROWS, COL));
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(SOUTH_WIDTH, SOUTH_HEIGHT));

        createMsgLabels();
        setColorMsgLabel();
        addMsgLabels();

    }

    /**
     * Helper method to Initialize message labels.
     */
    private void createMsgLabels() {
        myMessageLabel1 = new JLabel("Move Left: A Or  ← ");
        myMessageLabel2 = new JLabel("Move Right: D Or →");
        myMessageLabel3 = new JLabel("Rotate Clockwise: W Or ↑");
        myMessageLabel4 = new JLabel("Move Down: S Or ↓");
        myMessageLabel5 = new JLabel("Drop: space ");
        myMessageLabel6 = new JLabel("Pause/Unpause: P ");
        myMessageLabel7 = new JLabel("Rotate Counter Clockwise: E");
    }
    /**
     * Helper method to set Message colors.
     */
    private void setColorMsgLabel() {
        myMessageLabel1.setForeground(Color.WHITE);
        myMessageLabel2.setForeground(Color.WHITE);
        myMessageLabel3.setForeground(Color.WHITE);
        myMessageLabel4.setForeground(Color.WHITE);
        myMessageLabel5.setForeground(Color.WHITE);
        myMessageLabel6.setForeground(Color.WHITE);
        myMessageLabel7.setForeground(Color.WHITE);
    }

    /**
     * Helper method to add message labels to panel.
     */
    private void addMsgLabels() {
        add(myMessageLabel1);
        add(myMessageLabel2);
        add(myMessageLabel3);
        add(myMessageLabel4);
        add(myMessageLabel5);
        add(myMessageLabel6);
        add(myMessageLabel7);

    }

    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;

        g2d.drawImage(myBackground, 0, 0, IMG_SZE, IMG_SZE, null);
    }
}
