package main.java.commands;

import main.java.gamelogic.BufferLogic;
import main.java.gamelogic.GameState;
import main.java.misc.Cell;

public class Select extends UndoableCommand {
    public Cell selected;

    protected boolean execute(GameState gameState) {
        if (!gameState.timerLogic.hasStarted()) gameState.timerLogic.start();
        if (BufferLogic.getBuffer(gameState).size() == BufferLogic.getMaxBufferLength(gameState)) return false;

        if (selected != null) gameState.selector = selected;
        selected = gameState.selector;
        return true;
    }

    protected void undo(GameState gameState) {
        gameState.selector = selected;
    }
}
