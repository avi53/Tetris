package view;


import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;
import model.Board;
import model.MovableTetrisPiece;
import model.Point;
import model.TetrisPiece;

public class EastPiece extends JPanel implements PropertyChangeListener {


    /** East piece width.*/
    private static final int EAST_WIDTH = 200;

    /** East piece height.*/
    private static final int EAST_HEIGHT = 500;
    private Point[] myPiece;



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
        setPreferredSize(new Dimension(EAST_WIDTH, EAST_HEIGHT));

    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if (Board.PROPERTY_NEXT_PIECE.equals(theEvent.getPropertyName())) {
            myPiece = (Point[]) theEvent.getNewValue();
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.MAGENTA);
        g2d.setStroke(new BasicStroke(10));

        //TODO myPiece should be the next piece not "S".
        myPiece = TetrisPiece.getRandomPiece().getPoints();
        for (Point block : myPiece) {
            //TODO edit to fit panel properly
            int x = block.x() * 30;
            int y = block.y() * 30;
            final Shape rectangle = new Rectangle2D.Double(x+50,y-10,30,30);
            g2d.draw(rectangle);
        }
    }
}

