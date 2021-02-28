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
    }

    public void redo() {
    }

    public void move(Direction dir) {
    }
}
