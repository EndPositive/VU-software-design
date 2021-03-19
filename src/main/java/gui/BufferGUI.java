package main.java.gui;

import main.java.gamelogic.GameState;

public class BufferGUI extends GUIElement {
    public BufferGUI(float x, float y) {
        super(x, y);
    }

    @Override
    public void render(GameState gameState) {
        batch.begin();

        for (int i = 0; i < gameState.getCurrentBufferLength(); i++) {
            font.draw(batch, "__", x + i * 25, y - 2);

            if (gameState.getBuffer().size() > i) {
                font.draw(batch, gameState.gameLevel.matrix.get(gameState.getBuffer().get(i)), x + i * 25, y);
            }
        }

        batch.end();
    }
}
