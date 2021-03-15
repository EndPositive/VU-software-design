package main.java.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import main.java.gamelogic.GameState;
import main.java.gui.*;
import main.java.misc.Direction;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;

public class GameScreen extends ScreenAdapter {
    final Game game;
    final GridGUI gridGUI;
    final TimerGUI timerGUI;
    final GameState gameState;
    final BufferGUI bufferGUI;
    final SequenceGUI sequenceGUI;
    final TutorialGUI tutorialGUI;

    public GameScreen(Game game, GameState gameState) {
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
                if (keycode == Keys.ENTER) {
                    gameState.setScore();
                    game.setScreen(new GameOverScreen(game, gameState));
                }
                if (keycode == Keys.UP) gameState.move(Direction.UP);
                if (keycode == Keys.DOWN) gameState.move(Direction.DOWN);
                if (keycode == Keys.LEFT) gameState.move(Direction.LEFT);
                if (keycode == Keys.RIGHT) gameState.move(Direction.RIGHT);
                if (keycode == Keys.MINUS) gameState.decreaseBufferLength();
                if (keycode == Keys.EQUALS) gameState.increaseBufferLength();
                if (keycode == Keys.SPACE) gameState.confirmSelector();
                if (keycode == Keys.BACKSPACE) gameState.undo();
                if (keycode == Keys.R) gameState.redo();
                if (keycode == Keys.ESCAPE) Gdx.app.exit();
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);

        gridGUI.render(gameState);
        sequenceGUI.render(gameState);
        bufferGUI.render(gameState);
        timerGUI.render(gameState);
        tutorialGUI.render(gameState);

        if (gameState.timerLogic.timeLeft() == 0) {
            gameState.setScore();
            game.setScreen(new GameOverScreen(game, gameState));
        }
    }
}
