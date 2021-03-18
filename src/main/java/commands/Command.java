package main.java.commands;

import main.java.gamelogic.GameState;

abstract public class Command {

    private boolean executed = false;

    public void tryExecute(GameState gameState) {
        if (executed) return;
        executed = execute(gameState);
    }

    abstract protected boolean execute(GameState gameState);

    public void tryUndo(GameState gameState) {
        if (!executed) return;
        undo(gameState);
        executed = false;
    }

    abstract protected void undo(GameState gameState);
}
