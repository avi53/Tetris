package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

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
    private Timer myTimer;
    /**
     * Counter field. */
    private int myCounter;

    /**
     * TimeTicker constructor that sets how often the timer "tick".
     */
    public TimeTicker() {
        super();
        myTimer = new Timer(1000, this); // 1000 ms = 1 second
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
     * Is responsible for handeling the event that is triggered by
     * the Timer.
     *
     * @param theE the event to be processed
     */
    public void actionPerformed(final ActionEvent theE) {
        myCounter++;
        System.out.println("tick");
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