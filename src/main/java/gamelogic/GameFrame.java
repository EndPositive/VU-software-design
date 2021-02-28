package main.java.gamelogic;

import main.java.misc.Cell;
import main.java.misc.Direction;

import java.util.List;

public class GameFrame {
    public final List<Cell> buffer;
    private final Cell selector;

    public GameFrame(List<Cell> buffer, Cell selector) {
        this.buffer = buffer;
        this.selector = selector;
    }

    //TODO: Implement me
    public boolean isValidMove(Direction dir) {
        return false;
    }

    //TODO: Implement me
    public GameFrame move(Direction dir) {
        return null;
    }

    //TODO: Implement me
    public boolean isSequenceCompleted(String[] seq) {
        return false;
    }
}
