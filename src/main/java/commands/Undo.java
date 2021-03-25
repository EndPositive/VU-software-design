package main.java.commands;

import main.java.gamelogic.GameState;

public class Undo extends Command {
    protected boolean execute(GameState gameState) {
        if (gameState.getCommandHistory().isEmpty()) return false;
        gameState.getCommandHistory().pop().tryUndo(gameState);
        return true;
    }
}
