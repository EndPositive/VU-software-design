package main.java.gui;

import main.java.gamelogic.GameState;
import main.java.misc.Cell;

//TODO: Implement me
public class GridGUI extends GUIElement {
    public GridGUI(float x, float y) {
        super(x, y);
    }

    @Override
    public void render(GameState gameState) {
        batch.begin();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                font.draw(batch, gameState.gameLevel.matrix.get(new Cell(i, j)), x + i * 20, j * 20 + y);
            }
        }

        batch.end();
    }
}
