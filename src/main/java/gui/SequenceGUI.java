package main.java.gui;

import com.badlogic.gdx.graphics.Color;
import main.java.gamelogic.GameState;

public class SequenceGUI extends GUIElement {
    public SequenceGUI(float x, float y) {
        super(x, y);
    }

    @Override
    public void render(GameState gameState) {
        batch.begin();

        font.setColor(Color.BLUE);
        font.draw(batch, "Sequences to complete: ", x, y);

        font.setColor(Color.WHITE);
        for (int i = 0; i < gameState.gameLevel.solutions.size(); i++) {
            for (int j = 0; j < gameState.gameLevel.solutions.get(i).size(); j++) {
                font.draw(batch, gameState.gameLevel.solutions.get(i).get(j), x + j * 20, y - i * 20 - 20);
            }
        }

        batch.end();
    }
}