package view;


import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collections;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import model.Board;
import model.MovableTetrisPiece;
import model.Point;
import model.TetrisPiece;

public class EastPiece extends JPanel implements PropertyChangeListener {


    /** East piece width.*/
    private static final int EAST_WIDTH = 200;

    /** East piece height.*/
    private static final int EAST_HEIGHT = 500;
    /** The next tetris piece.*/
    private TetrisPiece myPiece;


    /**
     * East piece constructor. Initialize the east piece panel.
     */
    public EastPiece() {
        super();
        InsidePanel insidePanel = new InsidePanel();
        add(insidePanel);
        createEastPiece();
    }


    /**
    * Create the east piece width, height, and set the color.
    */
    private void createEastPiece() {
        setBackground(Color.BLUE);
        setPreferredSize(new Dimension(EAST_WIDTH, EAST_HEIGHT));

    }

    public class InsidePanel extends JPanel {
        /** Inside panel width.*/
        private static final int WIDTH = 150;
        /** Inside panel height.*/
        private static final int HEIGHT = 150;

        public InsidePanel() {
            setBackground(Color.BLUE);
            setPreferredSize(new Dimension(WIDTH, HEIGHT));
            Font font = new Font("Arial", Font.BOLD, 16);
            font = font.deriveFont(Font.BOLD, 12f).deriveFont(Collections.singletonMap
                    (TextAttribute.FOREGROUND, Color.WHITE));

            Border border = BorderFactory.createCompoundBorder(
                    BorderFactory.createTitledBorder(
                            BorderFactory.createLineBorder(Color.WHITE, 2),
                            "Next Piece",
                            TitledBorder.CENTER,
                            TitledBorder.TOP,
                            font),
                    BorderFactory.createEmptyBorder(5, 5, 5, 5)
            );

            setBorder(border);
        }
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            if (myPiece != null) {
                final Point[] blocks = myPiece.getPoints();
                int minX = Integer.MAX_VALUE;
                int minY = Integer.MAX_VALUE;
                int maxX = Integer.MIN_VALUE;
                int maxY = Integer.MIN_VALUE;
                for (Point block : blocks) {
                    minX = Math.min(minX, block.x());
                    minY = Math.min(minY, block.y());
                    maxX = Math.max(maxX, block.x());
                    maxY = Math.max(maxY, block.y());
                }
                final int pieceWidth = (maxX - minX + 1) * 30;
                final int pieceHeight = (maxY - minY + 1) * 30;
                final int x = (getWidth() - pieceWidth) / 2;
                final int y = (getHeight() - pieceHeight) / 2;
                for (Point block : blocks) {
                    final int blockX = x + (block.x() - minX) * 30;
                    final int blockY = y + (block.y() - minY) * 30;
                    final Shape rectangle = new Rectangle2D.Double(blockX, blockY, 30, 30);
                    g2d.setPaint(Color.RED);
                    g2d.setStroke(new BasicStroke(10));
                    g2d.fill(rectangle);
                    g2d.setPaint(Color.BLACK);
                    g2d.setStroke(new BasicStroke(3));
                    g2d.draw(rectangle);
                }
            }
        }
    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {

        if (Board.PROPERTY_NEXT_PIECE.equals(theEvent.getPropertyName())) {
            myPiece = (TetrisPiece) theEvent.getNewValue();
            repaint();
        }
    }
}

