package main.java.gui;

import com.badlogic.gdx.graphics.Color;
import main.java.gamelogic.GameState;
import main.java.gamelogic.TimerLogic;

public class TimerGUI extends GUIElement {
    private final TimerLogic timerLogic;

    public TimerGUI(TimerLogic timerLogic, float x, float y) {
        super(x, y);
        this.timerLogic = timerLogic;
    }

    @Override
    public void render(GameState gameState) {

        batch.begin();
        if (timerLogic.startTime != -1) {
            font.setColor(Color.RED);
            font.draw(batch, "Time left: " + timerLogic.timeLeft() + " seconds", x, y);
        } else font.draw(batch, "Time left: " + timerLogic.totalTime / 1000 + " seconds", x, y);

        batch.end();
    }
}
