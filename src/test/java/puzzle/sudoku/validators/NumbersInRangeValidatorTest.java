package puzzle.sudoku.validators;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumbersInRangeValidatorTest {

    NumbersInRangeValidator numbersInRangeValidator = new NumbersInRangeValidator();
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

    Integer[][] invalidSudokuWithNegative = new Integer[][]{
            {9, 8, 4, 0, 0, 2, 0, 0, 0},
            {2, 0, 7, 8, 0, 1, 6, 9, 0},
            {0, 0, 0, 0, 0, 9, 0, 0, 0},
            {1, 0, 0, 0, 0, -1, 0, 3, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 2, 0, 5, 0, 4, 6, 0},
            {3, 0, 8, 0, 0, 0, 9, 0, 0},
            {0, 0, 0, 7, 0, 0, 1, 5, 0},
            {0, 0, 0, 0, 2, 0, 3, 0, 0}
    };

    Integer[][] invalidSudokuWithPositive = new Integer[][]{
            {9, 8, 4, 0, 0, 2, 0, 0, 0},
            {2, 0, 7, 8, 0, 1, 6, 9, 0},
            {0, 0, 0, 0, 0, 9, 0, 0, 0},
            {1, 0, 0, 0, 0, 4, 0, 3, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 2, 0, 5, 0, 4, 6, 0},
            {3, 0, 8, 0, 0, 0, 9, 0, 0},
            {0, 0, 0, 7, 0, 0, 11, 5, 0},
            {0, 0, 0, 0, 2, 0, 3, 0, 0}
    };

    @Test
    void should_Check_If_Sudoku_Numbers_Are_In_Range_0_9(){
        assertTrue(numbersInRangeValidator.isValid(validSudoku, constraintValidatorContext));
        assertFalse(numbersInRangeValidator.isValid(invalidSudokuWithNegative, constraintValidatorContext));
        assertFalse(numbersInRangeValidator.isValid(invalidSudokuWithPositive, constraintValidatorContext));
    }
}
