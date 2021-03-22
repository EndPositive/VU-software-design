package main.java.commands;

import com.badlogic.gdx.Input.Keys;
import main.java.misc.Direction;

public class CommandFactory {
    private CommandFactory() {
    }

    public static Command createCommand(int keycode) {
        switch (keycode) {
            case Keys.UP:
                return new Move(Direction.UP);
            case Keys.DOWN:
                return new Move(Direction.DOWN);
            case Keys.LEFT:
                return new Move(Direction.LEFT);
            case Keys.RIGHT:
                return new Move(Direction.RIGHT);
            case Keys.MINUS:
                return new DecreaseBufferLength();
            case Keys.EQUALS:
                return new IncreaseBufferLength();
            case Keys.SPACE:
                return new Select();
            case Keys.ENTER:
                return new ConfirmBuffer();
            case Keys.BACKSPACE:
                return new Undo();
            case Keys.R:
                return new Redo();
            default:
                return null;
        }
    }
}
