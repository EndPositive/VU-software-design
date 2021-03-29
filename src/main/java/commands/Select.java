package main.java.commands;

import main.java.gamelogic.GameState;
import main.java.misc.Cell;

public class Select extends UndoRedoCommand {
    private Cell selected;

    public Cell getSelected() {
        return selected;
    }

    protected boolean execute(GameState gameState) {
        if (!gameState.timer.hasStarted()) gameState.timer.start();
        if (gameState.buffer.isFull()) return false;
        selected = gameState.selector;
        return true;
    }

    protected void undo(GameState gameState) {
        gameState.selector = selected;
    }

    protected boolean redo(GameState gameState) {
        if (gameState.buffer.isFull()) return false;
        gameState.selector = selected;
        return true;
    }
}
