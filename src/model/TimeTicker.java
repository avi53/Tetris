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
        System.out.println("tick");
    }
}