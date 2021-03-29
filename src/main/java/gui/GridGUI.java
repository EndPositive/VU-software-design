package main.java.gui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import main.java.gamelogic.GameState;
import main.java.misc.Cell;

public class GridGUI extends GUIElement {
    public GridGUI(float x, float y) {
        super(x, y);
    }

    @Override
    public void render(GameState gameState) {
        Cell selector = gameState.selector;

        //Render the gray area spanning the entire row/column that the user can navigate
        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.GRAY);

        if (gameState.buffer.size() % 2 == 0) {
            shapeRenderer.rect(x, y - selector.y * PADDING - GRID_PADDING_OFFSET,
                    gameState.gameLevel.getMatrixSize() * PADDING - GRID_COORDINATE_OFFSET, GRID_PADDING_OFFSET);
        } else {
            shapeRenderer.rect(x + selector.x * PADDING, y - (gameState.gameLevel.getMatrixSize() - 1) * PADDING - GRID_PADDING_OFFSET,
                    GRID_PADDING_OFFSET, gameState.gameLevel.getMatrixSize() * PADDING - GRID_COORDINATE_OFFSET);
        }
        shapeRenderer.end();

        //Render the cell selector
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(x + selector.x * PADDING, y - selector.y * PADDING - GRID_PADDING_OFFSET, GRID_SELECTOR_SIZE, GRID_SELECTOR_SIZE);
        shapeRenderer.end();

        batch.begin();

        //Render the matrix
        gameState.gameLevel.getMatrix().forEach((key, value) -> font.draw(batch, value, x + key.x * PADDING, y - key.y * PADDING));

        batch.end();
    }
}
