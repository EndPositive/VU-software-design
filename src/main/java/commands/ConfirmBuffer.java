package main.java.commands;

import main.java.gamelogic.GameState;

public class ConfirmBuffer extends Command {
    protected boolean execute(GameState gameState) {
        gameState.timerLogic.stop();
        return true;
    }
}
