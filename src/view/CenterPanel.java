package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;
import model.Board;
public class CenterPanel extends JPanel implements PropertyChangeListener {
    /** center width.*/
    private static final int CENTER_WIDTH = 300;
    /** center height.*/
    private static final int CENTER_HEIGHT = 500;
    /** center-piece jpanel.*/
    private final JPanel myCenterPanel = new JPanel();

    public CenterPanel() {
        super();
        createCenterPiece();
        Board.addPropertyChangeListener((PropertyChangeListener) myCenterPanel);
    }

    private void createCenterPiece() {
        myCenterPanel.setBackground(Color.RED);
        myCenterPanel.setPreferredSize(new Dimension(CENTER_WIDTH, CENTER_HEIGHT));
        add(myCenterPanel, BorderLayout.CENTER);
    }

    public void propertyChange(final PropertyChangeEvent theEvt) {

        final String propertyName = theEvt.getPropertyName();

        //if the property name equals to any of the specified properties below,
        // it repaints the center component (game board)
        if (propertyName.equals(Board.PROPERTY_DROP)
                ||
                propertyName.equals(Board.PROPERTY_GAME_OVER)
                ||
                propertyName.equals(Board.PROPERTY_SEQUENCE_INDEX)) {
            //when board state changes everytime the board (center component) gets repainted
            repaint();
        }
    }
}
