package main.java;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import main.java.gamelogic.GameLevel;
import main.java.gamelogic.GameState;
import main.java.screens.GameScreen;

public class BreachGame extends Game {
    private final GameLevel gameLevel;
    private final GameState gameState;
    private final Screen currentScreen;

    public BreachGame(String filePath) throws Exception {
        gameLevel = new GameLevel(filePath);
        gameState = new GameState(gameLevel);
        currentScreen = new GameScreen(this, gameState);
    }

    @Override
    public void create() {
        setScreen(currentScreen);
    }
}
