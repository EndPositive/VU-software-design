package main.java.gamelogic;

import main.java.misc.Cell;
import main.java.misc.Direction;

import java.util.List;

public class GameFrame {
    public final List<Cell> buffer;
    private final int matrixSize;

    public GameFrame(List<Cell> buffer, int size) {
        this.buffer = buffer;
        this.matrixSize = size;
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
