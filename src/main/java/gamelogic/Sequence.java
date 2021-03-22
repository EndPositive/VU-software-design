package main.java.gamelogic;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Sequence {
    private final List<String> seq;

    public Sequence(List<String> seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return String.join("  ", seq);
    }

    public boolean isSequenceCompleted(GameState gameState) {
        if (gameState.buffer.isEmpty()) return false;

        String bufferString = gameState.buffer.stream()
                .map(cl -> gameState.gameLevel.matrix.get(cl) + " ")
                .reduce("", String::concat);
        return bufferString.contains(String.join(" ", seq));
    }

    public boolean isSequenceFailed(GameState gameState) {
        if (gameState.buffer.isEmpty()) return false;

        int checkFailedSeq = checkFailedSeq(gameState);

        //TODO: This is very confusing. Add some comments and maybe rename `checkFailedSeq`
        if (checkFailedSeq < 0)
            return gameState.buffer.size() + seq.size() > gameState.buffer.getMaxBufferLength();
        return checkFailedSeq + seq.size() > gameState.buffer.getMaxBufferLength();
    }

    private int checkFailedSeq(GameState gameState) {
        List<String> bufferString = gameState.buffer.stream()
                .map(gameState.gameLevel.matrix::get)
                .collect(Collectors.toList());
        String headOfSeq = seq.get(0);

        int matchIndex = bufferString.indexOf(headOfSeq);
        int bufferSize = gameState.buffer.size();
        int incrementOfIndex;

        while (matchIndex >= 0 && Collections.indexOfSubList(seq, bufferString.subList(matchIndex, bufferSize)) < 0) {
            incrementOfIndex = bufferString.subList(matchIndex + 1, bufferSize).indexOf(headOfSeq);
            matchIndex = incrementOfIndex < 0 ? -1 : (matchIndex + incrementOfIndex + 1);
        }

        return matchIndex;
    }
}
