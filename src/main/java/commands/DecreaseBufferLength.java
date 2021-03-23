package main.java.commands;

import main.java.gamelogic.GameState;

import static main.java.gamelogic.Buffer.MAX_OFFSET;

public class DecreaseBufferLength extends Command {

    protected boolean execute(GameState gameState) {
        if (gameState.buffer.offset > -MAX_OFFSET && !gameState.timer.hasStarted()) {
            gameState.buffer.offset--;
            return true;
        }

        return false;
    }

}
