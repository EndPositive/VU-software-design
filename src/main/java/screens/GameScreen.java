package main.java.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import main.java.gamelogic.GameState;
import main.java.gui.GUIElement;

import java.util.List;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;

public abstract class GameScreen extends ScreenAdapter {
    protected final Game game;
    protected final GameState gameState;
    private final List<GUIElement> guiElements;

    protected GameScreen(Game game, GameState gameState, List<GUIElement> guiElements) {
        this.game = game;
        this.gameState = gameState;
        this.guiElements = guiElements;
    }

    @Override
    public final void show() {
        guiElements.forEach(GUIElement::show);
        Gdx.input.setInputProcessor(getInputProcessor());
    }

    public abstract InputAdapter getInputProcessor();

    @Override
    public final void render(float delta) {
        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);
        guiElements.forEach(el -> el.render(gameState));
    }

    public void renderCallback() {
    }

}
