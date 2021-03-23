package main.java.gui;

import com.badlogic.gdx.graphics.Color;
import main.java.gamelogic.GameState;

public class TimerGUI extends GUIElement {
    public TimerGUI(float x, float y) {
        super(x, y);
    }

    @Override
    public void render(GameState gameState) {
        batch.begin();

        if (gameState.timer.hasStarted()) font.setColor(Color.RED);

        font.draw(batch, "Time left: " + gameState.timer.timeLeft() + " seconds", x, y);

        batch.end();
    }
}
