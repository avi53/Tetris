package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUIWINDOW extends JPanel {
    /** frame width.*/
    private static final int FRAME_WIDTH = 500;
    /** frame height.*/
    private static final int FRAME_HEIGTH = 600;

    /** center width.*/
    private static final int CENTER_WIDTH = 300;
    /** center height.*/
    private static final int CENTER_HEIGHT = 500;

    /** east width.*/
    private static final int EAST_WIDTH = 200;
    /** east height.*/
    private static final int EAST_HEIGHT = 500;

    /** blue square width.*/
    private static final int BLUE_WIDTH = 200;
    /** blue square height.*/
    private static final int BLUE_HEIGHT = 200;

    /** frame of the gui window.*/
    //private final JFrame myFrame = new JFrame(" Our Frame");

    /**
     * Creates LayOutManager on JPanel.
     */
    public GUIWINDOW() {
        setLayout(new BorderLayout());
        //frame();

        final westpiece westpiece = new westpiece();
        final southpiece southpiece = new southpiece();

        centerPanel();
        eastpanel();
        add(westpiece, BorderLayout.WEST);
        add(southpiece, BorderLayout.SOUTH);
    }

    /**
    private void frame() {
        final GUIWINDOW mainPanel = new GUIWINDOW();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setContentPane(mainPanel);
        myFrame.setSize(FRAME_WIDTH, FRAME_HEIGTH);
        myFrame.setVisible(true);
        myFrame.pack();
        myFrame.setResizable(true);
    }.
     */

    private void centerPanel() {

        final JPanel centerPanel = new JPanel();

        final JPanel colorPanel = new JPanel();

        colorPanel.setBackground(Color.RED);

        colorPanel.setPreferredSize(new Dimension(CENTER_WIDTH, CENTER_HEIGHT));

        centerPanel.add(colorPanel);

        add(centerPanel, BorderLayout.CENTER);
    }

    private void eastpanel() {

        final JPanel eastPanel = new JPanel();

        final JPanel colorPanel2 = new JPanel();

        colorPanel2.setBackground(Color.BLACK);

        colorPanel2.setPreferredSize(new Dimension(EAST_WIDTH, EAST_HEIGHT));

        eastPanel.add(colorPanel2);

        final JPanel bluePanel = new JPanel();

        bluePanel.setBackground(Color.BLUE);

        bluePanel.setPreferredSize(new Dimension(BLUE_WIDTH, BLUE_HEIGHT));

        colorPanel2.add(bluePanel);

        add(eastPanel, BorderLayout.EAST);

    }
/**
 * Creates a JFrame to demonstrate BorderLayout.
 * It is OK, even typical to include a main method
 * in the same class file as a GUI for testing purposes.

 *
 * @param theArgs Command line arguments, ignored.
 */
    public static void main(final String[] theArgs) {
        final GUIWINDOW mainPanel = new GUIWINDOW();
        final JFrame frame = new JFrame(" Our Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGTH);
        frame.setVisible(true);
        frame.pack();
        frame.setResizable(true);
    }
}
