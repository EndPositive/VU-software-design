package main.java.gui;

import com.badlogic.gdx.graphics.Color;
import main.java.gamelogic.GameState;

public class ScoreGUI extends GUIElement {
    public ScoreGUI(float x, float y) {
        super(x, y);
    }

    // TODO: Yingdi Assignment 3 simple GUI that displays the score from gameState.getScore() at x,y
    @Override
    public void render(GameState gameState) {
        batch.begin();

        font.setColor(Color.PINK);
        font.draw(batch, "You breached the protocol!", x, y);
        font.draw(batch, "Your score is: ", x, y - 30);

        font.setColor(Color.GOLD);
        font.draw(batch, String.valueOf(gameState.getScore()), x + 10, y - 60);

        batch.end();
    }
}
