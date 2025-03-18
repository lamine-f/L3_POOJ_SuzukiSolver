package sudokuSolver;

import java.util.ArrayList;
import java.util.List;

public class Solver {

    private static Sudoku sudoku;
    private static boolean done = false;

    public static void setSudoku(Sudoku sudoku) {
        done = false;
        Solver.sudoku = sudoku;
    }

    public static Sudoku getSudoku() {
        return sudoku;
    }

    public static void resolve() {
        if (done) return;

        int i, j;
        for (i = 0; i < sudoku.getSize(); i++) {
            for (j = 0; j < sudoku.getSize(); j++) {
                if (sudoku.getValues()[i][j] == 0) {
                    List<Integer> possibilities = getPossibilities(i, j);
                    for (int possibility : possibilities) {
                        sudoku.getValues()[i][j] = possibility;
                        resolve();
                        if (done) return;
                        sudoku.getValues()[i][j] = 0;
                    }
                    return;
                }
            }
        }
        done = true;
    }

    private static void removeValue(List<Integer> possibilities, Integer value) {
        if (possibilities.contains(value)) possibilities.remove(possibilities.indexOf(value));
    }

    private static List<Integer> getPossibilities(int row, int col) {
        List<Integer> possibilities = new ArrayList<>();
        for (int i = 1; i <= sudoku.getSize(); i++) possibilities.add(i);
        for (int i = 0; i < sudoku.getSize(); i++) {
            removeValue(possibilities, sudoku.getValues()[i][col]);
            removeValue(possibilities, sudoku.getValues()[row][i]);
        }

        int sqrtSize = (int) Math.sqrt(sudoku.getSize());
        int X = (row / sqrtSize) * sqrtSize;
        int Y = (col / sqrtSize) * sqrtSize;

        for (int i = X; i < X + sqrtSize; i++)
            for (int j = Y; j < Y + sqrtSize; j++)
                removeValue(possibilities, sudoku.getValues()[i][j]);

        return possibilities;
    }
}