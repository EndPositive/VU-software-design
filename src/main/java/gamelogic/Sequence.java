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

    public boolean isSequenceFailed(GameState gameState) {
        if (gameState.getBuffer().isEmpty()) return false;

        // TODO: MAKE FUNCTION
        List<String> bufferString = gameState.getBuffer().stream().map(gameState.gameLevel.matrix::get).collect(Collectors.toList());
        String headOfSeq = seq.get(0);
        int matchIndex = bufferString.indexOf(headOfSeq);
        int bufferSize = gameState.getBuffer().size();
        int incrementOfIndex;
        while (matchIndex >= 0 && Collections.indexOfSubList(seq, bufferString.subList(matchIndex, bufferSize)) < 0) {
            incrementOfIndex = bufferString.subList(matchIndex + 1, bufferSize).indexOf(headOfSeq);
            matchIndex = incrementOfIndex < 0 ? -1 : (matchIndex + incrementOfIndex + 1);
        }
        if (matchIndex < 0) return gameState.getBuffer().size() + seq.size() > gameState.getCurrentBufferLength();
        return matchIndex + seq.size() > gameState.getCurrentBufferLength();
    }

    public boolean isSequenceCompleted(GameState gameState) {
        if (gameState.getBuffer().isEmpty()) return false;

        String bufferString = gameState.getBuffer().stream().map(cl -> gameState.gameLevel.matrix.get(cl) + " ").reduce("", String::concat);
        return bufferString.contains(String.join(" ", seq));
    }
}
