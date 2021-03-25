package main.java.commands;

import main.java.gamelogic.GameState;

public class Undo extends Command {
    protected boolean execute(GameState gameState) {
        if (gameState.commandHistory.isEmpty()) return false;
        gameState.commandHistory.pop().tryUndo(gameState);
        return true;
    }
}
