package main.java.gui;

public class TimerGUI extends GUIElement {
    private long startTime;
    private final long totalTime;

    public TimerGUI(long time, float x, float y) {
        super(x, y);
        totalTime = time;
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public long timeLeft() {
        return startTime + totalTime - System.currentTimeMillis();
    }
}
