package main.java.gamelogic;

import main.java.commands.UndoRedoCommand;
import main.java.misc.Cell;
import main.java.misc.Timer;

import java.util.Stack;

public class GameState {
    public final GameLevel gameLevel;
    public final Timer timer = new Timer(10);
    public final Buffer buffer = new Buffer(this);
    public final Stack<UndoRedoCommand> commandFuture = new Stack<>();
    public final Stack<UndoRedoCommand> commandHistory = new Stack<>();
    public Cell selector = new Cell(0, 0);

    public GameState(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
    }

    public boolean isGameOver() {
        return timer.hasExpired() || timer.hasStopped();
    }
}
