package main.java.commands;

import main.java.gamelogic.GameState;
import main.java.misc.Cell;
import main.java.misc.Direction;

public class Move extends Command {
    private final Direction dir;

    public Move(Direction direction) {
        dir = direction;
    }

    protected boolean execute(GameState gameState) {
        if (!isValidMove(gameState)) return false;

        gameState.selector = gameState.selector.applyDir(dir);
        return true;
    }

    private boolean isValidMove(GameState gameState) {
        Cell nextCell = gameState.selector.applyDir(dir);
        return nextCell.x < gameState.gameLevel.getMatrixSize() &&
                nextCell.y < gameState.gameLevel.getMatrixSize() &&
                nextCell.x >= 0 &&
                nextCell.y >= 0 &&
                (gameState.buffer.size() % 2 == 0) == (dir == Direction.RIGHT || dir == Direction.LEFT);
    }

}
