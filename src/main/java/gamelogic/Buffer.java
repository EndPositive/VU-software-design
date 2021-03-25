package main.java.gamelogic;

import main.java.commands.Select;

import java.util.List;
import java.util.stream.Collectors;

public class Buffer {
    public static final int MAX_OFFSET = 2;
    public int offset = 0;
    private final GameState gameState;

    public Buffer(GameState gameState) {
        this.gameState = gameState;
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
        return gameState.getLevel().getBufferLength() + offset;
    }

    public boolean isFull() {
        return size() == getMaxBufferLength();
    }

    public List<String> toList() {
        return gameState.getCommandHistory().stream()
                .filter(el -> el instanceof Select)
                .map(Select.class::cast)
                .map(Select::getSelected)
                .map(gameState.getLevel().getMatrix()::get)
                .collect(Collectors.toList());
    }
}
