package view;


import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;
import model.Board;

public class EastPiece extends JPanel implements PropertyChangeListener {


    /** East piece width.*/
    private static final int EAST_WIDTH = 200;

    /** East piece height.*/
    private static final int EAST_HEIGHT = 500;

    /** East piece shape.*/
    private final Rectangle2D myShape;

    /**
     * East piece constructor. Initialize the east piece panel.
     */
    public EastPiece() {
        super();
        myShape = new Rectangle2D.Double(90,100,25,25);
        createEastPiece();
    }

    /**
     * Create the east piece width, height, and set the color.
     */
    private void createEastPiece() {
        setBackground(Color.BLUE);
        setPreferredSize(new Dimension(EAST_WIDTH, EAST_HEIGHT));
    }

    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setPaint(Color.BLACK);
        g2d.fill(myShape);
    }


    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if (Board.PROPERTY_NEXT_PIECE.equals(theEvent.getPropertyName())) {
            repaint();
        }

    }
}

