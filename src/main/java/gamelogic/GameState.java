package main.java.gamelogic;

import main.java.misc.Cell;
import main.java.misc.Direction;

import java.util.List;
import java.util.Stack;

public class GameState {
    public Cell selector;
    public final GameLevel gameLevel;
    public final TimerLogic timerLogic;
    public final Stack<Cell> buffer = new Stack<>();
    private final Stack<Cell> undoStack = new Stack<>();

    private static final int maxOffset = 2;
    private int offsetBufferLength = 0;

    private int finalScore = 0;

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

    public int getCurrentBufferLength() {
        return gameLevel.bufferLength + offsetBufferLength;
    }

    public void increaseBufferLength() {
        if (offsetBufferLength < maxOffset && !timerLogic.hasStarted())
            offsetBufferLength++;
    }

    public void decreaseBufferLength() {
        if (offsetBufferLength > -maxOffset && !timerLogic.hasStarted())
            offsetBufferLength--;
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

    public void setScore() {
        int numOfCompletedSeqs = (int) gameLevel.solutions.stream().filter(this::isSequenceCompleted).count();
        int factorial = 1;
        for (int i = 1; i <= numOfCompletedSeqs; i++) {
            factorial = factorial * i;
        }

        finalScore = Math.round(factorial * (timerLogic.timeLeft() + 1) * numOfCompletedSeqs *
                gameLevel.bufferLength * (gameLevel.bufferLength - offsetBufferLength * 2)) / 10;
    }

    public int getScore() {
        return finalScore;
    }

    //TODO: Yingdi Assignment 3 implement isSequenceFailed to support highlighting failed sequences
    public boolean isSequenceFailed(List<String> seq) {
        return false;
    }

}
