package main.java.gamelogic;

public class TimerLogic {
    public long startTime = -1;
    public final long totalTime;

    public TimerLogic(long time) {
        totalTime = time * 1000 + 1;
    }

    public boolean hasStarted() {
        return startTime != -1;
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public long timeLeft() {
        return (startTime + totalTime - System.currentTimeMillis()) / 1000;
    }
}
