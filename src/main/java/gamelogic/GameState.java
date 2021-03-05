package main.java.gamelogic;

import main.java.misc.Cell;
import main.java.misc.Direction;

import java.util.List;
import java.util.Stack;

public class GameState {
    public Cell selector;
    public final GameLevel gameLevel;
    public final Stack<Cell> buffer = new Stack<>();
    private final Stack<Cell> undoStack = new Stack<>();

    private static final int maxOffset = 2;
    private int offsetBufferSize = 0;
    public final TimerLogic timerLogic;

    public GameState(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
        selector = new Cell(0, 0);
        timerLogic = new TimerLogic(10);
    }

    public void undo() {
        if (!buffer.isEmpty()) {
            undoStack.push(buffer.pop());
            selector = undoStack.peek();
        }
    }

    public void redo() {
        if (!undoStack.isEmpty()) {
            buffer.push(undoStack.pop());
            selector = buffer.peek();
        }
    }

    public int getCurrentBufferSize() {
        return gameLevel.bufferLength + offsetBufferSize;
    }

    public void increaseBufferLength() {
        if (offsetBufferSize < maxOffset && !timerLogic.hasStarted())
            offsetBufferSize++;
    }

    public void decreaseBufferLength() {
        if (offsetBufferSize > -maxOffset && !timerLogic.hasStarted())
            offsetBufferSize--;
    }

    public void move(Direction dir) {
        if (isValidMove(dir)) selector = selector.applyDir(dir);
    }

    public void confirmSelector() {
        if (!timerLogic.hasStarted()) timerLogic.start();
        if (buffer.size() == gameLevel.bufferLength) return;
        undoStack.clear();
        buffer.push(selector);
    }

    private boolean isValidMove(Direction dir) {
        Cell nextCell = selector.applyDir(dir);
        return nextCell.x < gameLevel.matrixSize &&
                nextCell.y < gameLevel.matrixSize &&
                nextCell.x >= 0 &&
                nextCell.y >= 0 &&
                (buffer.size() % 2 == 0) == (dir == Direction.RIGHT || dir == Direction.LEFT);
    }

    public boolean isSequenceCompleted(List<String> seq) {
        if (!buffer.isEmpty()) {
            String bufferString = buffer.stream().map(cl -> gameLevel.matrix.get(cl) + " ").reduce("", String::concat);
            return bufferString.contains(String.join(" ", seq));
        }
        return false;
    }

    public int getScore() {
        int numOfCompletedSeqs = (int) gameLevel.solutions.stream().filter(this::isSequenceCompleted).count();
        int factorial = 1;
        for (int i = 1; i <= numOfCompletedSeqs; i++) {
            factorial = factorial * i;
        }
        return (int) Math.round(factorial * 30.0 * numOfCompletedSeqs * gameLevel.bufferLength *
                (gameLevel.bufferLength - buffer.size() + 1) / 10.0);
    }

    //TODO: Yingdi Assignment 3 implement isSequenceFailed to support highlighting failed sequences
    public boolean isSequenceFailed(List<String> seq) {
        return false;
    }

}
