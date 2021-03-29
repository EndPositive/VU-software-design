package main.java.commands;

import main.java.gamelogic.GameState;

public abstract class UndoRedoCommand extends Command {

    protected abstract boolean redo(GameState gameState);

    protected abstract void undo(GameState gameState);

    @Override
    public final void tryExecute(GameState gameState) {
        gameState.commandFuture.clear();
        if (execute(gameState)) gameState.commandHistory.push(this);
    }

    public final void tryUndo(GameState gameState) {
        undo(gameState);
        gameState.commandFuture.push(this);
    }

    public void tryRedo(GameState gameState) {
        if (redo(gameState)) gameState.commandHistory.push(this);
    }
}
