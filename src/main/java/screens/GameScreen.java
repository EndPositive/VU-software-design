package main.java.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import main.java.gamelogic.GameState;
import main.java.gui.BufferGUI;
import main.java.gui.GridGUI;
import main.java.gui.SequenceGUI;
import main.java.gui.TimerGUI;
import main.java.misc.Direction;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;

public class GameScreen extends ScreenAdapter {
    final Game game;
    boolean isKeyDown;
    final GridGUI gridGUI;
    final TimerGUI timerGUI;
    final GameState gameState;
    final BufferGUI bufferGUI;
    final SequenceGUI sequenceGUI;

    public GameScreen(Game game, GameState gameState) {
        this.game = game;
        this.gameState = gameState;
        isKeyDown = false;
        gridGUI = new GridGUI(20, 300);
        sequenceGUI = new SequenceGUI(220, 300);
        bufferGUI = new BufferGUI(220, 330);
        timerGUI = new TimerGUI(10, 20, 330);
    }

    @Override
    public void show() {
        gridGUI.create();
        sequenceGUI.create();
        bufferGUI.create();
        timerGUI.create();

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyUp(int keycode) {
                if (keycode == Keys.ENTER) game.setScreen(new GameOverScreen(game, gameState));
                if (keycode == Keys.E) game.setScreen(new EasterEggScreen());
                if (keycode == Keys.UP) gameState.move(Direction.UP);
                if (keycode == Keys.DOWN) gameState.move(Direction.DOWN);
                if (keycode == Keys.LEFT) gameState.move(Direction.LEFT);
                if (keycode == Keys.RIGHT) gameState.move(Direction.RIGHT);
                if (keycode == Keys.SPACE) {
                    if (!timerGUI.hasStarted()) timerGUI.start();
                    gameState.confirmSelector();
                }
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

        if (timerGUI.timeLeft() == 0) game.setScreen(new GameOverScreen(game, gameState));
    }
}
