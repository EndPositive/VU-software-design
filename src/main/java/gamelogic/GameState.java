package main.java.gamelogic;

import main.java.commands.Select;
import main.java.commands.UndoRedoCommand;
import main.java.misc.Cell;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class GameState {
    public Cell selector;
    public final GameLevel gameLevel;
    public final TimerLogic timerLogic;
    public final Stack<UndoRedoCommand> commandStack = new Stack<>();
    public final Stack<UndoRedoCommand> redoCommandStack = new Stack<>();

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
        redoCommandStack.pop().tryRedo(this);
    }

    public List<Select> getSelectCommands() {
        return commandStack.stream()
                .filter(el -> el instanceof Select)
                .map(el -> ((Select) el))
                .collect(Collectors.toList());
    }

}
