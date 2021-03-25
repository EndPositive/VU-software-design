package main.java.gui;

import main.java.gamelogic.GameState;

public class BufferGUI extends GUIElement {
    public BufferGUI(float x, float y) {
        super(x, y);
    }

    @Override
    public void render(GameState gameState) {
        batch.begin();

        for (int i = 0; i < gameState.getBuf().getMaxBufferLength(); i++) {
            font.draw(batch, "__", x + i * padding, y);

            if (gameState.getBuf().size() > i) {
                font.draw(batch, gameState.getLevel().getMatrix().get(gameState.getBuf().get(i)), x + i * padding, y);
            }
        }

        batch.end();
    }
}
