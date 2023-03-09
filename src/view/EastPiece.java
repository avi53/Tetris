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
    private TetrisPiece myPiece;

    /**
     * East piece constructor. Initialize the east piece panel.
     */
    public EastPiece() {
        super();
        myPiece = TetrisPiece.getRandomPiece();//FIXME instantiate myPiece correctly in constructor.
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
            myPiece = (TetrisPiece) theEvent.getNewValue();
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        final Point[] blocks = myPiece.getPoints();
        for (Point block : blocks) {
            //TODO edit to fit panel properly
            int x = block.x() * 30;
            int y = block.y() * 30;
            GradientPaint gradient = new GradientPaint(x, y, Color.RED, x, y + 15, new Color(200,200,200));
            g2d.setPaint(gradient);

            final Shape rectangle = new Rectangle2D.Double(x+50,y-10,30,30);
            g2d.fill(rectangle);
            g2d.setStroke(new BasicStroke(1));
            g2d.setPaint(Color.WHITE);
            g2d.draw(rectangle);
        }
    }
}

