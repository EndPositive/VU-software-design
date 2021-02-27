package misc;

public class Cell {
    public float x, y;

    public Cell(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object givenCell) {
        if (!(givenCell instanceof Cell)) return false;

        Cell cell = (Cell) givenCell;

        return this.x == cell.x && this.y == cell.y;
    }
}
