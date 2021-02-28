package main.java.gui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import main.java.gamelogic.GameFrame;
import main.java.gamelogic.GameState;

public abstract class GUIElement {
    final float x;
    final float y;
    SpriteBatch batch;
    BitmapFont font;

    //TODO: Implement me
    public GUIElement(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    //TODO: Implement me
    public void render(GameState gameState) {

    }

    //TODO: Implement me
    public void update(GameFrame currentFrame) {
    }
}
