package view;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.LinkedList;
import javax.swing.JPanel;
import model.*;

public class CenterPanel extends JPanel implements PropertyChangeListener {
    /**
     * center width.
     */
    private static final int CENTER_WIDTH = 400;
    /**
     * center height.
     */
    private static final int CENTER_HEIGHT = 800;

    /**
     * The width for the rectangle.
     */
    private static final int PIECE_SIZE = 40;

    /**
     * temp height setting.
     */
    private static final int HEIGHT = 20;

    /**
     * temp width setting.
     */
    private static final int WIDTH = 10;

    /**
     * Tetris piece.
     */
    private MovableTetrisPiece myPiece;

    /**
     * List of Frozen blocks.
     */
    private LinkedList<Block[]> myFrozenBlocks;


    public CenterPanel() {
        super();

        createCenterPiece();

        myFrozenBlocks = new LinkedList<>();

        for (int i = 0; i < HEIGHT; i++) {
            final Block[] row = new Block[WIDTH];

            for (int j = 0; j < WIDTH; j++) {
                row[j] = Block.EMPTY;
            }

            myFrozenBlocks.add(row);
        }
    }

    private void createCenterPiece() {
        setPreferredSize(new Dimension(CENTER_WIDTH, CENTER_HEIGHT));
    }

    public void propertyChange(final PropertyChangeEvent theEvt) {

        final String propertyName = theEvt.getPropertyName();

        // if the property name equals to any of the specified properties below,
        // it repaints the center component (game board)
        if (propertyName.equals(Board.PROPERTY_DROP)
                || (propertyName.equals(Board.PROPERTY_GAME_OVER))
                ||
                propertyName.equals(Board.PROPERTY_SEQUENCE_INDEX)){ //when board state changes everytime the board (center component) gets repainted
            repaint();

        } else if (propertyName.equals(Board.PROPERTY_FROZEN_BLOCKS_SIZE)) {
            myFrozenBlocks = (LinkedList<Block[]>) theEvt.getNewValue();

        } else if ("rotation".equals(theEvt.getPropertyName())) {
            repaint();
        } else if (propertyName.equals(Board.PROPERTY_CURRENT_PIECE)) {
            myPiece = (MovableTetrisPiece) theEvt.getNewValue();
            repaint();
        }
        repaint();
    }

    public static Color getBlockColor(final Block theBlock) {
        return switch (theBlock) {
            case I -> Color.CYAN;
            case J -> Color.BLUE;
            case L -> Color.ORANGE;
            case O -> Color.YELLOW;
            case S -> Color.GREEN;
            case T -> Color.MAGENTA;
            case Z -> Color.RED;
            default -> Color.WHITE;
        };
    }

    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;

        // for better graphics display
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the current piece on the board

            // Draw the blocks of the piece
        if (myPiece != null) {
            final Color piece = getBlockColor(myPiece.getTetrisPiece().getBlock());
            g2d.setPaint(piece);

            // Draw the blocks of the piece
            final Block[] blocks = new Block[]{myPiece.getTetrisPiece().getBlock()};
            for (int i = 0; i < blocks.length; i++) {
                final int row = myPiece.getPosition().y();
                final int col = myPiece.getPosition().x();
                g2d.fill(new Rectangle2D.Double(col * PIECE_SIZE,
                        row * PIECE_SIZE,
                        PIECE_SIZE,
                        PIECE_SIZE));
            }
        }
        // going through the frozen blocks list.
        for (int i = 0; i < myFrozenBlocks.size(); i++) {

            final Block[] row = myFrozenBlocks.get(i);

            for (int j = 0; j < row.length; j++) {

                if (row[j] != Block.EMPTY) {
                    final Block block = myPiece.getTetrisPiece().getBlock();
                    final Color colorBlock = getBlockColor(block);
                    g2d.setPaint(colorBlock);
                    g2d.fill(new Rectangle2D.Double(j * PIECE_SIZE,
                            i * PIECE_SIZE,
                            PIECE_SIZE,
                            PIECE_SIZE));
                }
            }
        }

        //draws grid lines on the board
        g2d.setPaint(Color.BLACK);
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                g2d.draw(new Rectangle2D.Double(col * PIECE_SIZE,
                        row * PIECE_SIZE,
                        PIECE_SIZE,
                        PIECE_SIZE));
            }
        }
    }
}