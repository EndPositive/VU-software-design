package main.java.commands;

import main.java.gamelogic.GameState;

public class DecreaseBufferLength extends Command {

    protected boolean execute(GameState gameState) {
        gameState.buffer.setOffset(gameState.buffer.getOffset() - 1);
        return true;
    }

}
