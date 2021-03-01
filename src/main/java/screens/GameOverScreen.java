package main.java.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import main.java.gamelogic.GameState;
import main.java.gui.BufferGUI;
import main.java.gui.ScoreGUI;
import main.java.gui.SequenceGUI;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;

public class GameOverScreen extends ScreenAdapter {
    final Game game;
    final GameState gameState;
    final ScoreGUI scoreGUI;
    final BufferGUI bufferGUI;
    final SequenceGUI sequenceGUI;

    public GameOverScreen(Game game, GameState gameState) {
        this.game = game;
        this.gameState = gameState;
        this.scoreGUI = new ScoreGUI(50, 330);
        this.bufferGUI = new BufferGUI(50, 230);
        this.sequenceGUI = new SequenceGUI(50, 200);
    }

    @Override
    public void show() {
        scoreGUI.create();
        bufferGUI.create();
        sequenceGUI.create();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);

        scoreGUI.render(gameState);
        bufferGUI.render(gameState);
        sequenceGUI.render(gameState);

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) Gdx.app.exit();
    }
}
