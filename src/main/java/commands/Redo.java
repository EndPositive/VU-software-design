package main.java.commands;

import main.java.gamelogic.GameState;

public class Redo extends Command {
    protected boolean execute(GameState gameState) {
        if (gameState.redoCommandStack.isEmpty()) return false;
        gameState.redoCommandStack.pop().tryRedo(gameState);
        return true;
    }
}
