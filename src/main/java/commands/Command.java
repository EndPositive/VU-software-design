package main.java.commands;

import main.java.gamelogic.GameState;

abstract public class Command {

    public void tryExecute(GameState gameState) {
        execute(gameState);
    }

    abstract protected boolean execute(GameState gameState);
}
