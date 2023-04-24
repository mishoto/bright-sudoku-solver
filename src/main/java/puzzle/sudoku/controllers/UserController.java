package puzzle.sudoku.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import puzzle.sudoku.models.request.SudokuSubmitRequest;
import puzzle.sudoku.models.response.SudokuSolvedResponse;
import puzzle.sudoku.services.UserService;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/solve")
    public ResponseEntity<SudokuSolvedResponse> userSubmit(@Valid @RequestBody SudokuSubmitRequest sudokuSubmitRequest) {
        SudokuSolvedResponse response = userService.sudokuSolve(sudokuSubmitRequest);
        if(response.getSolution().length == 1){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "The puzzle is not valid");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
