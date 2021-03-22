package main.java.gamelogic;


public class ScoreLogic {
    private ScoreLogic() {
    }

    public static int calculateScore(GameState gameState) {
        // See documentation for properly formatted formula
        long numOfCompletedSeqs = gameState.gameLevel.solutions.stream().filter(seq -> seq.isSequenceCompleted(gameState)).count();
        return Math.round(factorial(numOfCompletedSeqs) * (gameState.timerLogic.timeLeft() + 1) * numOfCompletedSeqs *
                gameState.gameLevel.bufferLength * (gameState.gameLevel.bufferLength - gameState.buffer.offset * 2L)) / 10;
    }

    private static long factorial(long n) {
        return n <= 1 ? 1 : n * factorial(n - 1);
    }
}
