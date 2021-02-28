package main.java;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import main.java.gamelogic.GameLevel;
import main.java.gamelogic.GameState;
import main.java.screens.GameScreen;

import java.io.FileNotFoundException;

public class BreachGame extends Game {
    private GameLevel gameLevel;
    private GameState gameState;
    private Screen currentScreen;

    private SpriteBatch batch;

    public BreachGame(String filePath) {
        try {
            gameLevel = new GameLevel(filePath);
            gameState = new GameState(gameLevel);
            currentScreen = new GameScreen(this, gameState);
        } catch (FileNotFoundException e) {
            System.err.println(e.toString());
        }
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(currentScreen);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
