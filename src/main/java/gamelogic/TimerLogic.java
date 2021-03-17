package main.java.gamelogic;

public class TimerLogic {
    public long startTime = -1;
    public final long totalTime;

    //'time' is multiplied by 1000 to convert it from milliseconds to seconds.
    //'time' is incremented by 1 to make the countdown starts at the given 'time'.
    //The countdown is decreased when ENTER is pressed, making the countdown appear as if it starts at 'timer - 1' if it's not incremented by 1.
    public TimerLogic(long time) {
        totalTime = time * 1000;
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
