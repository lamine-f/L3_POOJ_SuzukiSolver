package sudokuSolver;

public class Sudoku {

    final int size = 9;
    int[][] values;

    public int getSize() {
        return size;
    }

    public int[][] getValues() {
        return values;
    }

    public void setValues(int[][] values) {
        this.values = values;
    }

    public Sudoku() {
        values = new int[size][size];
    }

    @Override
    public String toString() {
        return Presenter.getRepresentation(this);
    }
}