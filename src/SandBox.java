import model.Board;
import view.GUIWINDOW;


/**
 * This program is meant to provide some experience for members with Git and GitHub.
 *
 * @author David Hoang
 * @author Avinash Bavisetty
 * @author Yonas Omega
 * @author Jose Rodriguez
 * @version Winter 2023
 */
public final class SandBox {

    private SandBox() {

    }

    public static void main(final String[] theArgs) {
        final GUIWINDOW guiwindow = new GUIWINDOW();
        final Board b = new Board();
        b.newGame();
        System.out.print(b);

        b.step();
        System.out.println(b);
        b.rotateCW();
        System.out.println(b);
        b.rotateCW();
        System.out.println(b);
        b.rotateCW();
        System.out.println(b);
        b.rotateCW();
        System.out.println(b);
        b.drop();
        System.out.println(b);
    }

}
