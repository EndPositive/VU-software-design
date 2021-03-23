package main.java.misc;

public class Timer {
    private long startTime = -1;
    private final long totalTime;
    private long stopTime = -1;

    //'time' is multiplied by 1000 to convert it from milliseconds to seconds.
    public Timer(long time) {
        totalTime = time * 1000;
    }

    public boolean hasStarted() {
        return startTime != -1;
    }

    public boolean hasStopped() {
        return stopTime > -1;
    }

    public boolean hasExpired() {
        return hasStarted() && timeLeft() <= 0;
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        if (hasStarted()) stopTime = System.currentTimeMillis();
    }

    public long timeLeft() {
        // if the timer hasn't started we just give the total time
        if (!hasStarted()) return totalTime / 1000;

        // if the timer has been stopped, we give the difference between when it was stopped and when it started
        if (stopTime > -1) return (stopTime - startTime) / 1000;

        // make sure that the remaining time doesn't go below 0
        return Math.max(0, (startTime + totalTime - System.currentTimeMillis()) / 1000);
    }
}
