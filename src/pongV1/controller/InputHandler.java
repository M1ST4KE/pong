package pongV1.controller;

import pongV1.Display;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_UP)
            Display.p1.goingUp = true;
        if (keyCode == KeyEvent.VK_DOWN)
            Display.p1.goingDown = true;
        if (keyCode == KeyEvent.VK_ESCAPE)
            Display.repeat = false;
    }

    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_UP)
            Display.p1.goingUp = false;
        if (keyCode == KeyEvent.VK_DOWN)
            Display.p1.goingDown = false;
    }
}
