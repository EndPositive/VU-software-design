package main.java.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.ScreenAdapter;
import main.java.gamelogic.GameState;
import main.java.gui.GridGUI;

public class GameScreen extends ScreenAdapter {
    final Game game;
    final GridGUI gridGUI;
    final GameState gameState;

    public GameScreen(Game game, GameState gameState) {
        this.game = game;
        this.gameState = gameState;
        gridGUI = new GridGUI(20, 250);
    }

    @Override
    public void show() {
        gridGUI.create();
    }

    @Override
    public void render(float delta) {
        gridGUI.render(gameState);
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void dispose() {
    }
}
