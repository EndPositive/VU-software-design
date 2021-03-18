package main.java.gui;

import com.badlogic.gdx.graphics.Color;
import main.java.gamelogic.GameState;

import java.util.List;


public class SequenceGUI extends GUIElement {
    public SequenceGUI(float x, float y) {
        super(x, y);
    }

    @Override
    public void render(GameState gameState) {
        batch.begin();

        font.setColor(Color.BLUE);
        font.draw(batch, "Sequences to complete: ", x, y);

        for (int i = 0; i < gameState.gameLevel.solutions.size(); i++) {
            List<String> sequenceTemp = gameState.gameLevel.solutions.get(i);

            if (gameState.isSequenceCompleted(sequenceTemp)) {
                font.setColor(Color.GREEN);
            } else if (gameState.isSequenceFailed(sequenceTemp)) {
                font.setColor(Color.RED);
            } else font.setColor(Color.WHITE);

            for (int j = 0; j < sequenceTemp.size(); j++) {
                font.draw(batch, sequenceTemp.get(j), x + j * padding, y - i * padding - padding);
            }
        }

        batch.end();
    }
}