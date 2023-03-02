package model;

import view.GUIWINDOW;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    protected boolean myLeftPressed;
    protected boolean myRightPressed;
    protected boolean myDownPressed;
    protected GUIWINDOW myGui;

    public KeyHandler(final GUIWINDOW theGui) {
        myGui = theGui;
    }

    @Override
    public void keyTyped(final KeyEvent theE) { }
    public void keyHandler(final GUIWINDOW theGui) {
        myGui = theGui;
    }
    @Override
    public void keyPressed(final KeyEvent theE) {
        final int code = theE.getKeyCode();

        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            myLeftPressed = true;
        }
        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            myRightPressed = true;
        }
        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            myDownPressed = true;
        }
    }

    @Override
    public void keyReleased(final KeyEvent theE) {
        final int code = theE.getKeyCode();

        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            myLeftPressed = false;
        }
        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            myRightPressed = false;
        }
        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            myDownPressed = false;
        }
    }
}
