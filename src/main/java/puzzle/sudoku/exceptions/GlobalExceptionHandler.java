package puzzle.sudoku.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import puzzle.sudoku.models.exception.SudokuException;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    ResponseEntity<SudokuException> handleSudokuUnresolvableException(final SudokuUnresolvableException sudokuUnresolvableException){
        return new ResponseEntity<>(
                SudokuException.builder()
                        .title("Sudoku unresolvable")
                        .message(sudokuUnresolvableException.getMessage())
                        .errorType(SudokuUnresolvableException.class.getSimpleName())
                        .timeStamp(ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                        .build()
                ,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    ResponseEntity<SudokuException> handleSudokuInvalidRequestException(final SudokuInvalidRequestException sudokuInvalidRequestException){
        return new ResponseEntity<>(
                SudokuException.builder()
                        .title("Sudoku invalid request")
                        .message(sudokuInvalidRequestException.getMessage())
                        .errorType(SudokuInvalidRequestException.class.getSimpleName())
                        .timeStamp(ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                        .build(),
                HttpStatus.BAD_REQUEST);
    }


}
