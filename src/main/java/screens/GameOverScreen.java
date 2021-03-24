package main.java.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import main.java.gamelogic.GameState;
import main.java.gui.BufferGUI;
import main.java.gui.ScoreGUI;
import main.java.gui.SequenceGUI;

import java.util.Arrays;

public class GameOverScreen extends GameScreen {

    public GameOverScreen(Game game, GameState gameState) {
        super(game, gameState, Arrays.asList(
                new ScoreGUI(50, 330),
                new BufferGUI(50, 230),
                new SequenceGUI(50, 200)
        ));
    }

    @Override
    public void show() {
        super.show();
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyUp(int keycode) {
                if (keycode == Input.Keys.ESCAPE) Gdx.app.exit();
                return true;
            }
        });
    }
}
