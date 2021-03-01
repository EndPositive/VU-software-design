package main.java.gui;

import com.badlogic.gdx.graphics.Color;
import main.java.gamelogic.GameState;

public class TimerGUI extends GUIElement {
    private long startTime = -1;
    private final long totalTime;

    public TimerGUI(long time, float x, float y) {
        super(x, y);
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

    @Override
    public void render(GameState gameState) {

        batch.begin();
        if (startTime != -1) {
            font.setColor(Color.RED);
            font.draw(batch, "Time left: " + timeLeft() + " seconds", x, y);
        } else font.draw(batch, "Time left: " + totalTime / 1000 + " seconds", x, y);

        batch.end();
    }
}
