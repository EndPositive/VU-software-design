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

        List<String> bufferString = gameState.buffer.stream()
                .map(gameState.gameLevel.matrix::get)
                .collect(Collectors.toList());

        int indexOfMatchedSubsequence = indexOfCommonSubsequence(bufferString, seq);

        // In case of no matched subsequence, check if there are still enough spots in buffer for the sequence
        if (indexOfMatchedSubsequence < 0)
            return gameState.buffer.size() + seq.size() > gameState.buffer.getMaxBufferLength();

        // If matched sequence is found, check if there are still enough spots in buffer for remaining subsequence
        return indexOfMatchedSubsequence + seq.size() > gameState.buffer.getMaxBufferLength();
    }

    private int indexOfCommonSubsequence(List<String> firstSequence, List<String> secondSequence) {
        // This function takes two sequences (lists of strings) as input and returns the index of
        // the longest postfix in firstSequence that is matched by the prefix of secondSequence
        // -1 is returned in case of no common subsequences

        String headOfSecondSeq = secondSequence.get(0);
        int matchIndex = firstSequence.indexOf(headOfSecondSeq);
        int incrementOfIndex;

        // Recursively search if there is some postfix of firstSequence matching some prefix of secondSequence
        // matchIndex is the current index of headOfSecondSeq in firstSequence, serves as anchor for matching
        while (matchIndex >= 0 &&
                Collections.indexOfSubList(secondSequence, firstSequence.subList(matchIndex, firstSequence.size())) < 0) {
            incrementOfIndex = firstSequence.subList(matchIndex + 1, firstSequence.size()).indexOf(headOfSecondSeq);
            matchIndex = incrementOfIndex < 0 ? -1 : (matchIndex + incrementOfIndex + 1);
        }

        return matchIndex;
    }
}
