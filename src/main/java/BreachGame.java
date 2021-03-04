package main.java;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import main.java.gamelogic.GameLevel;
import main.java.gamelogic.GameState;
import main.java.screens.GameScreen;

public class BreachGame extends Game {
    private GameLevel gameLevel;
    private GameState gameState;
    private Screen currentScreen;

    public BreachGame(String filePath) {
        try {
            gameLevel = new GameLevel(filePath);
            gameState = new GameState(gameLevel);
            currentScreen = new GameScreen(this, gameState);
        } catch (Exception e) {
            System.err.println(e.toString());
            Gdx.app.exit();
        }
    }

    @Override
    public void create() {
        setScreen(currentScreen);
    }
}
