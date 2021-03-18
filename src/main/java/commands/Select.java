package main.java.commands;

import main.java.gamelogic.GameState;
import main.java.misc.Cell;

public class Select extends Command {
    private Cell lastSelector;

    public Select() {
        super(true);
    }

    protected boolean execute(GameState gameState) {
        if (!gameState.timerLogic.hasStarted()) gameState.timerLogic.start();
        if (gameState.buffer.size() == gameState.getCurrentBufferLength()) return false;

        gameState.buffer.push(gameState.selector);
        lastSelector = gameState.selector;
        return true;
    }

    protected void undo(GameState gameState) {
        gameState.buffer.pop();
        gameState.selector = lastSelector;
    }
}
