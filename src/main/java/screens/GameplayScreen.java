package main.java.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import main.java.gamelogic.GameState;
import main.java.gui.*;
import main.java.misc.Direction;

import java.util.Arrays;
import java.util.List;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;

public class GameplayScreen extends ScreenAdapter {
    private final Game game;
    private final GameState gameState;
    private final List<GUIElement> guiElements;

    public GameplayScreen(Game game, GameState gameState) {
        this.game = game;
        this.gameState = gameState;
        gridGUI = new GridGUI(20, 300);
        sequenceGUI = new SequenceGUI(220, 300);
        bufferGUI = new BufferGUI(220, 330);
        timerGUI = new TimerGUI(gameState.timerLogic, 20, 330);
        tutorialGUI = new TutorialGUI(20, 120);
    }

    @Override
    public void show() {
        gridGUI.create();
        sequenceGUI.create();
        bufferGUI.create();
        timerGUI.create();
        tutorialGUI.create();

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyUp(int keycode) {
                switch (keycode) {
                    case Keys.ENTER:
                        gameState.setScore();
                        game.setScreen(new GameOverScreen(game, gameState));
                        break;
                    case Keys.UP:
                        gameState.move(Direction.UP);
                        break;
                    case Keys.DOWN:
                        gameState.move(Direction.DOWN);
                        break;
                    case Keys.LEFT:
                        gameState.move(Direction.LEFT);
                        break;
                    case Keys.RIGHT:
                        gameState.move(Direction.RIGHT);
                        break;
                    case Keys.MINUS:
                        gameState.decreaseBufferLength();
                        break;
                    case Keys.EQUALS:
                        gameState.increaseBufferLength();
                        break;
                    case Keys.SPACE:
                        gameState.confirmSelector();
                        break;
                    case Keys.BACKSPACE:
                        gameState.undo();
                        break;
                    case Keys.R:
                        gameState.redo();
                        break;
                    case Keys.ESCAPE:
                        Gdx.app.exit();
                        break;
                    default:
                        return true;
                }

                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);
        guiElements.forEach(el -> el.render(gameState));

        if (gameState.timerLogic.timeLeft() == 0) {
            game.setScreen(new GameOverScreen(game, gameState));
        }
    }
}
