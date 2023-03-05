package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;
import model.Board;

public class EastPiece extends JPanel implements PropertyChangeListener {


    /** East piece width.*/
    private static final int EAST_WIDTH = 200;

    /** East piece height.*/
    private static final int EAST_HEIGHT = 500;


    /** East piece JPanel.*/
    private final JPanel myEastPanel = new JPanel();


    /**
     * East piece constructor. Initialize the east piece panel.
     */
    public EastPiece() {
        super();
        createEastPiece();
    }

    /**
     * Create the east piece width, height, and set the color.
     */
    private void createEastPiece() {
        myEastPanel.setBackground(Color.BLUE);
        myEastPanel.setPreferredSize(new Dimension(EAST_WIDTH, EAST_HEIGHT));
        add(myEastPanel, BorderLayout.EAST);
    }




    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if (Board.PROPERTY_NEXT_PIECE.equals(theEvent.getPropertyName())) {
            repaint();
        }

    }
}

