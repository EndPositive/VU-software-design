package main.java.gamelogic;

import main.java.misc.Cell;
import main.java.misc.Direction;

import java.util.List;
import java.util.Stack;

public class GameState {
    public Cell selector;
    public final GameLevel gameLevel;
    public final Stack<List<Cell>> gameFrames = new Stack<>();
    private final Stack<List<Cell>> undoFrames = new Stack<>();

    public GameState(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
        selector = new Cell(0, 0);
    }

    public void undo() {
    }

    public void redo() {
    }

    public void move(Direction dir) {
    }

    public void confirmSelector() {
    }

    //TODO: Implement me
    private boolean isValidMove(Direction dir) {
        return false;
    }

    //TODO: Implement me
    public boolean isSequenceCompleted(String[] seq) {
        return false;
    }

    public int getScore() {
        return 0;
    }

}
