package main.java.gui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import main.java.gamelogic.GameFrame;
import main.java.gamelogic.GameLevel;

public abstract class GUIElement {
    private SpriteBatch batch;
    private BitmapFont font;
    private float x, y;
    private GameLevel gameLevel;

    //TODO: Implement me
    public GUIElement(float x, float y) {
    }

    //TODO: Implement me
    public void render() {
    }

    //TODO: Implement me
    public void update(GameFrame currentFrame) {
    }
}
