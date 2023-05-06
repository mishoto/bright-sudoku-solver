package puzzle.sudoku.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import puzzle.sudoku.models.exception.SudokuException;
import puzzle.sudoku.models.exception.ValidationException;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ValidationException> handleValidationRequestException(final MethodArgumentNotValidException methodArgumentNotValidException){
        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
        List<String> defaultMessagesList = new ArrayList<>();
        fieldErrorList.forEach(fieldError -> defaultMessagesList.add(fieldError.getDefaultMessage()));
        return new ResponseEntity<>(
                ValidationException.builder()
                        .objectName(bindingResult.getObjectName())
                        .defaultMessages(defaultMessagesList)
                        .build(),
                HttpStatus.BAD_REQUEST);
    }
}
