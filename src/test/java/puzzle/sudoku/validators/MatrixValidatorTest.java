package puzzle.sudoku.validators;


import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MatrixValidatorTest {

    MatrixValidator matrixValidator = new MatrixValidator();
    ConstraintValidatorContext constraintValidatorContext;
    Integer[][] validMatrix = new Integer[][]{
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
    Integer[][] invalidMatrixLength = new Integer[][]{
            {9, 8, 4, 0, 0, 2, 0, 0, 0},
            {2, 0, 7, 8, 0, 1, 6, 9, 0},
            {0, 0, 0, 0, 0, 9, 0, 0, 0},
            {1, 0, 0, 0, 0, 4, 0, 3, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 2, 0, 5, 0, 4, 6, 0},
            {3, 0, 8, 0, 0, 0, 9, 0, 0},
            {0, 0, 0, 7, 0, 0, 1, 5, 0},
    };
    Integer[][] invalidMatrixRowLength = new Integer[][]{
            {9, 8, 4, 0, 0, 2, 0, 0, 0},
            {2, 0, 7, 8, 0, 1, 6, 9, 0},
            {0, 0, 0, 0, 0, 9, 0, 0, 0},
            {1, 0, 0, 0, 0, 4, 0, 3, 0, 5},
            {0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 2, 0, 5, 0, 4, 6, 0},
            {3, 0, 8, 0, 0, 0, 9, 0, 0},
            {0, 0, 0, 7, 0, 0, 1, 5, 0},
            {0, 0, 0, 0, 2, 0, 3, 0, 0}
    };
    Integer[][] invalidMatrixLengthAndRowLength = new Integer[][]{
            {9, 8, 4, 0, 0, 2, 0, 0, 0},
            {2, 0, 7, 8, 0, 1, 6, 9, 0},
            {0, 0, 0, 0, 0, 9, 0, 0, 0},
            {1, 0, 0, 0, 0, 4, 0, 3, 0, 5},
            {0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 2, 0, 5, 0, 4, 6, 0},
            {3, 0, 8, 0, 0, 0, 9, 0, 0},
            {0, 0, 0, 7, 0, 0, 1, 5, 0},
    };
    @Test
    void should_Check_If_Matrix_Is_With_Equal_9_Rows(){

        assertTrue(matrixValidator.areMatrixRowsLengthEqualTo9(validMatrix));
        assertFalse(matrixValidator.areMatrixRowsLengthEqualTo9(invalidMatrixRowLength));
    }
    @Test
    void should_Check_If_Matrix_Length_is_9(){
        assertTrue(matrixValidator.isMatrixLengthEqualTo9(validMatrix));
        assertFalse(matrixValidator.isMatrixLengthEqualTo9(invalidMatrixLength));
    }
    @Test
    void should_Check_If_Matrix_Is_Valid(){
        assertTrue(matrixValidator.isValid(validMatrix, constraintValidatorContext));
        assertFalse(matrixValidator.isValid(invalidMatrixLength, constraintValidatorContext));
        assertFalse(matrixValidator.isValid(invalidMatrixRowLength, constraintValidatorContext));
        assertFalse(matrixValidator.isValid(invalidMatrixLengthAndRowLength, constraintValidatorContext));
    }
}
