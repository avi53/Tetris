import view.GUIWINDOW;



/**
 * The driver class for this demonstration code.
 * @author David Hoang
 * @author Avinash Bavisetty
 * @author Yonas Omega
 * @author Jose Rodriguez
 * @version Winter 2023
 *
 */
public  final class Application {

    /**
     * Private empty constructor to avoid accidental instantiation.
     */
    private Application() {

    }
    /**
     * Creates a JFrame to demonstrate this panel.
     *
     * @param theArgs Command line arguments, ignored.
     */


    public static void main(final String[] theArgs) {
        final GUIWINDOW panel = new GUIWINDOW();
        panel.frame();


    }
}
