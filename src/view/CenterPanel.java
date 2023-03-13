package view;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.imageio.ImageIO;
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

    /** Background image. */
    private Image background;

    /**
     * Tetris piece.
     */
    private MovableTetrisPiece myPiece;
    /**
     * Board object to be referenced.
     */
    private Board myTetrisBoard  = new Board();

    /**
     * List of Frozen blocks.
     */
    private LinkedList<Block[]> myFrozenBlocks;


    public CenterPanel() {
        super();

        try {
            background = ImageIO.read(new File("src/image/image.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        createCenterPiece();

        myFrozenBlocks = new LinkedList<>();

        for (int i = 0; i < myTetrisBoard.getHeight(); i++) {
            final Block[] row = new Block[myTetrisBoard.getWidth()];

            for (int j = 0; j < myTetrisBoard.getWidth(); j++) {
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
                propertyName.equals(Board.PROPERTY_SEQUENCE_INDEX)) { //board state changes
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

        g2d.drawImage(background, 0, 0, 1200, 1200, null);

        // for better graphics display
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the current piece on the board

            // Draw the blocks of the piece
        if (myPiece != null) {
            // Draw the blocks of the piece
            final int[][] points =  myPiece.getTetrisPiece().getPointsByRotation(myPiece.getRotation());
            for (int i=0; i < 4; i++) {
                final Color pieceColor = getBlockColor(myPiece.getTetrisPiece().getBlock());
                final int x = (points[i][0] + myPiece.getPosition().x()) * PIECE_SIZE;
                final int y = (-(points[i][1]+ myPiece.getPosition().y()) + 19) * PIECE_SIZE;
                final Shape rectangle = new Rectangle2D.Double(x, y, PIECE_SIZE, PIECE_SIZE);
                g2d.setPaint(pieceColor);
                g2d.fill(rectangle);
                g2d.draw(rectangle);
            }
        }
        // going through the frozen blocks list.
        for (int i  = 0; i < myFrozenBlocks.size(); i++) {

            final Block[] row = myFrozenBlocks.get(i);

            for (int j = 0; j < row.length; j++) {

                if (row[j] != null && myPiece != null && row[j] !=Block.EMPTY) {

                    final Block block = row[j];
                    final Color colorBlock = getBlockColor(block);
                    g2d.setPaint(colorBlock);
                    g2d.fill(new Rectangle2D.Double(j * PIECE_SIZE,
                            (-i + 19) * PIECE_SIZE,
                            PIECE_SIZE ,
                            PIECE_SIZE));
                }
            }
        }

        //draws grid lines on the board
        g2d.setPaint(Color.BLACK);
        for (int row = 0; row < myTetrisBoard.getHeight(); row++) {
            for (int col = 0; col < myTetrisBoard.getWidth(); col++) {
                g2d.draw(new Rectangle2D.Double(col * PIECE_SIZE,
                        row * PIECE_SIZE,
                        PIECE_SIZE,
                        PIECE_SIZE));
            }
        }
    }
}