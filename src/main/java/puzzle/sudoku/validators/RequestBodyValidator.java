package puzzle.sudoku.validators;


import org.springframework.stereotype.Component;
import puzzle.sudoku.exceptions.SudokuInvalidRequestException;


import java.util.*;
import java.util.stream.Stream;

@Component
public class RequestBodyValidator {

    private static final int SUDOKU_SIZE = 9;
    private static final String NOT_VALID_MATRIX = "Sudoku is not a valid 9 x 9 matrix";

    private final Integer[][] sudoku;
    public RequestBodyValidator(Integer[][] request) {
       this.sudoku = request;
    }

    public void validate(Integer[][] request){
        isValidMatrix(request);
        areAllNumbersNonZero(request);
        areAllNumbersInRange(request);
    }

    private void isValidMatrix(Integer[][] sudoku){
        if(sudoku.length != SUDOKU_SIZE){
            throw new SudokuInvalidRequestException(NOT_VALID_MATRIX);
        }
        for (int i = 0; i < sudoku.length; i++) {
            if(sudoku[i].length != SUDOKU_SIZE){
                throw new SudokuInvalidRequestException(NOT_VALID_MATRIX);
            }
        }
    }

    private void areAllNumbersInRange(Integer[][] sudoku){
        List<Integer> integerList = Stream.of(sudoku)
                .flatMap(Stream::of)
                .filter( i -> i < 0 || i > 9)
                .toList();
        if(integerList.size() != 0){
            throw new SudokuInvalidRequestException("Sudoku must have only numbers from 1 to 9");
        }
    }

    private void areAllNumbersNonZero(Integer[][] sudoku){
       List<Integer> integerList = Stream.of(sudoku)
               .flatMap(Stream::of)
               .filter( i -> i != 0)
               .toList();
       if(integerList.size() == 0){
           throw new SudokuInvalidRequestException("Sudoku must have any numbers from 1 to 9 to be resolved");
       }
    }
}
