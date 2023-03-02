package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;

public class EastPiece extends JPanel implements PropertyChangeListener {
    /** East piece width.*/
    private static final int EAST_WIDTH = 200;

    /** East piece height.*/
    private static final int EAST_HEIGHT = 500;

    /** Blue square width.*/
    private static final int BLUE_WIDTH = 200;
    /** Blue square height.*/
    private static final int BLUE_HEIGHT = 200;
    /** East piece JPanel.*/
    private final JPanel myEastPanel = new JPanel();

    /**
     * East piece constructor. Initialize the east piece panel.
     */
    public EastPiece() {
        super();
        createEastPiece();
        createNextPiecePanel();
    }

    /**
     * Create the east piece width, height, and set the color.
     */
    private void createEastPiece() {
        myEastPanel.setBackground(Color.BLACK);
        myEastPanel.setPreferredSize(new Dimension(EAST_WIDTH, EAST_HEIGHT));
        add(myEastPanel, BorderLayout.EAST);
    }

    /**
     * Create the panel which displays the next piece.
     */
    private void createNextPiecePanel() {
        final JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);
        bluePanel.setPreferredSize(new Dimension(BLUE_WIDTH, BLUE_HEIGHT));
        myEastPanel.add(bluePanel);
    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {

    }
}
