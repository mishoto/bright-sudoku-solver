package puzzle.sudoku.exceptions;

public class SudokuInvalidRequestException extends RuntimeException{

    public SudokuInvalidRequestException(String message) {
        super(message);
    }
}
