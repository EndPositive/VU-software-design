package main.java.gamelogic;

import main.java.misc.Cell;
import main.java.misc.Direction;

import java.util.Stack;

public class GameState {
    public Cell selector;
    public final GameLevel gameLevel;
    public final TimerLogic timerLogic;
    public final Stack<Cell> buffer = new Stack<>();
    private final Stack<Cell> undoStack = new Stack<>();

    private static final int MAX_OFFSET = 2;
    public int offsetBufferLength = 0;

    public GameState(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
        selector = new Cell(0, 0);
        timerLogic = new TimerLogic(10);
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
            selector = buffer.peek();
        }
    }

    public int getCurrentBufferLength() {
        return gameLevel.bufferLength + offsetBufferLength;
    }

    public void increaseBufferLength() {
        if (offsetBufferLength < MAX_OFFSET && !timerLogic.hasStarted())
            offsetBufferLength++;
    }

    public void decreaseBufferLength() {
        if (offsetBufferLength > -MAX_OFFSET && !timerLogic.hasStarted())
            offsetBufferLength--;
    }
}
