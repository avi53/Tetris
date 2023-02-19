import model.Board;

/**
 * This program is meant to test and allow team members to gain  experience with
 * Git and GitHub.
 *
 * @author David Hoang.
 * @version Winter 2023
 */
public final class SandBox {


    private SandBox() {

    }

    public static void main(final String[] theArgs) {
        final Board b = new Board();
        b.newGame();
        System.out.println(b);

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
