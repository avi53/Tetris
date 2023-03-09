package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.LinkedList;
import javax.swing.JPanel;

import model.Block;
import model.Board;
public class CenterPanel extends JPanel implements PropertyChangeListener {
    /**
     * center width.
     */
    private static final int CENTER_WIDTH = 300;
    /**
     * center height.
     */
    private static final int CENTER_HEIGHT = 500;

    /**
     * The width for the rectangle.
     */
    private static final int PIECE_SIZE = 50;

    /** temp height setting. */
    private static final int HEIGHT = 500;

    /** temp width setting. */
    private static final int WIDTH = 300;

    private final Rectangle2D myShape;


    /** The background color. */
    private  LinkedList<Block[]> myFrozenBlocks;


    public CenterPanel() {
        super();
        createCenterPiece();
        myShape = new Rectangle2D.Double(0,0,50,50);
    }

    private void createCenterPiece() {
        setPreferredSize(new Dimension(CENTER_WIDTH, CENTER_HEIGHT));
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
        if (propertyName.equals(Board.PROPERTY_FROZEN_BLOCKS_SIZE)) {
            myFrozenBlocks = (LinkedList<Block[]>) theEvt.getNewValue();
        }
    }

    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;

        // going through the frozen blocks list.
       // for(int i=0; i< myFrozenBlocks.size();i++) {
          // final Block[] row= myFrozenBlocks.get(i);
           // for (int j=0; j< row.length; j++) {
             //   row[j]= Block.J;
           // }
        //}
        // for better graphics display
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setPaint(Color.RED);

        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                g2d.draw(new Rectangle2D.Double(col * PIECE_SIZE,
                        row * PIECE_SIZE,
                        PIECE_SIZE,
                        PIECE_SIZE));
            }
        }
        g2d.setPaint(Color.RED);
        g2d.fill(myShape);
    }
}
