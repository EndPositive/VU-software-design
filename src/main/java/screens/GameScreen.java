package main.java.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import main.java.gamelogic.GameState;
import main.java.gui.BufferGUI;
import main.java.gui.GridGUI;
import main.java.gui.SequenceGUI;
import main.java.misc.Direction;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;

public class GameScreen extends ScreenAdapter {
    final Game game;
    final GridGUI gridGUI;
    final GameState gameState;
    final BufferGUI bufferGUI;
    final SequenceGUI sequenceGUI;

    public GameScreen(Game game, GameState gameState) {
        this.game = game;
        this.gameState = gameState;
        gridGUI = new GridGUI(20, 300);
        sequenceGUI = new SequenceGUI(200, 300);
        bufferGUI = new BufferGUI(200, 330);
    }

    @Override
    public void show() {
        gridGUI.create();
        sequenceGUI.create();
        bufferGUI.create();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);

        gridGUI.render(gameState);
        sequenceGUI.render(gameState);
        bufferGUI.render(gameState);

        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) Gdx.app.exit();
        if (Gdx.input.isKeyPressed(Keys.UP)) gameState.move(Direction.UP);
        if (Gdx.input.isKeyPressed(Keys.DOWN)) gameState.move(Direction.DOWN);
        if (Gdx.input.isKeyPressed(Keys.LEFT)) gameState.move(Direction.LEFT);
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) gameState.move(Direction.RIGHT);
        if (Gdx.input.isKeyPressed(Keys.SPACE)) gameState.confirmSelector();
        if (Gdx.input.isKeyPressed(Keys.BACKSPACE)) gameState.undo();
        if (Gdx.input.isKeyPressed(Keys.R)) gameState.redo();
        if (Gdx.input.isKeyPressed(Keys.ENTER)) game.setScreen(new GameOverScreen(game, gameState));
    }
}
