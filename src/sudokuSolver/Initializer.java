package sudokuSolver;

import sudokuSolver.exceptions.BadFileFormatException;
import sudokuSolver.exceptions.FileNotFoundException;
import sudokuSolver.exceptions.GridInvalidException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Initializer {

    public static Sudoku execute (String fileName) throws FileNotFoundException, BadFileFormatException, GridInvalidException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            return doParse(br);
        } catch (IOException e) {
            throw new FileNotFoundException(e.getMessage(), fileName);
        }
    }

    private static int[][] transformListToArray(List<List<String>> listOfLists) {

        int[][] array = new int[listOfLists.size()][];
        for (int i = 0; i < listOfLists.size(); i++) {
            List<String> innerList = listOfLists.get(i);
            array[i] = new int[innerList.size()];
            for (int j = 0; j < innerList.size(); j++) {
                array[i][j] = Integer.parseInt(innerList.get(j));
            }
        }
        return array;
    }

    private static Sudoku doParse (BufferedReader br) throws IOException, BadFileFormatException, GridInvalidException {

        List<List<String>> values = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null)
            values.add(Arrays.asList(line.split(" ")));

        /*
        * TDDO: Gérer les erreurs suivants
        * o Mauvais format du fichier (ex. nombre incorrect de lignes ou de colonnes).
        * o Grille invalide (ex. valeurs incorrectes)
        * */

        boolean invalidColumnCount = false;
        boolean invalidRowCount = false;

        if (invalidColumnCount) throw new BadFileFormatException("");
        if (invalidRowCount) throw new BadFileFormatException("");

        boolean invalidValues = false;
        if (invalidValues) throw new GridInvalidException("");

        Sudoku sudoku = new Sudoku();
        sudoku.setValues(transformListToArray(values));
        return sudoku;
    }
}