package puzzle.sudoku.exceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SudokuValidationException extends ConstraintViolationException {

    private final List<String> errorMessages;

    public SudokuValidationException(String message, Set<? extends ConstraintViolation<?>> violations) {
        super(message, violations);
        errorMessages = new ArrayList<>();
        for (ConstraintViolation<?> violation : violations) {
            errorMessages.add(violation.getMessage());
        }
    }
    public List<String> getErrorMessages() {
        return errorMessages;
    }
}
