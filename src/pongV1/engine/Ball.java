package pongV1.engine;

import pongV1.Display;

import java.awt.geom.Point2D;
import java.util.concurrent.ThreadLocalRandom;

public class Ball {
    private Settings currSettings = new Settings();
    private static int radius;
    private static Point2D.Double position;
    private static double speed;
    private static Point2D.Double direction;
    private double angle;

    static {
        position = new Point2D.Double();
        direction = new Point2D.Double();
    }

    public Ball(){
        radius = currSettings.BALL_RADIUS;
        position.setLocation((currSettings.WIDTH / 2.) - radius / 2.,(currSettings.HEIGHT / 2.) - radius / 2.);
        speed = 3;
        angle = ThreadLocalRandom.current().nextDouble(0, 361);
        direction.setLocation(Math.sin(Math.toRadians(angle)),Math.cos(Math.toRadians(angle)));
    }

    private void movement(){
        Point2D.Double tmpPosition = new Point2D.Double(position.getX() + (direction.getX() * speed),
                position.getY() + (direction.getY() * speed));

        if (tmpPosition.getY() < 0 || tmpPosition.getY() > currSettings.HEIGHT - radius){
            direction.setLocation(direction.getX(),-(direction.getY()));

            position.setLocation(position.getX() + (direction.getX() * speed),
                    position.getY() + (direction.getY() * speed));

        } else if (tmpPosition.getX() > currSettings.WIDTH - radius){
            direction.setLocation(-direction.getX(),(direction.getY()));

            position.setLocation(position.getX() + (direction.getX() * speed),
                    position.getY() + (direction.getY() * speed));
        } /*else if (tmpPosition.getX() < 0 || tmpPosition.getX() > currSettings.WIDTH - radius){
            //TODO dopisać score
        } */else if (Display.p1.positionX() + Display.p1.width() >= position.getX()){
                if ((position.getY() - radius / 2. >= Display.p1.positionY())
                 && (position.getY() - radius / 2. <= Display.p1.positionY() + currSettings.PADDLE_HEIGHT)) {
                    angle = -((((position.getY() - Display.p1.positionY() + currSettings.PADDLE_HEIGHT / 2.) / currSettings.PADDLE_HEIGHT) * 180) + 90);
                    direction.setLocation(Math.sin(Math.toRadians(angle)),Math.cos(Math.toRadians(angle)));
                }
//                    direction.setLocation(-direction.getX(),(direction.getY()));
                    position.setLocation(position.getX() + (direction.getX() * speed),
                    position.getY() + (direction.getY() * speed));
        } else  {
            position.setLocation(tmpPosition);
        }
    }

    public int positionX(){
        return (int)position.getX();
    }
    public int positionY(){
        return (int)position.getY();
    }
    public int radius(){ return  radius; }
    public int radiusMv(){
        movement();
        return  radius;
    }
}
