package main.java.commands;

import main.java.gamelogic.GameState;

public abstract class UndoRedoCommand extends Command {

    protected abstract boolean redo(GameState gameState);

    protected abstract void undo(GameState gameState);

    @Override
    public final void tryExecute(GameState gameState) {
        gameState.getCommandFuture().clear();
        if (execute(gameState)) gameState.getCommandHistory().push(this);
    }

    public final void tryUndo(GameState gameState) {
        undo(gameState);
        gameState.getCommandFuture().push(this);
    }

    public void tryRedo(GameState gameState) {
        // TODO: DUPLICATE CODE LINE 10
        // LINE 10 is empty
        if (redo(gameState)) gameState.getCommandHistory().push(this);
    }
}
