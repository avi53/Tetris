package view;

import controller.Sound;
import controller.TimeTicker;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import model.Board;


/**
 * Score user, user information, Green.
 * @author David Hoang
 * @author Avinash Bavisetty
 * @author Yonas Omega
 * @author Jose Rodriguez
 * @version Winter 2023
 */

public class WestPiece extends JPanel implements PropertyChangeListener {
    /** The current level of the game. */
    private static int level;
    /** Lines that were cleared for the current level. */
    private static int myLinesCleared;
    /** West piece width.*/
    private static final int WEST_WIDTH = 100;
    /** West piece height.*/
    private static final int WEST_HEIGHT = 100;
    /** West piece inside panel width.*/
    private static final int WEST_INSIDE_PANEL_WIDTH = 60;
    /** West piece inside panel height.*/
    private static final int WEST_INSIDE_PANEL_HEIGHT = 60;
    /** One lines clear point. */
    private static final int SCORE_MULTIPLIER_ONE = 40;
    /** Two lines clear point. */
    private static final int SCORE_MULTIPLIER_TWO = 100;
    /** Three lines clear point. */
    private static final int SCORE_MULTIPLIER_THREE = 300;
    /** Four lines clear point. */
    private static final int SCORE_MULTIPLIER_FOUR = 1200;
    /** Add four points to the score when a piece freezes. */
    private static final int SCORE_PER_FREEZE = 4;
    /** One line. */
    private static final int ONE_LINE = 1;
    /** Two line. */
    private static final int TWO_LINE = 2;
    /** Three line. */
    private static final int THREE_LINE = 3;
    /** Four line. */
    private static final int FOUR_LINE = 4;
    /** The Four lines needed to calculate score. */
    private static final int SCORE_ENTRY = 4;
    /** The music SE. */
    private static final int MUSIC_SE = 3;
    /** The game status display. */
    private JLabel myGameStatus;
    /** Display the game points. */
    private JLabel myGamePoints;
    /** The lines of the current game. */
    private int myLines;
    /** Display the lines of the current game. */
    private JLabel myGameLines;
    /** The top panel of the west area. */
    private JPanel myTopPanel;
    /** The center panel of the west area. */
    private JPanel myCenterPanel;
    /** The bottom panel of the west area. */
    private JPanel myBotPanel;
    /** Display the current level. */
    private JLabel myLevelLabel;
    /** Buffer next piece. */
    private int myPieceCounter;
    /** The current score of the game. */
    private int myScore;
    /** Lines that were cleared for the whole game. */
    private int myTotalLinesCleared;
    /** My timer. */
    private final TimeTicker myTime;
    /** The Status of the game. */
    private boolean myGameOverStatus;
    /** Variable to add sound to the panel. */
    private final Sound mySound = new Sound();

    /**
     * West piece constructor. Initialize the west piece panel.
     */
    public WestPiece(final TimeTicker theTime) {
        super();
        myTime = theTime;
        enableGameFunction();
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

        add(myTopPanel, BorderLayout.NORTH);
        add(myCenterPanel, BorderLayout.CENTER);
        add(myBotPanel, BorderLayout.SOUTH);
    }
    private void enableGameFunction() {
        myPieceCounter = 0;
        myGameStatus = new JLabel("");
        myGameOverStatus = false;
        myTotalLinesCleared = 0;
        myLinesCleared = 0;
        level = 0;
        myScore = 0;
    }

