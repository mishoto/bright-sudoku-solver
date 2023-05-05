package puzzle.sudoku.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;
import java.util.stream.Stream;

public class NumbersInRangeValidator implements ConstraintValidator<NumbersInRange, Integer[][]> {
    @Override
    public boolean isValid(Integer[][] sudoku, ConstraintValidatorContext constraintValidatorContext) {
        List<Integer> integerList = Stream.of(sudoku)
                .flatMap(Stream::of)
                .filter( i -> i < 0 || i > 9)
                .toList();
        return integerList.size() == 0;
    }
}
