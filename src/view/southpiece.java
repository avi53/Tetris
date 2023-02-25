package view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;


/**
 * Instructions, black border with text saying white text instructions.
 */
public class southpiece extends JPanel {
    /** South piece width.*/
    private static final int SOUTH_WIDTH = 100;

    /** South piece height.*/
    private static final int SOUTH_HEIGHT = 100;

    /** South piece JPanel.*/
    private final JPanel mySouth = this;

    public southpiece() {
        createSouthPiece();
    }

    public void createSouthPiece() {
        mySouth.setBackground(Color.BLACK);
        mySouth.setPreferredSize(new Dimension(SOUTH_WIDTH, SOUTH_HEIGHT));
    }

}
