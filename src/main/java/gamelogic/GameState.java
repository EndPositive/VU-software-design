package main.java.gamelogic;

import main.java.commands.Select;
import main.java.commands.UndoableCommand;
import main.java.misc.Cell;

import java.util.Stack;
import java.util.List;
import java.util.stream.Collectors;

public class GameState {
    public Cell selector;
    public final GameLevel gameLevel;
    public final TimerLogic timerLogic;
    public final Stack<UndoableCommand> commandStack = new Stack<>();
    public final Stack<UndoableCommand> redoCommandStack = new Stack<>();

    public static final int MAX_OFFSET = 2;
    public int offsetBufferLength = 0;

    public GameState(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
        selector = new Cell(0, 0);
        timerLogic = new TimerLogic(1000);
    }

    public void tryUndo() {
        if (commandStack.isEmpty()) return;
        commandStack.pop().tryUndo(this);
    }

    public void tryRedo() {
        if (redoCommandStack.isEmpty()) return;
        redoCommandStack.pop().tryExecute(this);
    }

    public List<Cell> getBuffer() {
        return commandStack.stream()
                .filter(el -> el instanceof Select)
                .map(el -> ((Select) el).selected)
                .collect(Collectors.toList());
    }

    public int getCurrentBufferLength() {
        return gameLevel.bufferLength + offsetBufferLength;
    }

}
