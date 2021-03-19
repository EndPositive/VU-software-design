package main.java.commands;

import main.java.gamelogic.GameState;

abstract public class Command {

    public boolean tryExecute(GameState gameState) {
        return execute(gameState);
    }

    abstract protected boolean execute(GameState gameState);
}
