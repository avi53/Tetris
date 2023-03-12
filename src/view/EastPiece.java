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
import model.Point;
import model.TetrisPiece;

public class EastPiece extends JPanel implements PropertyChangeListener {


    /** East piece width.*/
    private static final int EAST_WIDTH = 200;

    /** East piece height.*/
    private static final int EAST_HEIGHT = 500;

    /** The next tetris piece.*/
    private TetrisPiece myPiece;

    /** The west panel which hold next level counter. */
    private JPanel mySecondPanel;

    /** Label that displays next level counter. */
    private JLabel myNextLevelCountLabel;

    /** The next level in # of lines. */
    private int myNextLevelCount = 4;

    /** The number of lines cleared. */
    private int myLinescleared = 0;


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
        setBackground(Color.BLUE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(EAST_WIDTH, EAST_HEIGHT));
        final InsidePanel insidePanel = new InsidePanel();
        secondPanel();
        add(insidePanel, BorderLayout.NORTH);
        add(mySecondPanel, BorderLayout.CENTER);
    }

    private void secondPanel() {
        /** The panel which holds the next level counter panel*/
        mySecondPanel = new JPanel();
        myNextLevelCountLabel = new JLabel(Integer.toString(myNextLevelCount) + " Lines");
        myNextLevelCountLabel.setForeground(Color.WHITE);
        mySecondPanel.setBackground(Color.BLUE);
        mySecondPanel.setPreferredSize(new Dimension(50, 50));
        /** The panel which holds the next level counter*/
        JPanel innerPanel = new JPanel();
        innerPanel.setBackground(Color.BLUE);
        innerPanel.setPreferredSize(new Dimension(180,80));
        Font font = new Font("Arial", Font.BOLD, 16);
        font = font.deriveFont(Font.BOLD, 12f).deriveFont(Collections.singletonMap
                (TextAttribute.FOREGROUND, Color.WHITE));

        Border border = BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.WHITE, 2),
                        "Next level in:",
                        TitledBorder.CENTER,
                        TitledBorder.TOP,
                        font),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        );
        innerPanel.setBorder(border);

        innerPanel.add(myNextLevelCountLabel);
        mySecondPanel.add(innerPanel);
    }

    /**
     * The next piece panel that holds the next piece paint.
     */
    public class InsidePanel extends JPanel {
        /** Inside panel width.*/
        private static final int WIDTH = 150;
        /** Inside panel height.*/
        private static final int HEIGHT = 150;

        public InsidePanel() {
            setBackground(Color.LIGHT_GRAY);
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
                    g2d.setPaint(CenterPanel.getBlockColor(myPiece.getBlock()));
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
    public void propertyChange(final PropertyChangeEvent evt) {
        if (Board.PROPERTY_NEXT_PIECE.equals(evt.getPropertyName())) {
            myPiece = (TetrisPiece) evt.getNewValue();
            repaint();
        }
        if (Board.PROPERTY_COMPLETE_ROWS_LIST.equals(evt.getPropertyName())) {
            myLinescleared = WestPiece.getLinesCleared() + 1;

            if (myLinescleared <= 4) {


                myNextLevelCount = 4 - myLinescleared;
                myNextLevelCountLabel.setText(Integer.toString(myNextLevelCount) + " Lines");
                myLinescleared = 0;
            }
        }
    }
}

