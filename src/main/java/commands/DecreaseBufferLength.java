package main.java.commands;

import main.java.gamelogic.GameState;

import static main.java.gamelogic.BufferLogic.MAX_OFFSET;

public class DecreaseBufferLength extends Command {

    protected boolean execute(GameState gameState) {
        if (gameState.offsetBufferLength > -MAX_OFFSET && !gameState.timerLogic.hasStarted()) {
            gameState.offsetBufferLength--;
            return true;
        }

        return false;
    }

}
