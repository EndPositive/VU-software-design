package main.java.gui;

import main.java.gamelogic.GameState;

public class GridGUI extends GUIElement {
    public GridGUI(float x, float y) {
        super(x, y);
    }

    @Override
    public void render(GameState gameState) {
        batch.begin();

        //System.out.println(Gdx.graphics.getWidth());
        gameState.gameLevel.matrix.forEach((key, value) -> font.draw(batch, value, x + key.x * 20, y + (-key.y) * 20));

        batch.end();
    }
}
