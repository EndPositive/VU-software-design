package main.java.gamelogic;

import main.java.commands.Select;
import main.java.misc.Cell;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Buffer {
    public static final int MAX_OFFSET = 2;
    public int offset = 0;
    private final GameState gameState;

    public Buffer(GameState gameState) {
        this.gameState = gameState;
    }

    public int size() {
        return parseBuffer().size();
    }

    public Cell get(int i) {
        return parseBuffer().get(i);
    }

    public boolean isEmpty() {
        return parseBuffer().isEmpty();
    }

    public Stream<Cell> stream() {
        return parseBuffer().stream();
    }

    public int getMaxBufferLength() {
        return gameState.getLevel().getBufferLength() + offset;
    }

    public boolean isFull() {
        return size() == getMaxBufferLength();
    }

    private List<Cell> parseBuffer() {
        return gameState.getCommandHistory().stream()
                .filter(el -> el instanceof Select)
                .map(Select.class::cast)
                .map(Select::getSelected)
                .collect(Collectors.toList());
    }
}
