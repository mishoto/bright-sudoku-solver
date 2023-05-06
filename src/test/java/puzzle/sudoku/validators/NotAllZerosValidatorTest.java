package puzzle.sudoku.validators;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotAllZerosValidatorTest {

    NotAllZerosValidator notAllZerosValidator = new NotAllZerosValidator();

    ConstraintValidatorContext constraintValidatorContext;

    Integer[][] validSudoku = new Integer[][]{
            {9, 8, 4, 0, 0, 2, 0, 0, 0},
            {2, 0, 7, 8, 0, 1, 6, 9, 0},
            {0, 0, 0, 0, 0, 9, 0, 0, 0},
            {1, 0, 0, 0, 0, 4, 0, 3, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 2, 0, 5, 0, 4, 6, 0},
            {3, 0, 8, 0, 0, 0, 9, 0, 0},
            {0, 0, 0, 7, 0, 0, 1, 5, 0},
            {0, 0, 0, 0, 2, 0, 3, 0, 0}
    };

    Integer[][] invalidSudokuWithAllZeros = new Integer[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    @Test
    void should_Check_If_Method_isValid_Is_Correct(){
        assertTrue(notAllZerosValidator.isValid(validSudoku, constraintValidatorContext));
        assertFalse(notAllZerosValidator.isValid(invalidSudokuWithAllZeros, constraintValidatorContext));
    }
}
