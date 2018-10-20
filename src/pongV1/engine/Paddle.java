package pongV1.engine;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class Paddle {

    private static Settings currSettings = new Settings();
    private static Point2D.Double position = new Point2D.Double();
    private static Dimension2D dimension = new Dimension(currSettings.PADDLE_WIDTH, currSettings.PADDLE_HEIGHT);
    private static double currSpeed = 0;

    public boolean goingUp = false;
    public boolean goingDown = false;

    public Paddle(int pos){
        position.setLocation((20. + (currSettings.WIDTH - 60.) * (pos)), (currSettings.HEIGHT - currSettings.PADDLE_HEIGHT) / 2.);
    }

    private void move(){
        double maxSpeed = 6;
        if (position.getY() < 0) {
            currSpeed = 0;
            position.setLocation(position.getX(), 0);
        } else if (position.getY() > currSettings.HEIGHT - currSettings.PADDLE_HEIGHT){
            currSpeed = 0;
            position.setLocation(position.getX(), currSettings.HEIGHT - currSettings.PADDLE_HEIGHT);
        } else if (goingUp){
            if (currSpeed >= -maxSpeed)
                currSpeed -= 0.2;
        } else if (goingDown){
            if (currSpeed <= maxSpeed)
                currSpeed += 0.2;
        } else {
            if (currSpeed <= 0. && currSpeed >= -0.2)
                currSpeed = 0;
            currSpeed *= 0.965;
        }

        position.setLocation(position.getX(), position.getY() + currSpeed);
    }

    public int positionX(){ return (int)position.getX(); }
    public int positionY(){ return (int)position.getY(); }
    public int width(){ return  (int)dimension.getWidth(); }
    public int height(){ return  (int)dimension.getHeight(); }
    public int heightMv(){
        move();
        return  (int)dimension.getHeight(); }
}
