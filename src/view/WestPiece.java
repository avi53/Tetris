package view;

import model.Board;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
    private JLabel gameLines;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel botPanel;
    private int level = 1;
    private JLabel levelLabel;

    /**
     * Counter for the points.
     */
    private int score;

    /**
     * Score multiplier.
     */
    private int  scoreMultiplier;



    /**
     * West piece constructor. Initialize the west piece panel.
     */
    public WestPiece() {
        super();


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
        gamePoints = new JLabel("temp");

        topPanel.setPreferredSize(new Dimension(WEST_WIDTH + 60, WEST_HEIGHT + 60));
        Border border = BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.BLUE, 2), "Points", TitledBorder.CENTER, TitledBorder.TOP),
                BorderFactory.createEmptyBorder(5, 5, 5, 5));
        topPanel.setBorder(border);
        topPanel.add(gamePoints);
    }
    private void createCenter() {
        centerPanel = new JPanel();
        gameStatus = new JLabel("");
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
        gameLines = new JLabel("temp");

        botPanel.setPreferredSize(new Dimension(WEST_WIDTH + 60, WEST_HEIGHT + 60));
        Border border = BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder
                        (BorderFactory.createLineBorder(Color.BLUE, 2), "Lines", TitledBorder.CENTER, TitledBorder.TOP),
                BorderFactory.createEmptyBorder(5, 5, 5, 5));
        botPanel.setBorder(border);

        botPanel.add(gameLines);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (Board.PROPERTY_GAME_OVER.equals(evt.getPropertyName())) {
            gameStatus.setText("GAME OVER");
        }
        if (Board.PROPERTY_COMPLETE_ROWS_LIST.equals(evt.getPropertyName())) {
            gameLines.setText("LINES");
        }
        if (Board.PROPERTY_NEXT_PIECE.equals(evt.getPropertyName())) {
            level++;
            levelLabel.setText(Integer.toString(level));
        }
    }
}
