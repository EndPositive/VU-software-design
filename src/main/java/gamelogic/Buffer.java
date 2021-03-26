package main.java.gamelogic;

import main.java.commands.Select;

import java.util.List;
import java.util.stream.Collectors;

public class Buffer {
    public static final int MAX_OFFSET = 2;
    private int offset = 0;
    private final GameState gameState;

    public Buffer(GameState gameState) {
        this.gameState = gameState;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        if (gameState.timer.hasStarted() || offset > MAX_OFFSET || offset < -MAX_OFFSET) return;

        this.offset = offset;
    }

    public int size() {
        return toList().size();
    }

    public String get(int i) {
        return toList().get(i);
    }

    public boolean isEmpty() {
        return toList().isEmpty();
    }

    public int getMaxBufferLength() {
        return gameState.gameLevel.getBufferLength() + offset;
    }

    public boolean isFull() {
        return size() == getMaxBufferLength();
    }

    public List<String> toList() {
        return gameState.commandHistory.stream()
                .filter(el -> el instanceof Select)
                .map(Select.class::cast)
                .map(Select::getSelected)
                .map(gameState.gameLevel.getMatrix()::get)
                .collect(Collectors.toList());
    }
}
