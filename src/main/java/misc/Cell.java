package main.java.misc;

public class Cell {
    public final int x, y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Cell applyDir(Direction dir) {
        if (dir == Direction.DOWN) {
            return new Cell(x + 1, y);
        } else if (dir == Direction.UP) {
            return new Cell(x - 1, y);
        } else if (dir == Direction.RIGHT) {
            return new Cell(x, y  + 1);
        } else if (dir == Direction.LEFT) {
            return new Cell(x, y - 1);
        }

        return this;
    }

    @Override
    public int hashCode() {
        return x * 10000 + y;
    }

    @Override
    public boolean equals(Object givenCell) {
        if (!(givenCell instanceof Cell)) return false;

        Cell cell = (Cell) givenCell;

        return this.x == cell.x && this.y == cell.y;
    }
}
