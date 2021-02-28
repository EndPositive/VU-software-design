package main.java.gamelogic;

import main.java.misc.Axis;
import main.java.misc.Cell;

import java.util.List;

public class GameFrame {
    public List<Cell> buffer;
    public Axis axis; // Currently allowed axis to move in

    public GameFrame(List<Cell> buffer, Axis axis) {
        this.buffer = buffer;
        this.axis = axis;
    }
}
