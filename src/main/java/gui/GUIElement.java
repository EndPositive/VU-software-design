package main.java.gui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import main.java.gamelogic.GameState;

public abstract class GUIElement {
    protected final float x;
    protected final float y;
    protected SpriteBatch batch;
    protected BitmapFont font;

    protected final static int padding = 30;
    protected final static int gridSelectorSize = padding - 10;
    protected final static int gridPaddingOffset = padding / 2;
    protected final static int gridCoordinateOffset = padding / 3;

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
