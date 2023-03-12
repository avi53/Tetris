package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.Timer;
import view.WestPiece;

/**
 * TimerTicker class that represents the timer for the tetris game.
 *
 * @author David Hoang
 * @author Avinash Bavisetty
 * @author Yonas Omega
 * @author Jose Rodriguez
 * @version Winter 2023
 */
public class TimeTicker extends JLabel implements ActionListener {
    /** Timer field. */
    private final Timer myTimer;
    /**
     * Counter field. */
    private int myCounter;
    /**
     * Delay Time.
     */
    private int myDelay = 1000;
    /**
     * Change in timer.
     */
    private final int mySpeedVal = 50;
    /**
     * TimeTicker constructor that sets how often the timer "tick".
     */
    public TimeTicker() {
        super();
        /**
         * Timer delay.
         */
        myTimer = new Timer(myDelay, this); // 1000 ms = 1 second
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
        System.out.println("tick");
    }
    public void speedUpTimer() {
        myDelay -= mySpeedVal;
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