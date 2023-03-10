package view;

import model.Block;
import model.Board;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
    private int level;
    private JLabel levelLabel;

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
    private int myLinescleared;

    /**
     * Lines that were cleared for the whole game.
     */
    private int myTotalLinesCleared;
    /** The background color. */
    private LinkedList<Block[]> myFrozenBlocks;




    /**
     * West piece constructor. Initialize the west piece panel.
     */
    public WestPiece() {
        super();
        gameStatus = new JLabel("");
        myTotalLinesCleared=0;
        myLinescleared =0;
        level = 0;
        score = 0;
        myFrozenBlocks = new LinkedList<>();
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
    public int calculateScoreLineClear(){
        return 40* myTotalLinesCleared;

    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (!Board.PROPERTY_GAME_OVER.equals(evt.getPropertyName())) {
            gameStatus.setText("Game on");
            level =1;
        }
        if (Board.PROPERTY_GAME_OVER.equals(evt.getPropertyName())) {
            gameStatus.setText("GAME OVER");
            level = 0;
            score = 0;
        }
        if (Board.PROPERTY_NEXT_PIECE.equals(evt.getPropertyName())) {

                score = score + 4;

            gamePoints.setText(Integer.toString(score));
            levelLabel.setText(Integer.toString(level));
        }
        if (Board.PROPERTY_COMPLETE_ROWS_LIST.equals(evt.getPropertyName())) { //TODO add counter.
            myTotalLinesCleared++;
            if(myLinescleared <= 4) {
                myLinescleared++;
            }else if( myLinescleared >4) {
                level = level + 1;
                myLinescleared=1;
            }

        }
    }
}
