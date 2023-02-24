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
    protected JFrame myFrame = new JFrame();

    public GUIWINDOW() {

        frame();

        final westpiece westpiece = new westpiece();
        final southpiece southpiece = new southpiece();

        centerpanel();
        eastpanel();
        myFrame.add(westpiece, BorderLayout.WEST);
        myFrame.add(southpiece, BorderLayout.SOUTH);
    }

    private void frame() {
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(FRAME_WIDTH, FRAME_HEIGTH);
        myFrame.setVisible(true);
        myFrame.setLayout(null);
        myFrame.setResizable(true);
        myFrame.setLayout(new BorderLayout());
        myFrame.setLayout(new BorderLayout());
    }

    private void centerpanel() {

        final JPanel centerPanel = new JPanel();

        final JPanel colorPanel = new JPanel();

        colorPanel.setBackground(Color.RED);

        colorPanel.setPreferredSize(new Dimension(CENTER_WIDTH, CENTER_HEIGHT));

        centerPanel.add(colorPanel);

        myFrame.add(centerPanel, BorderLayout.CENTER);
    }

    private void eastpanel() {

        final JPanel eastPanel = new JPanel();

        final JPanel colorPanel2 = new JPanel();

        colorPanel2.setBackground(Color.BLACK);

        colorPanel2.setPreferredSize(new Dimension(EAST_WIDTH, EAST_HEIGHT));

        eastPanel.add(colorPanel2);

        final JPanel bluepanel = new JPanel();

        bluepanel.setBackground(Color.BLUE);

        bluepanel.setPreferredSize(new Dimension(BLUE_WIDTH, BLUE_HEIGHT));

        colorPanel2.add(bluepanel);

        myFrame.add(eastPanel, BorderLayout.EAST);

    }
}
