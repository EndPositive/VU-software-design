package main.java.gamelogic;

import main.java.misc.Cell;

import java.util.Stack;

public class GameState {
    private Cell selector;
    public final GameLevel gameLevel;
    public final Stack<GameFrame> gameFrames = new Stack<>();
    private final Stack<GameFrame> undoFrames = new Stack<>();

    public GameState(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
    }

    public void undo() {
    }

    public void redo() {
    }

    public void move() {
    }
}
