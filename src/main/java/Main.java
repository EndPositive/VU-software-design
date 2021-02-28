package main.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import main.java.gamelogic.GameLevel;
import main.java.screens.BreachGame;

import java.io.FileNotFoundException;

public class Main {
	public static void main (String[] arg) {
        //Cell cell = new Cell(1,1);
        GameLevel gameLevel;

        try {
            gameLevel = new GameLevel();
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            return;
        }


        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new BreachGame(), config);
    }
}
