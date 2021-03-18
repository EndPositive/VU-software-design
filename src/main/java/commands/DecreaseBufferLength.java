package main.java.commands;

import main.java.gamelogic.GameState;

import static main.java.gamelogic.GameState.MAX_OFFSET;

public class DecreaseBufferLength extends Command {

    public DecreaseBufferLength() {
        super(false);
    }

    protected boolean execute(GameState gameState) {
        if (gameState.offsetBufferLength > -MAX_OFFSET && !gameState.timerLogic.hasStarted()) {
            gameState.offsetBufferLength--;
            return true;
        }
        return false;
    }

    protected void undo(GameState gameState) {

    }
}
