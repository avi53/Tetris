package view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;


/**
 * Score user, user information, Green.
 */
public class westpiece extends JPanel {
    /** West piece width.*/
    private static final int WEST_WIDTH = 100;

    /** West piece height.*/
    private static final int WEST_HEIGHT = 100;

    /** West piece JPanel.*/
    private final JPanel myWest = this;

    public westpiece() {
        createWestPiece();
    }

    public void createWestPiece() {
        myWest.setPreferredSize(new Dimension(WEST_WIDTH, WEST_HEIGHT));
        myWest.setBackground(Color.GREEN);
    }
}
