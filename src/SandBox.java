import model.Board;

public final class SandBox {

    private SandBox() {

    }

    public static void main(final String[] theArgs) {
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
