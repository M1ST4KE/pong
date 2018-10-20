package pongV1;


public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        display.setupDisplay();
        display.renderLoop();
        System.exit(0);
    }

}
