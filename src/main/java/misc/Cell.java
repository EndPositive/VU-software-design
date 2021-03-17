package main.java.misc;

public class Cell {
    public final int x, y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Cell applyDir(Direction dir) {
        switch (dir) {
            case UP:
                return new Cell(x, y - 1);
            case DOWN:
                return new Cell(x, y + 1);
            case LEFT:
                return new Cell(x - 1, y);
            case RIGHT:
                return new Cell(x + 1, y);
            default:
                return new Cell(0, 0);
        }
    }

    @Override
    public final int hashCode() {
        return x * 10000 + y;
    }

    @Override
    public final boolean equals(Object givenCell) {
        if (!(givenCell instanceof Cell)) return false;

        Cell cell = (Cell) givenCell;

        return this.x == cell.x && this.y == cell.y;
    }
}
