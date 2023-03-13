package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;
import model.Board;
/**
 * TimerTicker class that represents the timer for the tetris game.
 * @author David Hoang
 * @author Avinash Bavisetty
 * @author Yonas Omega
 * @author Jose Rodriguez
 * @version Winter 2023
 */
public class TimeTicker extends JLabel implements ActionListener {

    /**
     * The delay change everytime the game levels up.
     */
    private static final int MY_SPEED_VAL = 50;

    /**
     * Initial time delay.
     */
    private static final int INITIAL_DELAY = 1000;

    /**
     * Delay Time.
     */
    private static int myDelay = INITIAL_DELAY;

    /** Timer field. */
    private final Timer myTimer;

    /**
     * Tetris board.
     */
    private final Board myBoard;

    /**
     * TimeTicker constructor that sets how often the timer "tick".
     */
    public TimeTicker(final Board theBoard) {
        super();
        myTimer = new Timer(myDelay, this); // 1000 ms = 1 second
        myBoard = theBoard;
    }

    /**
     * Starts the timer when called.
     */
    public void startTimer() {
        myTimer.start();
    }

    /**
     * Method that checks if the timer is running.
     *
     * @return A boolean value true if running, otherwise false.
     */
    public boolean checkTimer() {
        return myTimer.isRunning();
    }
    /**
     * Pause the timer when called.
     */
    public void stopTimer() {
        myTimer.stop();
    }
    /**
     * Restarts the timer.
     */
    public void restartTimer() {
        myTimer.restart();
    }

    /**
     * Is responsible for handeling the event that is triggered by
     * the Timer.
     *
     * @param theE the event to be processed
     */
    public void actionPerformed(final ActionEvent theE) {
        myBoard.down();
    }

    /**
     * Method that speeds up the timer by decrementing the delay by 50ms
     * every time it's called.
     */
    public void speedUpTimer() {
        if (myDelay > MY_SPEED_VAL) {
            myDelay -= MY_SPEED_VAL;
        }
        myTimer.setDelay(myDelay);
    }
}