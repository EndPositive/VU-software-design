package main.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import main.java.gamelogic.GameLevel;

import java.io.FileNotFoundException;

public class Main {
	public static void main (String[] arg) {
        if (arg.length < 1) {
            System.err.println("No input file given");
            System.exit(-1);
        }

        GameLevel gameLevel;

        try {
            gameLevel = new GameLevel(arg[0]);
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            return;
        }

        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new BreachGame(), config);
    }
}
