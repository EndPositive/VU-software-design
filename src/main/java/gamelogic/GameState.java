package main.java.gamelogic;

import main.java.misc.Cell;
import main.java.misc.Direction;

import java.util.Stack;

public class GameState {
    public Cell selector;
    public final GameLevel gameLevel;
    public final Stack<GameFrame> gameFrames = new Stack<>();
    private final Stack<GameFrame> undoFrames = new Stack<>();

    public GameState(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
        selector = new Cell(0, 0);
    }

    public void undo() {
        if (gameFrames.empty()) return;
        undoFrames.push(gameFrames.pop());
    }

    public void redo() {
        if (undoFrames.empty()) return;
        gameFrames.push(undoFrames.pop());
    }

    // TODO: Yingdi (Move selector to the direction dir there is a function called applyDir in Cell you can use; maybe implement isValidMove first)
    public void move(Direction dir) {
    }

    // TODO: Tibi (Add selector to current path (gameFrames.top) & push it the gameFrames stack & check if buffer is already full in which case just return)
    // You need to clear the undoFrames after each confirmSelector, because it doesn't make sense to be able to redo something after doing something new
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
