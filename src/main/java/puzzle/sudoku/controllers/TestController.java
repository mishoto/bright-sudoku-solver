package puzzle.sudoku.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import puzzle.sudoku.exceptions.SudokuUnresolvableException;
import puzzle.sudoku.models.request.SudokuSubmitRequestHv;
import puzzle.sudoku.models.response.SudokuSolvedResponse;
import puzzle.sudoku.services.UserService;


@RestController
public class TestController {

    private final UserService userService;

    public TestController(UserService userService) {
        this.userService = userService;

    }
    @PostMapping(path = "/submit")
    public ResponseEntity<SudokuSolvedResponse> userSubmitHv(@Valid @RequestBody SudokuSubmitRequestHv sudokuSubmitRequestHv) {
        SudokuSolvedResponse response = userService.sudokuSolveWithHv(sudokuSubmitRequestHv);
        if(response.getSolution().length == 1){
            throw new SudokuUnresolvableException("Sudoku is unresolvable, please provide a valid sudoku puzzle");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
