package main.java.gui;

import main.java.gamelogic.GameState;

public class BufferGUI extends GUIElement {
    public BufferGUI(float x, float y) {
        super(x, y);
    }

    @Override
    public void render(GameState gameState) {
        batch.begin();

        for (int i = 0; i < gameState.gameLevel.bufferLength; i++) {
            font.draw(batch, "_", x + i * 20, y - 2);

            if (gameState.buffer.size() > i)
                font.draw(batch, gameState.gameLevel.matrix.get(gameState.buffer.get(i)), x + i * 20, y);
        }

        batch.end();
    }
}
