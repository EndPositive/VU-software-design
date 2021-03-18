package main.java.gamelogic;

import main.java.commands.Command;
import main.java.misc.Cell;

import java.util.Stack;

public class GameState {
    public Cell selector;
    public final GameLevel gameLevel;
    public final TimerLogic timerLogic;
    public final Stack<Cell> buffer = new Stack<>();
    public final Stack<Command> commandStack = new Stack<>();
    public final Stack<Command> undoCommandStack = new Stack<>();

    private static final int MAX_OFFSET = 2;
    public int offsetBufferLength = 0;

    public GameState(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
        selector = new Cell(0, 0);
        timerLogic = new TimerLogic(10);
    }

    public void tryUndo() {
        if (commandStack.isEmpty()) return;
        commandStack.pop().tryUndo(this);
    }

    public void tryRedo() {
        if (undoCommandStack.isEmpty()) return;
        undoCommandStack.pop().tryExecute(this);
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
