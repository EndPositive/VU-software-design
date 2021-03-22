package main.java.commands;

import main.java.gamelogic.GameState;

public class Undo extends Command {
    protected boolean execute(GameState gameState) {
        if (gameState.commandStack.isEmpty()) return false;
        gameState.commandStack.pop().tryUndo(gameState);
        return true;
    }
}
