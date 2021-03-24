package main.java.screens;

import com.badlogic.gdx.*;
import main.java.gamelogic.GameState;
import main.java.gui.BufferGUI;
import main.java.gui.GUIElement;
import main.java.gui.ScoreGUI;
import main.java.gui.SequenceGUI;

import java.util.Arrays;
import java.util.List;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;

public class GameOverScreen extends ScreenAdapter {
    private final Game game;
    private final GameState gameState;
    private final List<GUIElement> guiElements;

    public GameOverScreen(Game game, GameState gameState) {
        this.game = game;
        this.gameState = gameState;
        guiElements = Arrays.asList(
                new ScoreGUI(50, 330),
                new BufferGUI(50, 230),
                new SequenceGUI(50, 200)
        );
    }

    @Override
    public void show() {
        guiElements.forEach(GUIElement::show);

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyUp(int keycode) {
                if (keycode == Input.Keys.ESCAPE) Gdx.app.exit();
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);
        guiElements.forEach(el -> el.render(gameState));
    }
}
