package main.java.gui;

import com.badlogic.gdx.graphics.Color;
import main.java.gamelogic.GameState;

public class ScoreGUI extends GUIElement {
    public ScoreGUI(float x, float y) {
        super(x, y);
    }

    @Override
    public void render(GameState gameState) {
        int score = gameState.getScore();

        batch.begin();

        font.setColor(Color.PINK);
        font.draw(batch, score != 0 ? "You breached the protocol!" : "Sometimes in life you fail and sometimes you don't succeed :(", x, y);
        font.draw(batch, "Your score is: ", x, y - 30);

        font.setColor(Color.GOLD);
        font.draw(batch, String.valueOf(score), x, y - 60);

        batch.end();
    }
}
