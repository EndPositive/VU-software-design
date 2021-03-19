package main.java.gamelogic;


import java.util.Collections;
import java.util.List;

public class Sequence {
    private final List<String> seq;

    public Sequence(List<String> seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return String.join("  ", seq);
    }

    public boolean isSequenceFailed(GameState gameState) {
        if (BufferLogic.getBuffer(gameState).isEmpty()) return false;

        // TODO: MAKE FUNCTION
        List<String> bufferString = BufferLogic.getBufferAsString(gameState);
        String headOfSeq = seq.get(0);

        int matchIndex = bufferString.indexOf(headOfSeq);
        int bufferSize = BufferLogic.getBuffer(gameState).size();
        int incrementOfIndex;

        while (matchIndex >= 0 && Collections.indexOfSubList(seq, bufferString.subList(matchIndex, bufferSize)) < 0) {
            incrementOfIndex = bufferString.subList(matchIndex + 1, bufferSize).indexOf(headOfSeq);
            matchIndex = incrementOfIndex < 0 ? -1 : (matchIndex + incrementOfIndex + 1);
        }

        if (matchIndex < 0)
            return BufferLogic.getBuffer(gameState).size() + seq.size() > BufferLogic.getMaxBufferLength(gameState);
        return matchIndex + seq.size() > BufferLogic.getMaxBufferLength(gameState);
    }

    public boolean isSequenceCompleted(GameState gameState) {
        if (BufferLogic.getBuffer(gameState).isEmpty()) return false;

        String bufferString = BufferLogic.getBuffer(gameState).stream()
                .map(cl -> gameState.gameLevel.matrix.get(cl) + " ")
                .reduce("", String::concat);
        return bufferString.contains(String.join(" ", seq));
    }
}
