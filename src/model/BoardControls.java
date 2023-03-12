package model;



/**
 * Define the methods that a Tetris Object can have.
 *
 * @author David Hoang
 * @author Avinash Bavisetty
 * @author Yonas Omega
 * @author Jose Rodriguez
 * @version Winter 2023
 */
public interface BoardControls {
    /**
     * Get the width of the board.
     *
     * @return Width of the board.
     */
    int getWidth();


    /**
     * Get the height of the board.
     *
     * @return Height of the board.
     */
    int getHeight();


    /**
     * Resets the board for a new game.
     * This method must be called before the first game
     * and before each new game.
     */
    void newGame();

    /**
     * Advances the board by one 'step'.
     * This could include
     * - moving the current piece down 1 line
     * - freezing the current piece if appropriate
     * - clearing full lines as needed
     */
    void step();

    /**
     * Try to move the movable piece down.
     * Freeze the Piece in position if down tries to move into an illegal state.
     * Clear full lines.
     */
    void down();

    /**
     * Try to move the movable piece left.
     */
    void left();
    /**
     * Try to move the movable piece right.
     */
    void right();

    /**
     * Try to rotate the movable piece in the clockwise direction.
     */
    void rotateCW();
    /**
     * Drop the piece until piece is set.
     */
    void drop();
}