    private void createTop() {
        myTopPanel = new JPanel();
        myGamePoints = new JLabel(Integer.toString(myScore));

        myTopPanel.setPreferredSize(new Dimension(WEST_WIDTH + WEST_INSIDE_PANEL_WIDTH,
                WEST_HEIGHT + WEST_INSIDE_PANEL_HEIGHT));
        final Border border = BorderFactory.createCompoundBorder
                (BorderFactory.createTitledBorder
                                (BorderFactory.createLineBorder(Color.BLUE, 2),
                                        "Points", TitledBorder.CENTER, TitledBorder.TOP),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5));
        myTopPanel.setBorder(border);
        myTopPanel.add(myGamePoints);
    }
    private void createCenter() {
        myCenterPanel = new JPanel();

        myLevelLabel = new JLabel(Integer.toString(level));


        myCenterPanel.setPreferredSize(new Dimension(WEST_WIDTH, WEST_HEIGHT));
        final Border border = BorderFactory.createCompoundBorder
                (BorderFactory.createTitledBorder
                                (BorderFactory.createLineBorder(Color.BLUE, 2)
                                        , "Level", TitledBorder.CENTER, TitledBorder.TOP),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5));
        myCenterPanel.setBorder(border);

        myCenterPanel.add(myLevelLabel);
        myCenterPanel.add(myGameStatus);
    }

    private void createBot() {
        myBotPanel = new JPanel();
        myGameLines = new JLabel(Integer.toString(myLines));

        myBotPanel.setPreferredSize(new Dimension(WEST_WIDTH + WEST_INSIDE_PANEL_WIDTH,
                WEST_HEIGHT + WEST_INSIDE_PANEL_HEIGHT));
        final Border border = BorderFactory.createCompoundBorder
                (BorderFactory.createTitledBorder
                                (BorderFactory.createLineBorder(Color.BLUE, 2)
                                        , "Lines", TitledBorder.CENTER, TitledBorder.TOP),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5));
        myBotPanel.setBorder(border);

        myBotPanel.add(myGameLines);
    }
    /**
     * Calculates score when a line is cleared.
     */
    public int calculateScoreLineClear() {
        int scoreToReturn = 0;
        if (myLinesCleared == ONE_LINE) {
            scoreToReturn = SCORE_MULTIPLIER_ONE * level;
        } else if (myLinesCleared == TWO_LINE) {
            scoreToReturn = SCORE_MULTIPLIER_TWO * level;
        } else if (myLinesCleared == THREE_LINE) {
            scoreToReturn = SCORE_MULTIPLIER_THREE * level;
        } else if (myLinesCleared == FOUR_LINE) {
            scoreToReturn = SCORE_MULTIPLIER_FOUR * level;
        }
        return scoreToReturn;
    }
    public static int getLinesCleared() {
        return myLinesCleared;
    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvt) {
        if (Board.PROPERTY_GAME_OVER.equals(theEvt.getPropertyName())) {
            myGameOverStatus = (boolean) theEvt.getNewValue();
            if (myGameOverStatus) {
                myGameStatus.setText("Game over ");
                level = 0;
                myScore = 0;
                myPieceCounter = 0;
                myLines = 0;

            } else {
                myGameStatus.setText("Game on    ");
                level = 1;
                myLevelLabel.setText(Integer.toString(level));
                myGameLines.setText(Integer.toString(myLines));
            }
        }
        if (Board.PROPERTY_NEXT_PIECE.equals(theEvt.getPropertyName())) {
            myPieceCounter++;
            if (myPieceCounter > 2) {
                myScore = myScore + SCORE_PER_FREEZE;
            }
            myGamePoints.setText(Integer.toString(myScore));
            myLevelLabel.setText(Integer.toString(level));
        }
        if (Board.PROPERTY_COMPLETE_ROWS_LIST.equals(theEvt.getPropertyName())) {

            myLinesCleared++;
            System.out.println("Total lines cleared: " + myLinesCleared);
            myTotalLinesCleared += myLinesCleared;

            if (myLinesCleared < SCORE_ENTRY) {
                myScore += calculateScoreLineClear();
                myLinesCleared = 0;
            }
            if (myLinesCleared > SCORE_ENTRY) {
                level++;
                myTime.speedUpTimer();
                myLinesCleared = 0;
                playSE(MUSIC_SE);
            }
            myLevelLabel.setText(Integer.toString(level));
            myGameLines.setText(Integer.toString(myTotalLinesCleared));
        }
    }
    public void playSE(final int theIndex) {
        mySound.setFile(theIndex);
        mySound.play();
    }
}
