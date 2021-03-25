package main.java.gui;

import com.badlogic.gdx.graphics.Color;
import main.java.gamelogic.GameState;
import main.java.gamelogic.ScoreLogic;

public class ScoreGUI extends GUIElement {
    public ScoreGUI(float x, float y) {
        super(x, y);
    }

    @Override
    public void render(GameState gameState) {
        int score = ScoreLogic.calculateScore(gameState);

        batch.begin();

        font.setColor(Color.PINK);
        font.draw(batch, score != 0 ? "You breached the protocol!" : "Sometimes in life you fail and sometimes you don't succeed :(", x, y);
        font.draw(batch, "Your score is: ", x, y - padding);

        font.setColor(Color.GOLD);
        font.draw(batch, String.valueOf(score), x, y - padding * 2);

        batch.end();
    }
}
