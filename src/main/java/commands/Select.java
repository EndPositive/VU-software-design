package main.java.commands;

import main.java.gamelogic.GameState;
import main.java.misc.Cell;

public class Select extends Command {
    private Select prev;
    private Select next;
    private Cell selected;

    public Move() {
    }

    protected boolean execute(GameState gameState) {
        if (selected != null) {
            gameState.selector = selected;
            return true;
        }

        if (!gameState.timerLogic.hasStarted()) gameState.timerLogic.start();
        if (gameState.buffer.size() == gameState.gameLevel.bufferLength) return false;

        selected = gameState.selector;
        gameState.buffer.push(gameState.selector);
        selected = gam
        return true;
    }

    protected void undo(GameState gameState) {

    }
}
