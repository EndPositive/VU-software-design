package main.java.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.ScreenAdapter;
import main.java.gamelogic.GameState;
import main.java.gui.BufferGUI;
import main.java.gui.GridGUI;
import main.java.gui.SequenceGUI;

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
        gridGUI.render(gameState);
        sequenceGUI.render(gameState);
        bufferGUI.render(gameState);
    }
}
