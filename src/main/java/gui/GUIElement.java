package main.java.gui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import main.java.gamelogic.GameState;

public abstract class GUIElement {
    protected final float x;
    protected final float y;
    protected SpriteBatch batch;
    protected BitmapFont font;

    protected final int padding;

    protected final int gridSelectorSize;
    protected final int gridPaddingOffset;
    protected final int gridCoordinateOffset;

    protected final int scorePadding;

    protected GUIElement(float x, float y) {
        this.x = x;
        this.y = y;

        padding = 30;

        gridSelectorSize = 20;
        gridPaddingOffset = 15;
        gridCoordinateOffset = 10;

        scorePadding = 60;          //Is this needed? Go to ScoreGUI.java for more
    }

    public final void show() {
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    public abstract void render(GameState gameState);
}
