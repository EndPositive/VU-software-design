package main.java.commands;

import main.java.gamelogic.GameState;

public abstract class UndoRedoCommand extends Command {

    abstract protected boolean redo(GameState gameState);

    abstract protected void undo(GameState gameState);

    public final void tryExecute(GameState gameState) {
        gameState.redoCommandStack.clear();
        if (execute(gameState)) gameState.commandStack.push(this);
    }

    public final void tryUndo(GameState gameState) {
        undo(gameState);
        gameState.redoCommandStack.push(this);
    }

    public void tryRedo(GameState gameState) {
        // TODO: DUPLICATE CODE LINE 10
        if (redo(gameState)) gameState.commandStack.push(this);
    }
}
