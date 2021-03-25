package main.java.commands;

import main.java.gamelogic.GameState;
import main.java.misc.Cell;

public class Select extends UndoRedoCommand {
    private Cell selected;

    public Cell getSelected() {
        return selected;
    }

    protected boolean execute(GameState gameState) {
        if (!gameState.getTimer().hasStarted()) gameState.getTimer().start();
        if (gameState.getBuf().isFull()) return false;
        selected = gameState.getSelector();
        return true;
    }

    protected void undo(GameState gameState) {
        gameState.setSelector(selected);
    }

    protected boolean redo(GameState gameState) {
        if (gameState.getBuf().isFull()) return false;
        gameState.setSelector(selected);
        return true;
    }
}
