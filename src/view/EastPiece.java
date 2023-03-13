package view;


import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.font.TextAttribute;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

    /** The inner panel of east located at the bottom's width. */
    private static final int SECOND_PANEL_WIDTH = 50;

    /** The inner panel of east located at the bottom's height. */
    private static final int SECOND_PANEL_HEIGHT = 50;

    /** The inner panel of east located at the middle's width. */
    private static final int INNER_PANEL_WIDTH = 180;

    /** The inner panel of east located at the middle's height. */
    private static final int INNER_PANEL_HEIGHT = 80;

    /** The piece's width display. */
    private static final int PIECE_IMAGE_WIDTH = 600;

    /** The piece's height display. */
    private static final int PIECE_IMAGE_HEIGHT = 600;

    /** The piece's stroke display. */
    private static final int PIECE_STROKE_1 = 10;
    /** The piece's stroke display. */
    private static final int PIECE_STROKE_2 = 3;

    /** The number constant of times needed for next level. */
    private static final int NEXT_LEVEL_OFFSET = 5;

    /** The number of times needed for next level. */
    private static final int NEXT_LEVEL_COUNT_SETTER = 5;

    /** The text of the panels size. */
    private static final int TEXT_SIZE = 16;
    /** The text of the panels size. */
    private static final float TEXT_FLOAT = 12f;

    /** String to display after the number of lines. */
    private static final String MESSAGE_LINES = " Lines";

    /** String to display text style. */
    private static final String TEXT_STYLE = "Arial";

    /** The next tetris piece.*/
    private TetrisPiece myPiece;

    /** The west panel which hold next level counter. */
    private JPanel mySecondPanel;

    /** Label that displays next level counter. */
    private JLabel myNextLevelCountLabel;

    /** The next level in # of lines. */
    private int myNextLevelCount;

    /** Background image.*/
    private Image myBackground;

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

        try {
            myBackground = ImageIO.read(new File("src/image/image3.PNG"));
        } catch (final IOException ignored) {

        }
        myNextLevelCount = NEXT_LEVEL_OFFSET;

        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(EAST_WIDTH, EAST_HEIGHT));
        final InsidePanel insidePanel = new InsidePanel();
        secondPanel();
        add(insidePanel, BorderLayout.NORTH);
        add(mySecondPanel, BorderLayout.CENTER);
    }

    /**
     * The panel inside the east that holds next level counter.
     */
    private void secondPanel() {

        mySecondPanel = new JPanel();
        myNextLevelCountLabel = new JLabel(myNextLevelCount + MESSAGE_LINES);
        myNextLevelCountLabel.setForeground(Color.WHITE);
        mySecondPanel.setBackground(new Color(0, 0, 0, 0));
        mySecondPanel.setPreferredSize(new Dimension(SECOND_PANEL_WIDTH, SECOND_PANEL_HEIGHT));

        final JPanel innerPanel = new JPanel();
        innerPanel.setBackground(new Color(0, 0, 0, 0));
        innerPanel.setPreferredSize(new Dimension(INNER_PANEL_WIDTH, INNER_PANEL_HEIGHT));
        Font font = new Font(TEXT_STYLE, Font.BOLD, TEXT_SIZE);
        font = font.deriveFont(Font.BOLD, TEXT_FLOAT).deriveFont(Collections.singletonMap
                (TextAttribute.FOREGROUND, Color.WHITE));

        final Border border = BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.BLUE, 2),
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
    @Override
    protected final void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        theGraphics.drawImage(myBackground, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public final void propertyChange(final PropertyChangeEvent theEvt) {
        if (Board.PROPERTY_NEXT_PIECE.equals(theEvt.getPropertyName())) {
            myPiece = (TetrisPiece) theEvt.getNewValue();
            myNextLevelCountLabel.setText(myNextLevelCount + MESSAGE_LINES);
            repaint();
        }
        final int linesCleared;
        if (Board.PROPERTY_COMPLETE_ROWS_LIST.equals(theEvt.getPropertyName())) {
            linesCleared = WestPiece.getLinesCleared() + 1;

            if (linesCleared < NEXT_LEVEL_OFFSET) {
                myNextLevelCount = NEXT_LEVEL_OFFSET - linesCleared;


                myNextLevelCountLabel.setText(myNextLevelCount + MESSAGE_LINES);
                repaint();
            }
        }
        if (Board.PROPERTY_GAME_OVER.equals(theEvt.getPropertyName())) {
            final boolean gameOverStatus = (boolean) theEvt.getNewValue();
            if (gameOverStatus) {
                myNextLevelCount = NEXT_LEVEL_COUNT_SETTER;


                repaint();
            }
        }
    }

    /**
     * The next piece panel that holds the next piece paint.
     */
    public class InsidePanel extends JPanel {
        /** Inside panel width.*/
        private static final int WIDTH = 150;
        /** Inside panel height.*/
        private static final int HEIGHT = 150;
        /**
         * The panel inside the east top panel.
         */
        public InsidePanel() {
            setBackground(Color.LIGHT_GRAY);
            setPreferredSize(new Dimension(WIDTH, HEIGHT));
            Font font = new Font(TEXT_STYLE, Font.BOLD, TEXT_SIZE);
            font = font.deriveFont(Font.BOLD, TEXT_FLOAT).deriveFont(Collections.singletonMap
                    (TextAttribute.FOREGROUND, Color.WHITE));

            final Border border = BorderFactory.createCompoundBorder(
                    BorderFactory.createTitledBorder(
                            BorderFactory.createLineBorder(Color.BLUE, 2),
                            "Next Piece",
                            TitledBorder.CENTER,
                            TitledBorder.TOP,
                            font),
                    BorderFactory.createEmptyBorder(5, 5, 5, 5)
            );
            setBorder(border);
        }

        @Override
        public void paintComponent(final Graphics theGraphics) {
            super.paintComponent(theGraphics);
            final Graphics2D g2d = (Graphics2D) theGraphics;

            g2d.drawImage(myBackground, 0, 0,  PIECE_IMAGE_WIDTH, PIECE_IMAGE_HEIGHT , null);

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
                final int y = -(getHeight() - pieceHeight) / 2;
                for (Point block : blocks) {
                    final int blockX = x + (block.x() - minX) * 30;
                    final int blockY = -(y + (block.y() - minY) * 30) + 30;
                    final Shape rectangle = new Rectangle2D.Double(blockX, blockY, 30, 30);
                    g2d.setPaint(CenterPanel.getBlockColor(myPiece.getBlock()));
                    g2d.setStroke(new BasicStroke(PIECE_STROKE_1));
                    g2d.fill(rectangle);
                    g2d.setPaint(Color.BLACK);
                    g2d.setStroke(new BasicStroke(PIECE_STROKE_2));
                    g2d.draw(rectangle);
                }
            }
        }
    }
}

