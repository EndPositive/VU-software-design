package main.java.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import main.java.commands.Command;
import main.java.commands.CommandFactory;
import main.java.gamelogic.GameLevel;
import main.java.gamelogic.GameState;
import main.java.gui.*;

import java.util.Arrays;
import java.util.List;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;

public class GameplayScreen extends ScreenAdapter {
    private final Game game;
    private final GameState gameState;
    private final List<GUIElement> guiElements;

    public GameplayScreen(Game game, GameLevel gameLevel) {
        this.game = game;
        gameState = new GameState(gameLevel);
        guiElements = Arrays.asList(
                new GridGUI(20, 300),
                new SequenceGUI(220, 300),
                new BufferGUI(220, 330),
                new TimerGUI(20, 330),
                new TutorialGUI(20, 120)
        );
    }

    @Override
    public void show() {
        guiElements.forEach(GUIElement::create);

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyUp(int keycode) {
                Command command = CommandFactory.createCommand(keycode);
                if (command != null) {
                    command.tryExecute(gameState);
                    return true;
                }

                switch (keycode) {
                    case Keys.BACKSPACE:
                        gameState.tryUndo();
                        return true;
                    case Keys.R:
                        gameState.tryRedo();
                        return true;
                    case Keys.ESCAPE:
                        Gdx.app.exit();
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);
        guiElements.forEach(el -> el.render(gameState));

        if (gameState.isGameOver()) {
            game.setScreen(new GameOverScreen(game, gameState));
        }
    }
}
