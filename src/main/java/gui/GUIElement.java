package main.java.gui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import main.java.gamelogic.GameState;

public abstract class GUIElement {
    protected final float x;
    protected final float y;
    protected SpriteBatch batch;
    protected BitmapFont font;

    protected static final int PADDING = 30;
    protected static final int GRID_SELECTOR_SIZE = 20;
    protected static final int GRID_PADDING_OFFSET = PADDING / 2;
    protected static final int GRID_COORDINATE_OFFSET = PADDING / 3;

    protected GUIElement(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public final void show() {
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    public abstract void render(GameState gameState);
}
