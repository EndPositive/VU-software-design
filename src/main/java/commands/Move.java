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

        gameState.setSelector(gameState.getSelector().applyDir(dir));
        return true;
    }

    private boolean isValidMove(GameState gameState) {
        Cell nextCell = gameState.getSelector().applyDir(dir);
        return nextCell.x < gameState.getLevel().getMatrixSize() &&
                nextCell.y < gameState.getLevel().getMatrixSize() &&
                nextCell.x >= 0 &&
                nextCell.y >= 0 &&
                (gameState.getBuf().size() % 2 == 0) == (dir == Direction.RIGHT || dir == Direction.LEFT);
    }

}
