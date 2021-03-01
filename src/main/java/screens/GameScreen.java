package main.java.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
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
        timerGUI = new TimerGUI(60, 20, 330);
    }

    @Override
    public void show() {
        gridGUI.create();
        sequenceGUI.create();
        bufferGUI.create();
        timerGUI.create();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);

        gridGUI.render(gameState);
        sequenceGUI.render(gameState);
        bufferGUI.render(gameState);
        timerGUI.render(gameState);

        if (!isKeyDown) {
            if (Gdx.input.isKeyPressed(Keys.SPACE)) {
                isKeyDown = true;
                if (!timerGUI.hasStarted()) timerGUI.start();
                gameState.confirmSelector();
            }
            if (timerGUI.timeLeft() == 0) game.setScreen(new GameOverScreen(game, gameState));
            if (Gdx.input.isKeyPressed(Keys.ESCAPE)) Gdx.app.exit();
            if (Gdx.input.isKeyPressed(Keys.UP)) {
                isKeyDown = true;
                gameState.move(Direction.UP);
            }
            if (Gdx.input.isKeyPressed(Keys.DOWN)) {
                isKeyDown = true;
                gameState.move(Direction.DOWN);
            }
            if (Gdx.input.isKeyPressed(Keys.LEFT)) {
                isKeyDown = true;
                gameState.move(Direction.LEFT);
            }
            if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
                isKeyDown = true;
                gameState.move(Direction.RIGHT);
            }
            if (Gdx.input.isKeyPressed(Keys.BACKSPACE)) {
                isKeyDown = true;
                gameState.undo();
            }
            if (Gdx.input.isKeyPressed(Keys.R)) {
                isKeyDown = true;
                gameState.redo();
            }
            if (Gdx.input.isKeyPressed(Keys.ENTER)) game.setScreen(new GameOverScreen(game, gameState));
            if (Gdx.input.isKeyPressed(Keys.E)) game.setScreen(new EasterEggScreen());
        } else isKeyDown = false;
    }
}
