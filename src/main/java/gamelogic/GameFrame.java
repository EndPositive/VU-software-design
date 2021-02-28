package main.java.gamelogic;

import main.java.misc.Cell;
import main.java.misc.Direction;

import java.util.List;

public class GameFrame {
    private final List<Cell> path;
    private final Cell selector;

    public GameFrame(List<Cell> path, Cell selector) {
        this.path = path;
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
