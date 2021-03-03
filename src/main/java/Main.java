package main.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main (String[] arg) {
        if (arg.length < 1) {
            System.err.println("No input file given");
            System.exit(-1);
        }

        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.height = 350;
        config.title = "Breach Protocol";
        config.resizable = false;
        new LwjglApplication(new BreachGame(arg[0]), config);
    }
}
