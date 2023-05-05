package puzzle.sudoku.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import puzzle.sudoku.exceptions.SudokuUnresolvableException;
import puzzle.sudoku.models.request.SudokuSubmitRequest;
import puzzle.sudoku.models.response.SudokuSolvedResponse;
import puzzle.sudoku.services.UserService;
import puzzle.sudoku.validators.RequestBodyValidator;

@Slf4j
@RestController
public class UserController {

    private final UserService userService;

    private final RequestBodyValidator requestBodyValidator;

    public UserController(UserService userService, RequestBodyValidator requestBodyValidator) {
        this.userService = userService;
        this.requestBodyValidator = requestBodyValidator;
    }

    @PostMapping(path = "/solve")
    public ResponseEntity<SudokuSolvedResponse> userSubmit(@Valid @RequestBody SudokuSubmitRequest sudokuSubmitRequest) {
        requestBodyValidator.validate(sudokuSubmitRequest.getPuzzle());
        SudokuSolvedResponse response = userService.sudokuSolve(sudokuSubmitRequest);
        if(response.getSolution().length == 1){
            throw new SudokuUnresolvableException("Sudoku is unresolvable, please provide a valid sudoku puzzle");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
