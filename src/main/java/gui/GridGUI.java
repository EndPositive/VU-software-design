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
        if (gameState.buffer.size() % 2 == 0) {
            shapeRenderer.rect(x, y - gameState.selector.y * padding - gridPaddingOffset,
                    gameState.gameLevel.matrixSize * padding - gridCoordinateOffset, gridPaddingOffset);
        } else {
            shapeRenderer.rect(x + gameState.selector.x * padding, y - (gameState.gameLevel.matrixSize - 1) * padding - gridPaddingOffset,
                    gridPaddingOffset, gameState.gameLevel.matrixSize * padding - gridCoordinateOffset);
        }
        shapeRenderer.end();

        //Render the cell selector
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(x + gameState.selector.x * padding, y - gameState.selector.y * padding - gridPaddingOffset, gridSelectorSize, gridSelectorSize);
        shapeRenderer.end();

        batch.begin();

        //Render the matrix
        gameState.gameLevel.matrix.forEach((key, value) -> font.draw(batch, value, x + key.x * padding, y - key.y * padding));

        batch.end();
    }
}
