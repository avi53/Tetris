package controller;

import model.Board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

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
     * Counter field. */
    private int myCounter;
    /**
     * Tetris board.
     */
    private final Board myBoard;
    /**
     * The delay change everytime the game levels up.
     */
    private final int mySpeedVal = 50;

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
//        final ArrayList<Integer> delayTimes = new ArrayList<>();
//        for (int i = 1000; i >= 50; i = i - 50) {
//            delayTimes.add(i);
//        }
//
//        final int level = WestPiece.getLevel();
//        int delayTime = myDelay;
//        if (level > delayTimes.size()) {
//            delayTime = delayTimes.get(delayTimes.size() - 1);
//        } else {
//            delayTime = delayTimes.get(level - 1);
//        }
//        myTimer.setDelay(delayTime); // reset the Timer with the new delay time

        myCounter++;
        myBoard.down();
        System.out.println("tick");
        System.out.println(myDelay);
    }

    /**
     * Method that speeds up the timer by decrementing the delay by 50ms
     * every time it's called.
     */
    public void speedUpTimer() {
        if (myDelay > mySpeedVal) {
            myDelay -= mySpeedVal;
        }
        myTimer.setDelay(myDelay);
    }

    /**
     * Method that provides the counter of the timer running.
     *
     * @return returns an int value of the time counter.
     */
    public int timeCounter() {
        return myCounter;
    }
}