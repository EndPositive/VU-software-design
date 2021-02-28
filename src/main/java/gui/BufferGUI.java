package main.java.gui;

import main.java.gamelogic.GameFrame;
import main.java.gamelogic.GameState;

import java.util.EmptyStackException;

public class BufferGUI extends GUIElement {
    public BufferGUI(float x, float y) {
        super(x, y);
    }

    @Override
    public void render(GameState gameState) {
        batch.begin();
        GameFrame top = null;

        try {
            top = gameState.gameFrames.peek();
        } catch (EmptyStackException ignored) {
        }

        for (int i = 0; i < gameState.gameLevel.bufferLength; i++) {
            font.draw(batch, "_", x + i * 20, y - 2);

            if (top != null && top.buffer.size() > i)
                font.draw(batch, gameState.gameLevel.matrix.get(top.buffer.get(i)), x + i * 20, y);
        }

        batch.end();
    }
}
