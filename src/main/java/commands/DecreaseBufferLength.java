package main.java.commands;

import main.java.gamelogic.GameState;

import static main.java.gamelogic.Buffer.MAX_OFFSET;

public class DecreaseBufferLength extends Command {

    protected boolean execute(GameState gameState) {
        if (gameState.getBuf().offset > -MAX_OFFSET && !gameState.getTimer().hasStarted()) {
            gameState.getBuf().offset--;
            return true;
        }

        return false;
    }

}
