package main.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Launcher {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("No input file given");
            System.exit(-1);
        }

        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.height = 350;
        config.title = "Breach Protocol";
        config.resizable = false;

        try {
            new LwjglApplication(new BreachGame(args[0]), config);
        } catch (Exception e) {
            System.err.println(e.toString());
            System.exit(-1);
        }
    }
}
