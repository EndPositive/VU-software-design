package main.java.commands;

import main.java.gamelogic.GameState;

public class Redo extends Command {
    protected boolean execute(GameState gameState) {
        if (gameState.commandFuture.isEmpty()) return false;
        gameState.commandFuture.pop().tryRedo(gameState);
        return true;
    }
}
