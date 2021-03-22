package main.java.gamelogic;

import main.java.commands.Select;
import main.java.misc.Cell;

import java.util.List;
import java.util.stream.Collectors;

public class BufferLogic {
    public static final int MAX_OFFSET = 2;

    private BufferLogic() {
    }

    public static List<Cell> getBuffer(GameState gameState) {
        return gameState.getSelectCommands().stream()
                .map(Select::getSelected)
                .collect(Collectors.toList());
    }

    public static List<String> getBufferAsString(GameState gameState) {
        return BufferLogic.getBuffer(gameState).stream()
                .map(gameState.gameLevel.matrix::get)
                .collect(Collectors.toList());
    }

    public static int getMaxBufferLength(GameState gameState) {
        return gameState.gameLevel.bufferLength + gameState.offsetBufferLength;
    }

    public static boolean isBufferFull(GameState gameState) {
        return getBuffer(gameState).size() == getMaxBufferLength(gameState);
    }
}
