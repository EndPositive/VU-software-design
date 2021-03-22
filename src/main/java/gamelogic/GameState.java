package main.java.gamelogic;

import main.java.commands.UndoRedoCommand;
import main.java.misc.Cell;

import java.util.ArrayDeque;
import java.util.Deque;

public class GameState {
    public Cell selector = new Cell(0, 0);
    public final GameLevel gameLevel;
    public final TimerLogic timerLogic;
    public final Deque<UndoRedoCommand> commandStack = new ArrayDeque<>();
    public final Deque<UndoRedoCommand> redoCommandStack = new ArrayDeque<>();
    public final Buffer buffer = new Buffer(this);

    public GameState(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
        timerLogic = new TimerLogic(10);
    }

    public boolean isGameOver() {
        return timerLogic.hasExpired() || timerLogic.hasStopped();
    }

}
