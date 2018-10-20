package pongV1.engine;

public class Settings {
    public int WIDTH, HEIGHT, PADDLE_WIDTH, PADDLE_HEIGHT, BALL_RADIUS;
    public Settings(){
        WIDTH = 1600;
        HEIGHT = WIDTH / 16 * 9;
        PADDLE_WIDTH = WIDTH / 80;
        PADDLE_HEIGHT = HEIGHT / 4;
        BALL_RADIUS = WIDTH / 30;
    }
}
