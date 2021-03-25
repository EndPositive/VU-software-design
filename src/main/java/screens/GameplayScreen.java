package main.java.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import main.java.commands.Command;
import main.java.commands.CommandFactory;
import main.java.gamelogic.GameLevel;
import main.java.gamelogic.GameState;
import main.java.gui.*;

import java.util.Arrays;

public class GameplayScreen extends GameScreen {

    public GameplayScreen(Game game, GameLevel gameLevel) {
        super(game, new GameState(gameLevel), Arrays.asList(
                new GridGUI(20, 300),
                new SequenceGUI(220, 300),
                new BufferGUI(220, 330),
                new TimerGUI(20, 330),
                new TutorialGUI(20, 120)
        ));
    }

    public InputAdapter getInputProcessor() {
        return new InputAdapter() {
            @Override
            public boolean keyUp(int keycode) {
                if (keycode == Keys.ESCAPE) {
                    Gdx.app.exit();
                    return true;
                }

                Command command = CommandFactory.createCommand(keycode);
                if (command != null) {
                    command.tryExecute(gameState);
                    return true;
                }

                return false;
            }
        };
    }

    public void renderCallback() {
        if (gameState.isGameOver()) {
            game.setScreen(new GameOverScreen(game, gameState));
        }
    }
}
