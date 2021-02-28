package main.java.gui;

import main.java.gamelogic.GameState;
import main.java.misc.Cell;

import java.util.EmptyStackException;
import java.util.List;

public class BufferGUI extends GUIElement {
    public BufferGUI(float x, float y) {
        super(x, y);
    }

    @Override
    public void render(GameState gameState) {
        batch.begin();
        List<Cell> top = null;

        try {
            top = gameState.gameFrames.peek();
        } catch (EmptyStackException ignored) {
        }

        for (int i = 0; i < gameState.gameLevel.bufferLength; i++) {
            font.draw(batch, "_", x + i * 20, y - 2);

            if (top != null && top.size() > i)
                font.draw(batch, gameState.gameLevel.matrix.get(top.get(i)), x + i * 20, y);
        }

        batch.end();
    }
}
