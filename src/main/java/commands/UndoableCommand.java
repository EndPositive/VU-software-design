package main.java.commands;

import main.java.gamelogic.GameState;

public abstract class UndoableCommand extends Command {
    protected boolean executed = false;

    public boolean tryExecute(GameState gameState) {
        if (!executed) {
            gameState.redoCommandStack.clear();
        }

        executed = execute(gameState);

        if (executed) {
            gameState.commandStack.push(this);
        }

        return executed;
    }

    public void tryUndo(GameState gameState) {
        if (!executed) return; // todo: maybe remove
        undo(gameState);

        gameState.redoCommandStack.push(this);
    }

    abstract protected void undo(GameState gameState);

}
