package main.java.gamelogic;

import main.java.commands.UndoRedoCommand;
import main.java.misc.Cell;
import main.java.misc.Timer;

import java.util.Stack;

public class GameState {
    private final GameLevel gameLevel;
    private final Timer timer = new Timer(10);
    private final Buffer buffer = new Buffer(this);
    private final Stack<UndoRedoCommand> commandFuture = new Stack<>();
    private final Stack<UndoRedoCommand> commandHistory = new Stack<>();
    private Cell selector = new Cell(0, 0);

    public GameState(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
    }

    public boolean isGameOver() {
        return timer.hasExpired() || timer.hasStopped();
    }

    public Buffer getBuf() {
        return buffer;
    }

    public Timer getTimer() {
        return timer;
    }

    public Cell getSelector() {
        return selector;
    }

    public void setSelector(Cell newPos) {
        selector = newPos;
    }

    public GameLevel getLevel() {
        return gameLevel;
    }

    public Stack<UndoRedoCommand> getCommandFuture() {
        return commandFuture;
    }

    public Stack<UndoRedoCommand> getCommandHistory() {
        return commandHistory;
    }
}
