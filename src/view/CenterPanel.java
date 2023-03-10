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
import model.TetrisPiece;

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
    private static final int HEIGHT = 20;

    /** temp width setting. */
    private static final int WIDTH = 10;

    /** temp height setting. */
    private static final int HEIGHT1 = 50;

    /** temp width setting. */
    private static final int WIDTH2 = 50;


    /** shape. */
    private final Rectangle2D myShape;

    /** Tetris piece. */
    private TetrisPiece myPiece;


    /** List of Frozen blocks */
    private  LinkedList<Block []> myFrozenBlocks;

    public CenterPanel() {
        super();
        createCenterPiece();

        myShape = new Rectangle2D.Double(0, 0, WIDTH2, HEIGHT1);

        myFrozenBlocks = new LinkedList<>();

        for (int i = 0; i < HEIGHT; i++) {
            final Block[] row = new Block[WIDTH];

            for (int j = 0; j < WIDTH; j++) {
                row[j] = Block.EMPTY;
            }

            myFrozenBlocks.add(row);
        }

        myPiece = TetrisPiece.getRandomPiece();
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

        } else if (propertyName.equals(Board.PROPERTY_FROZEN_BLOCKS_SIZE)) {
            myFrozenBlocks = (LinkedList<Block[]>) theEvt.getNewValue();

        } else if ("rotation".equals(theEvt.getPropertyName())) {
            repaint();
        } else if (Board.PROPERTY_NEXT_PIECE.equals(theEvt.getPropertyName())) {
            myPiece = (TetrisPiece) theEvt.getNewValue();
            repaint();
        }
        repaint();
    }

    

    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;

        // for better graphics display
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // going through the frozen blocks list.
        for (int i = 0; i < myFrozenBlocks.size(); i++) {

            final Block[] row = myFrozenBlocks.get(i);

            for (int j = 0; j < row.length; j++) {

                if (row[j] != Block.EMPTY) {

                    final Color block;

                    switch (myPiece.getBlock()) {

                        case I:
                            block = Color.CYAN;
                            break;

                        case J:
                            block = Color.BLUE;
                            break;

                        case L:
                            block = Color.ORANGE;
                            break;

                        case O:
                            block = Color.YELLOW;
                            break;

                        case S:
                            block = Color.GREEN;
                            break;

                        case T:
                            block = Color.MAGENTA;
                            break;

                        case Z:
                            block = Color.RED;
                            break;

                        default:
                            block = Color.WHITE;
                            break;
                    }

                    g2d.setPaint(block);
                    g2d.fill(new Rectangle2D.Double(j * PIECE_SIZE,
                           i * PIECE_SIZE,
                           PIECE_SIZE,
                           PIECE_SIZE));
                }
            }
        }

        //draws grid lines on the board
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
