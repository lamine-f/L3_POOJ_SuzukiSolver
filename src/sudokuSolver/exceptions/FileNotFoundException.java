package sudokuSolver.exceptions;

public class FileNotFoundException extends Exception {

    private final String fileName;

    public FileNotFoundException(String message, String fileName) {
        super(message);
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
