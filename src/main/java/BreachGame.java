package main.java;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
    private BitmapFont font;

    public BreachGame(String filePath) {
        try {
            gameLevel = new GameLevel(filePath);
            gameState = new GameState(gameLevel);
            currentScreen = new GameScreen(this);
        } catch (FileNotFoundException e) {
            System.err.println(e.toString());
        }
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.GREEN);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        font.draw(batch, "//TODO: Implement me", 200, 200);
        batch.end();
    }
}
