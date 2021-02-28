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

    // TODO: Jop
    public void undo() {
    }

    // TODO: Jop
    public void redo() {
    }

    // TODO: Yingdi (Move selector to the direction dir there is a function called applyDir in Cell you can use; maybe implement isValidMove first)
    public void move(Direction dir) {
    }

    // TODO: Tibi (Add selector to current path (gameFrames.top) & push it the gameFrames stack & check if buffer is already full in which case just return)
    public void confirmSelector() {
    }

    // TODO: Yingdi
    private boolean isValidMove(Direction dir) {
        return false;
    }

    // TODO: Yingdi Assignment 3
    public boolean isSequenceCompleted(String[] seq) {
        return false;
    }

    // TODO: Yingdi Assignment 3
    public int getScore() {
        return 0;
    }

}
