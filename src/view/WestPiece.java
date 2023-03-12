package view;

import model.*;
import view.GUIWINDOW;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Time;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


/**
 * Score user, user information, Green.
 * @author David Hoang
 * @author Avinash Bavisetty
 * @author Yonas Omega
 * @author Jose Rodriguez
 * @version Winter 2023
 */

public class WestPiece extends JPanel implements PropertyChangeListener {
    /** West piece width.*/
    private static final int WEST_WIDTH = 100;

    /** West piece height.*/
    private static final int WEST_HEIGHT = 100;

    private JLabel gameStatus;
    private JLabel gamePoints;

    private int myLines;
    private JLabel gameLines;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel botPanel;
    private static int level;
    private JLabel levelLabel;
    /** Buffer next piece. */
    private int pieceCounter;


    /**
     * Counter for the points.
     */
    private int score;

    /**
     * Score multiplier.
     */
    private int  myScoreMultiplier;
    /**
     * Lines that were cleared for the current level.
     */
    private static int myLinescleared;

    /**
     * Lines that were cleared for the whole game.
     */
    private int myTotalLinesCleared;
    /** The background color. */
    private LinkedList<Block[]> myFrozenBlocks;
    /**
     * My timer.
     */
    private final TimeTicker myTime;
    /** The Status of the game. */
    private boolean gameOverStatus;
    /**
     * Variable to add sound to the panel.
     */
    private final Sound mySound = new Sound();




    /**
     * West piece constructor. Initialize the west piece panel.
     */
    public WestPiece(final TimeTicker theTime) {
        super();
        myTime = theTime;
        pieceCounter = 0;
        gameStatus = new JLabel("");
        myTotalLinesCleared=0;
        myLinescleared =0;
        level = 0;
        score = 0;
        myFrozenBlocks = new LinkedList<>();

        gameOverStatus = false;
        createTop();
        createCenter();
        createBot();
        createWestPiece();

    }



    /**
     * Create the west piece width, height, and set the color.
     */
    private void createWestPiece() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(WEST_WIDTH, WEST_HEIGHT));
        setBackground(Color.GREEN);




        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(botPanel, BorderLayout.SOUTH);
    }

    private void createTop() {
        topPanel = new JPanel();
        gamePoints = new JLabel(Integer.toString(score));

        topPanel.setPreferredSize(new Dimension(WEST_WIDTH + 60, WEST_HEIGHT + 60));
        Border border = BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.BLUE, 2), "Points", TitledBorder.CENTER, TitledBorder.TOP),
                BorderFactory.createEmptyBorder(5, 5, 5, 5));
        topPanel.setBorder(border);
        topPanel.add(gamePoints);
    }
    private void createCenter() {
        centerPanel = new JPanel();

        levelLabel = new JLabel(Integer.toString(level));


        centerPanel.setPreferredSize(new Dimension(WEST_WIDTH, WEST_HEIGHT));
        Border border = BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder
                        (BorderFactory.createLineBorder(Color.BLUE, 2), "Level", TitledBorder.CENTER, TitledBorder.TOP),
                BorderFactory.createEmptyBorder(5, 5, 5, 5));
        centerPanel.setBorder(border);

        centerPanel.add(levelLabel);
        centerPanel.add(gameStatus);
    }

    private void createBot() {
        botPanel = new JPanel();
        gameLines = new JLabel(Integer.toString(myLines));

        botPanel.setPreferredSize(new Dimension(WEST_WIDTH + 60, WEST_HEIGHT + 60));
        Border border = BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder
                        (BorderFactory.createLineBorder(Color.BLUE, 2), "Lines", TitledBorder.CENTER, TitledBorder.TOP),
                BorderFactory.createEmptyBorder(5, 5, 5, 5));
        botPanel.setBorder(border);

        botPanel.add(gameLines);
    }
    /**
     * Calculates score when a line is cleared.
     */
    public int calculateScoreLineClear() {
        int scoreToReturn = 0;
        if (myLinescleared == 1) {
            scoreToReturn = 40 * level;
        } else if (myLinescleared == 2) {
            scoreToReturn = 100 * level;
        } else if (myLinescleared == 3) {
            scoreToReturn = 300 * level;
        } else if (myLinescleared == 4) {
            scoreToReturn = 400 * level;
        }
        return scoreToReturn;
    }
    public static int getLinesCleared() {
        return myLinescleared;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (Board.PROPERTY_GAME_OVER.equals(evt.getPropertyName())) {
            gameOverStatus = (boolean) evt.getNewValue();
            if (gameOverStatus) {
                gameStatus.setText("Game over ");
                level = 0;
                score = 0;
                pieceCounter = 0;
            } else {
                gameStatus.setText("Game on    ");
                level = 1;
                levelLabel.setText(Integer.toString(level));
            }
        }

        if (Board.PROPERTY_NEXT_PIECE.equals(evt.getPropertyName())) {
            pieceCounter++;
            if (pieceCounter > 2) {
                score = score + 4;
            }

            gamePoints.setText(Integer.toString(score));
            levelLabel.setText(Integer.toString(level));
        }
        if (Board.PROPERTY_COMPLETE_ROWS_LIST.equals(evt.getPropertyName())) {

            myLinescleared++;
            myTotalLinesCleared += myLinescleared;

            if (myLinescleared < 4) {
                score += calculateScoreLineClear();

            }
            if (myLinescleared > 4) {
                level++;
                myTime.speedUpTimer();
                myLinescleared = 0;
                playSE(3);
            }
            levelLabel.setText(Integer.toString(level));
            gameLines.setText(Integer.toString(myTotalLinesCleared));
        }
    }
    public void playSE(final int theIndex) {
        mySound.setFile(theIndex);
        mySound.play();
    }
//    public static int getLevel() {
//        return level;
//    }
}
