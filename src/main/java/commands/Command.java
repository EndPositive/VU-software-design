package main.java.commands;

import main.java.gamelogic.GameState;

public abstract class Command {

    public void tryExecute(GameState gameState) {
        execute(gameState);
    }

    protected abstract boolean execute(GameState gameState);
}
