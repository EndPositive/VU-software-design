package main.java.gui;

import com.badlogic.gdx.graphics.Color;
import main.java.gamelogic.GameState;
import main.java.gamelogic.Sequence;

public class SequenceGUI extends GUIElement {
    public SequenceGUI(float x, float y) {
        super(x, y);
    }

    @Override
    public void render(GameState gameState) {
        batch.begin();

        font.setColor(Color.BLUE);
        font.draw(batch, "Sequences to complete: ", x, y);

        for (int i = 0; i < gameState.gameLevel.getSolutions().size(); i++) {
            Sequence sequenceTemp = gameState.gameLevel.getSolutions().get(i);

            if (sequenceTemp.isSequenceCompleted(gameState)) {
                font.setColor(Color.GREEN);
            } else if (sequenceTemp.isSequenceFailed(gameState)) {
                font.setColor(Color.RED);
            } else font.setColor(Color.WHITE);

            font.draw(batch, sequenceTemp.toString() + "\n", x, y - i * PADDING - PADDING);
        }

        batch.end();
    }
}