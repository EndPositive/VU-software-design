package main.java.commands;

import main.java.gamelogic.GameState;

public class Redo extends Command {
    protected boolean execute(GameState gameState) {
        if (gameState.getCommandFuture().isEmpty()) return false;
        gameState.getCommandFuture().pop().tryRedo(gameState);
        return true;
    }
}
