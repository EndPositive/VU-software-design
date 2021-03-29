package main.java.gui;

import main.java.gamelogic.GameState;

public class TutorialGUI extends GUIElement {
    public TutorialGUI(float x, float y) {
        super(x, y);
    }

    @Override
    public void render(GameState gameState) {
        batch.begin();

        /*
         * The spaces look ridiculous here because the kerning between the letters is weird in-game,
         * so they are different here in order to compensate
         */
        font.draw(batch,
                "Spacebar        select a cell\n" +
                        "Enter               submit sequence\n" +
                        "Backspace      delete most recent cell\n" +
                        "r                      redo most recently deleted cell\n" +
                        "=                     increase buffer length (only at the start of a game)\n" +
                        "-                      decrease buffer length (only at the start of a game)",
                x, y);

        batch.end();
    }
}
