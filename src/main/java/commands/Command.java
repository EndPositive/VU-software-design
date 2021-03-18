package main.java.commands;

import main.java.gamelogic.GameState;

abstract public class Command {

    private boolean executed = false;
    private final boolean allowUndoRedo;

    public Command(boolean allowUndoRedo) {
        this.allowUndoRedo = allowUndoRedo;
    }

    public void tryExecute(GameState gameState) {
        if (executed) return;
        executed = execute(gameState);

        if (allowUndoRedo) gameState.commandStack.push(this);
    }

    abstract protected boolean execute(GameState gameState);

    public void tryUndo(GameState gameState) {
        if (!executed) return;
        undo(gameState);
        executed = false;
    }

    abstract protected void undo(GameState gameState);
}
