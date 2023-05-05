package puzzle.sudoku.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MatrixValidator implements ConstraintValidator<ValidMatrix, Integer[][]> {

    private static final Integer MATRIX_ROWS = 9;
    private static final Integer MATRIX_COLUMNS = 9;

    @Override
    public void initialize(ValidMatrix constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer[][] matrix, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = isMatrixLengthEqualTo9(matrix) && areMatrixRowsLengthEqualTo9(matrix);
        if(isValid){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("""
                    my message
                    """)
                    .addConstraintViolation();
        }
        return isValid;
    }

    public boolean areMatrixRowsLengthEqualTo9(Integer[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i].length != MATRIX_COLUMNS){
                return false;
            }
        }
        return true;
    }

    public boolean isMatrixLengthEqualTo9(Integer[][] matrix){
        return matrix.length == MATRIX_ROWS;
    }
}
