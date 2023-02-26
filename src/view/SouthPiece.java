package view;

import java.awt.Color;
import java.awt.Dimension;
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

    /** South piece JPanel.*/
    private final JPanel mySouth = this;

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
        mySouth.setBackground(Color.BLACK);
        mySouth.setPreferredSize(new Dimension(SOUTH_WIDTH, SOUTH_HEIGHT));
    }

}
