package main.java.gamelogic;

import main.java.commands.UndoRedoCommand;
import main.java.misc.Cell;

import java.util.ArrayDeque;
import java.util.Deque;

public class GameState {
    public Cell selector;
    public final GameLevel gameLevel;
    public final TimerLogic timerLogic;
    public final Deque<UndoRedoCommand> commandStack = new ArrayDeque<>();
    public final Deque<UndoRedoCommand> redoCommandStack = new ArrayDeque<>();
    public final Buffer buffer;

    public GameState(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
        selector = new Cell(0, 0);
        timerLogic = new TimerLogic(10);
        buffer = new Buffer(this);
    }

    public boolean isGameOver() {
        return timerLogic.hasExpired() || timerLogic.hasStopped();
    }

}
