package main.java.gui;

import main.java.gamelogic.GameState;

public class BufferGUI extends GUIElement {
    public BufferGUI(float x, float y) {
        super(x, y);
    }

    @Override
    public void render(GameState gameState) {
        batch.begin();

        for (int i = 0; i < gameState.buffer.getMaxBufferLength(); i++) {
            font.draw(batch, "__", x + i * PADDING, y);

            if (gameState.buffer.size() > i) {
                font.draw(batch, gameState.buffer.get(i), x + i * PADDING, y);
            }
        }

        batch.end();
    }
}
