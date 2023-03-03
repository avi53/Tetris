package view;

import model.Board;
import model.PropertyChangeEnabledBoardControls;
import model.KeyHandler;
import model.TimeTicker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * This program is meant to create and show the GUI Frame.
 * @author David Hoang
 * @author Avinash Bavisetty
 * @author Yonas Omega
 * @author Jose Rodriguez
 * @version Winter 2023
 */
public class GUIWINDOW extends JPanel implements PropertyChangeListener {
    /** frame width.*/
    private static final int FRAME_WIDTH = 500;
    /** frame height.*/
    private static final int FRAME_HEIGTH = 600;
    /** center width.*/
    private static final int CENTER_WIDTH = 300;
    /** center height.*/
    private static final int CENTER_HEIGHT = 500;
    /** frame of the gui window.*/
    private static final JFrame WINDOW = new JFrame(" Our Frame");
    KeyHandler keyH = new KeyHandler(this);
    TimeTicker time = new TimeTicker();
    /**
     * Board object to be referenced.
     */
    private Board tetrisBoard = new Board();

    /**
     * Creates LayOutManager on JPanel.
     */
    public GUIWINDOW() {
        super();
        setLayout(new BorderLayout());

        final WestPiece westpiece = new WestPiece();
        final SouthPiece southpiece = new SouthPiece();
        final EastPiece eastpiece = new EastPiece();
        final CenterPanel centerpiece = new CenterPanel();
        tetrisBoard.addPropertyChangeListener(PropertyChangeEnabledBoardControls.PROPERTY_STEP,centerpiece);
        add(centerpiece, BorderLayout.CENTER);
        add(westpiece, BorderLayout.WEST);
        add(southpiece, BorderLayout.SOUTH);
        add(eastpiece, BorderLayout.EAST);
        this.addKeyListener(keyH);
        this.setFocusable(true);

        WINDOW.getContentPane().add(time);
        WINDOW.pack();
        WINDOW.setVisible(true);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public void frame() {
        WINDOW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WINDOW.setContentPane(this);
        WINDOW.setJMenuBar(this.createMenu());
        WINDOW.setSize(FRAME_WIDTH, FRAME_HEIGTH);
        WINDOW.setVisible(true);

        WINDOW.pack();
        WINDOW.setResizable(true);
    }

    /**
     * Build the menu bar for this GUI. This method will need
     * to be called where access to a JFrame occurs. You attach
     * a MenuBar to a Frame, not a Panel.
     *
     * @return the menu bar for this GUI
     */
    private JMenuBar createMenu() {
        final JMenuBar menuBar = new JMenuBar();

        menuBar.add(buildFileMenu());
        return menuBar;
    }
    /**
     * Builds a menu with some options.
     *
     * @return a "file" menu with some menu items
     */
    private JMenu buildFileMenu() {
        final JMenu menu = new JMenu("File");
        menu.add(buildSubMenu());
        menu.addSeparator();

        return menu;
    }

    /**
     * Builds a menu to demonstrate sub menus.
     * @return a menu with several simple menu items.
     */
    private JMenu buildSubMenu() {
        final JMenu subMenu = new JMenu("User Options");

        subMenu.add(buildSimpleMenuItem("New Game"));
        subMenu.add(buildSimpleMenuItem("Exit"));
        subMenu.add(buildSimpleMenuItem("About"));

        return subMenu;
    }
    /**
     * Builds a simple menu item.
     *
     * @param theText the text to appear on the menu item
     * @return a simple menu item
     */
    private JMenuItem buildSimpleMenuItem(final String theText) {
        final JMenuItem item = new JMenuItem(theText);
        item.addActionListener(theEvent ->
                JOptionPane.showMessageDialog(this, theText));
        return item;
    }

    /**
 * Creates a JFrame to demonstrate BorderLayout.
 * It is OK, even typical to include a main method
 * in the same class file as a GUI for testing purposes.

 *
 * @param theArgs Command line arguments, ignored.
 */
    public static void main(final String[] theArgs) {
        final GUIWINDOW panel = new GUIWINDOW();
        panel.frame();


    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        String property_name = evt.getPropertyName();

        if (property_name.equals(Board.PROPERTY_DROP) ||
                property_name.equals(Board.PROPERTY_GAME_OVER) ||
                property_name.equals(Board.PROPERTY_SEQUENCE_INDEX)) {

            repaint();
        }

    }
}
