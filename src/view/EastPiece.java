package view;

import model.Board;
import model.PropertyChangeEnabledBoardControls;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;

public class EastPiece extends JPanel {
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
     * Board object to be referenced.
     */
    private Board tetrisBoard = new Board();

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

    private void createNextPiecePanel() {
        final NextPiecePanel nextPiecePanel = new NextPiecePanel();
        myEastPanel.add(nextPiecePanel);
        tetrisBoard.addPropertyChangeListener(PropertyChangeEnabledBoardControls.PROPERTY_STEP, nextPiecePanel);
    }

    /**
     * Create the panel which displays the next piece.
     */
    private static final class NextPiecePanel extends JPanel implements PropertyChangeListener {
        private final JPanel myNextPiecePanel = new JPanel();

        private NextPiecePanel() {
            super();
            createAndShowPanel();

        }

        public void paintComponent(final Graphics theGraphics) {

        }

        private void createAndShowPanel() {
            myNextPiecePanel.setBackground(Color.BLUE);
            myNextPiecePanel.setPreferredSize(new Dimension(BLUE_WIDTH, BLUE_HEIGHT));
            add(myNextPiecePanel);

        }

        @Override
        public void propertyChange(PropertyChangeEvent theEvent) {
            if (Board.PROPERTY_CURRENT_PIECE.equals(theEvent.getPropertyName())) {
                repaint();
            }
        }
    }
}
