package main.java;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import main.java.gamelogic.GameLevel;
import main.java.screens.GameplayScreen;

import java.io.IOException;

public class BreachGame extends Game {
    private final Screen startScreen;

    public BreachGame(String filePath) throws IOException {
        GameLevel gameLevel = new GameLevel(filePath);
        startScreen = new GameplayScreen(this, gameLevel);
    }

    @Override
    public void create() {
        setScreen(startScreen);
    }
}
