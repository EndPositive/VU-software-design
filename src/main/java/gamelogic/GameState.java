package main.java.gamelogic;

import main.java.commands.Select;
import main.java.commands.UndoRedoCommand;
import main.java.misc.Cell;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class GameState {
    public Cell selector;
    public final GameLevel gameLevel;
    public final TimerLogic timerLogic;
    public final Deque<UndoRedoCommand> commandStack = new ArrayDeque<>();
    public final Deque<UndoRedoCommand> redoCommandStack = new ArrayDeque<>();

    public int offsetBufferLength = 0;

    public GameState(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
        selector = new Cell(0, 0);
        timerLogic = new TimerLogic(10);
    }

    public List<Select> getSelectCommands() {
        return commandStack.stream()
                .filter(el -> el instanceof Select)
                .map(Select.class::cast)
                .collect(Collectors.toList());
    }

    public boolean isGameOver() {
        return timerLogic.hasExpired() || timerLogic.hasStopped();
    }

}
