package main.java.gui;

import main.java.gamelogic.GameState;

public class TutorialGUI extends GUIElement {
    public TutorialGUI(float x, float y) {
        super(x, y);
    }

    @Override
    public void render(GameState gameState) {
        batch.begin();

        font.draw(batch, "Spacebar      select a cell", x, y);
        font.draw(batch, "Enter             submit sequence", x, y - 20);
        font.draw(batch, "Backspace    delete most recent cell", x, y - 40);
        font.draw(batch, "r                    redo most recently deleted cell", x, y - 60);
        font.draw(batch, "=                   increase buffer length (only at the start of a game)", x, y - 80);
        font.draw(batch, "-                    decrease buffer length (only at the start of a game)", x, y - 100);

        batch.end();
    }
}
