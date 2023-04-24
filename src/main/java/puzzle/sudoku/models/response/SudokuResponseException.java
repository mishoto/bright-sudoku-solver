package puzzle.sudoku.models.response;

public class SudokuResponseException extends Exception {
    public SudokuResponseException(String errorMessage) {
        super(errorMessage);
    }
}
