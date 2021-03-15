package main.java.gui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import main.java.gamelogic.GameState;

public abstract class GUIElement {
    protected final float x;
    protected final float y;
    protected SpriteBatch batch;
    protected BitmapFont font;

    public GUIElement(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public final void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    abstract public void render(GameState gameState);
}
