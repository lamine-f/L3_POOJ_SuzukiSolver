import sudokuSolver.Initializer;
import sudokuSolver.Solver;
import sudokuSolver.Sudoku;
import sudokuSolver.exceptions.BadFileFormatException;
import sudokuSolver.exceptions.FileNotFoundException;
import sudokuSolver.exceptions.GridInvalidException;


public class Main {
    public static void main(String[] args) {
        try {
            Sudoku sudoku = Initializer.execute(args[0]);
            System.out.println(sudoku);
            Solver.setSudoku(sudoku);
            Solver.resolve();
            System.out.println(sudoku);
        } catch (FileNotFoundException e) {
            System.out.printf("Le fichier \"%s\" n'est pas trouvé.\n", e.getFileName());
        } catch (BadFileFormatException e) {
            System.out.printf("Le format du fichier est incorrecte: %s.\n", e.getMessage());
        } catch (GridInvalidException e) {
            System.out.printf("La grille est invalide: %s.\n", e.getMessage());
        }

//        Sudoku sudokuForTest = new Sudoku();
//        int[][] values = {
//                {0, 5, 0, 0, 0, 9, 0, 0, 0},
//                {0, 8, 0, 7, 5, 0, 0, 2, 6},
//                {1, 0, 0, 0, 4, 6, 5, 0, 0},
//                {5, 0, 8, 0, 0, 0, 0, 1, 0},
//                {0, 0, 0, 0, 0, 0, 0, 5, 0},
//                {0, 0, 0, 1, 8, 5, 4, 6, 3},
//                {0, 0, 0, 0, 9, 2, 6, 3, 0},
//                {0, 6, 0, 0, 0, 0, 1, 0, 2},
//                {4, 2, 0, 6, 0, 3, 0, 0, 0}
//        };
//        sudokuForTest.setValues(values);
//        System.out.println(sudokuForTest);
//        sudokuForTest.resolve();
//        System.out.println(sudokuForTest);
    }
}