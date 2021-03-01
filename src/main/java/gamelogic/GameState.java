package main.java.gamelogic;

import main.java.misc.Cell;
import main.java.misc.Direction;

import java.util.List;
import java.util.Stack;

public class GameState {
    public Cell selector;
    public final GameLevel gameLevel;
    public final Stack<Cell> buffer = new Stack<>();
    private final Stack<Cell> undoStack = new Stack<>();

    public GameState(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
        selector = new Cell(0, 0);
    }

    public void undo() {
        if (!buffer.isEmpty()) {
            undoStack.push(buffer.pop());
            selector = undoStack.peek();
        }
    }

    public void redo() {
        if (!undoStack.isEmpty()) {
            buffer.push(undoStack.pop());
            selector = undoStack.peek();
        }
    }

    public void move(Direction dir) {
        if (isValidMove(dir)) selector = selector.applyDir(dir);
    }

    // TODO: Tibi (Add selector to current path (gameFrames.top) & push it the gameFrames stack & check if buffer is already full in which case just return)
    // You need to clear the undoFrames after each confirmSelector, because it doesn't make sense to be able to redo something after doing something new
    public void confirmSelector() {
        undoStack.clear();
        buffer.push(selector);
    }

    private boolean isValidMove(Direction dir) {
        Cell nextCell = selector.applyDir(dir);
        return nextCell.x < gameLevel.matrixSize &&
                nextCell.y < gameLevel.matrixSize &&
                nextCell.x >= 0 &&
                nextCell.y >= 0 &&
                (buffer.size() % 2 == 0) == (dir == Direction.RIGHT || dir == Direction.LEFT);
    }

    // TODO: Yingdi Assignment 3
    public boolean isSequenceCompleted(List<String> seq) {
        return false;
    }

    // TODO: Yingdi Assignment 3
    public int getScore() {
        return 0;
    }

}
