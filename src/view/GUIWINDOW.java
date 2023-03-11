package view;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Board;
import model.Sound;
import model.TimeTicker;



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
    /**
     * Time object.
     */
    private TimeTicker  myTime = new TimeTicker();
    /**
     * Board object to be referenced.
     */
    private Board myTetrisBoard  = new Board();

    /**
     * The variable to add sound to the board.
     */
    private Sound mySound = new Sound();

    /**
     * game over status to display.
     */
    private boolean myGameOverDisplay = true;

    /**
     * Creates LayOutManager on JPanel.
     */
    public GUIWINDOW()  {
        super();
        setLayout(new BorderLayout());
        setUpComponents();

        addKeyListener(new ControlKeyListener());
        setFocusable(true);
        requestFocus();

        playMusic(0);
    }

    /**
     * Helper method to set up components.
     */
    private void setUpComponents() {
        final WestPiece westpiece = new WestPiece();
        final SouthPiece southpiece = new SouthPiece();
        final EastPiece eastpiece = new EastPiece();
        final CenterPanel centerpiece = new CenterPanel();
        myTetrisBoard.addPropertyChangeListener(this);
        myTetrisBoard.addPropertyChangeListener(centerpiece);
        myTetrisBoard.addPropertyChangeListener(eastpiece);
        myTetrisBoard.addPropertyChangeListener(westpiece);
        add(centerpiece, BorderLayout.CENTER);
        add(westpiece, BorderLayout.WEST);
        add(southpiece, BorderLayout.SOUTH);
        add(eastpiece, BorderLayout.EAST);
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

    @Override
    public void propertyChange(final PropertyChangeEvent theEvt) {
        if (Board.PROPERTY_GAME_OVER.equals(theEvt.getPropertyName())) {
            myGameOverDisplay = (boolean) theEvt.getNewValue();
            if (myGameOverDisplay)  {
                myTime.stopTimer();
                System.out.println("Game is over");

            } else if (!myGameOverDisplay) {
                myTime.restartTimer();
            }
        }
    }
    /**
     * Getter method to return game over status.
     * @return the gameOver status to display.
     */
    public boolean getGameOverToDisplay() {
        return myGameOverDisplay;
    }
    public void playMusic(final int theIndex) {
        mySound.setFile(theIndex);
        mySound.play();
        mySound.loop();
    }
    public void stopMusic() {
        mySound.stop();
    }
    public void playSE(final int theIndex) {
        mySound.setFile(theIndex);
        mySound.play();
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
        menu.add(buildUserOptions());
        menu.addSeparator();
        return menu;
    }

    /**
     * Builds the menu Items and adds actionlisteners.
     * Also adds to the sub menu of user options and returns it.
     */
    private JMenu buildUserOptions() {
        final JMenuItem newGame = new JMenuItem("New game");
        final JMenuItem endGame = new JMenuItem("End Game");
        final JMenuItem exit = new JMenuItem("Exit");
        final JMenuItem about = new JMenuItem("About");
        final JMenuItem scoreAlgorithim = new JMenuItem("Score Algorithim");

        /**
         * When the New Game option is pressed, start a new game.'
         * User's current game must end to start new game.
         */
        newGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theE) {
                if (myGameOverDisplay) {
                    JOptionPane.showMessageDialog(newGame, "New Game");
                    myTetrisBoard.newGame();
                    myGameOverDisplay = false;
                    if (myTime.checkTimer()) {
                        myTime.restartTimer();
                    } else {
                        myTime.startTimer();
                    }
                } else if (!myGameOverDisplay) {
                    JOptionPane.showMessageDialog(newGame, "Current game has not ended yet!");
                }
            }
        });
        /**
         * The current game is ended and paused.
         */
        endGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theE) {
                if (!myGameOverDisplay) {
                    JOptionPane.showMessageDialog(endGame, "Game Ended");
                    myGameOverDisplay = true;
                    myTime.stopTimer();
                } else if (myGameOverDisplay) {
                    JOptionPane.showMessageDialog(endGame, "Game Already Ended!");
                }
            }
        });
        /**
         * Closes the window when the exit item is clicked.
         */
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theE) {
                JOptionPane.showMessageDialog(exit, "Exit!");
                WINDOW.dispatchEvent(new WindowEvent(WINDOW, WindowEvent.WINDOW_CLOSING));
            }
        });
        /**
         * Adds an about screen.
         */
        about.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theE) {
                JOptionPane.showMessageDialog(about, "This is group 6's Tetris project");

            }
        });
        /**
         * Communicates where the scoring algorithim is.
         */
        scoreAlgorithim.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theE) {
                JOptionPane.showMessageDialog(scoreAlgorithim,
                        "Add 4 points to score when a piece freezes in place."
                                + "\nAlso add points to the score when lines are "
                                + "cleared as shown"
                                + " below:"
                                + "\n                1 line    2 lines   3 lines   4 lines "
                                + "cleared "
                                + "\nLevel 1:  40         100         300        1200 "
                                + "\nLevel 2:  80         200         600        2400 "
                                + "\nLevel 3:  120       300         900        3600 "
                                + "\nLevel n:  40*(n)  100*(n)  300*(n)  1200*(n)  ");

            }
        });
        final JMenu subMenu = new JMenu("User Options");
        subMenu.add(newGame);
        subMenu.add(endGame);
        subMenu.add(exit);
        subMenu.add(about);
        subMenu.add(scoreAlgorithim);
        return subMenu;
    }

    /**
     * ControlKeyListener is responsible to read key input from the
     * user and move the tetris piece according to the key pressed.
     */
    class ControlKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(final KeyEvent theEvent) {
            if (myTime.checkTimer() && !myGameOverDisplay) {
                if (theEvent.getKeyCode() == KeyEvent.VK_W) {
                    System.out.println("up");
                    myTetrisBoard.rotateCW();
                } else if (theEvent.getKeyCode() == KeyEvent.VK_S) {
                    System.out.println("down");
                    myTetrisBoard.down();
                } else if (theEvent.getKeyCode() == KeyEvent.VK_A) {
                    System.out.println("left");
                    myTetrisBoard.left();
                } else if (theEvent.getKeyCode() == KeyEvent.VK_D) {
                    System.out.println("right");
                    myTetrisBoard.right();
                } else if (theEvent.getKeyCode() == KeyEvent.VK_SPACE) {
                    System.out.println("space");
                    myTetrisBoard.drop();
                }
            }
            if (theEvent.getKeyCode() == KeyEvent.VK_P && !myGameOverDisplay) {
                if (myTime.checkTimer()) {
                    myTime.stopTimer();
                    System.out.println("pause");
                } else if (!myTime.checkTimer()) {
                    myTime.startTimer();
                    System.out.println("start");
                }
            }
        }
    }





}

