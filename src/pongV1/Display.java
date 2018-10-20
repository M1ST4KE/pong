package pongV1;

import pongV1.controller.InputHandler;
import pongV1.engine.Ball;
import pongV1.engine.Paddle;
import pongV1.engine.Settings;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {
    private Settings currSettings = new Settings();
    private InputHandler input = new InputHandler();
    private static Ball ball = new Ball();
    public static Paddle p1 = new Paddle(0);
//    private static Paddle p2 = new Paddle(1);
    public static boolean repeat = true;

    void setupDisplay(){
        JFrame frame = new JFrame("Pong by Kamil");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBackground(Color.black);
        frame.getContentPane().setPreferredSize(new Dimension(currSettings.WIDTH, currSettings.HEIGHT));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(this);
        frame.addKeyListener(input);
    }

    void renderLoop(){
        while (repeat){
            repaint();
        }
    }

    public void paintComponent(Graphics g){
        g.clearRect(0,0,currSettings.WIDTH,currSettings.HEIGHT);
        g.setColor(Color.black);
        g.fillRect(0,0,currSettings.WIDTH,currSettings.HEIGHT);
        g.setColor(Color.white);
        g.fillOval(ball.positionX(),ball.positionY(),ball.radius(), ball.radiusMv());
        g.fillRect(p1.positionX(),p1.positionY(),p1.width(),p1.heightMv());
//        g.fillRect(p2.positionX(),p2.positionY(),p2.width(),p2.height());
    }

}
