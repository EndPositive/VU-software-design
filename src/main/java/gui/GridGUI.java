package main.java.gui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import main.java.gamelogic.GameState;

public class GridGUI extends GUIElement {
    public GridGUI(float x, float y) {
        super(x, y);
    }

    @Override
    public void render(GameState gameState) {
        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(x + gameState.selector.x * 20 - 5, y - gameState.selector.y * 20 - 15, 20, 20);
        shapeRenderer.end();

        batch.begin();

        gameState.gameLevel.matrix.forEach((key, value) -> font.draw(batch, value, x + key.x * 20, y - key.y * 20));

        batch.end();
    }
}
