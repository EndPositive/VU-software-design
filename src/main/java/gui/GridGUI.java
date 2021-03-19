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

        //Render the gray area spanning the entire row/column that the user can navigate
        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.GRAY);
        if (gameState.getBuffer().size() % 2 == 0) {
            shapeRenderer.rect(x, y - gameState.selector.y * 30 - 15,
                    gameState.gameLevel.matrixSize * 30 - 10, 15);
        } else {
            shapeRenderer.rect(x + gameState.selector.x * 30, y - (gameState.gameLevel.matrixSize - 1) * 30 - 15,
                    15, gameState.gameLevel.matrixSize * 30 - 10);
        }
        shapeRenderer.end();

        //Render the cell selector
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(x + gameState.selector.x * 30, y - gameState.selector.y * 30 - 15, 20, 20);
        shapeRenderer.end();

        batch.begin();

        //Render the matrix
        gameState.gameLevel.matrix.forEach((key, value) -> font.draw(batch, value, x + key.x * 30, y - key.y * 30));

        batch.end();
    }
}
