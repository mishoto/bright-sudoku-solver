package puzzle.sudoku.services;


import puzzle.sudoku.models.request.SudokuSubmitRequest;
import puzzle.sudoku.models.request.SudokuSubmitRequestHv;
import puzzle.sudoku.models.response.SudokuSolvedResponse;

public interface UserService {

    SudokuSolvedResponse sudokuSolve(SudokuSubmitRequest sudokuSubmitRequest);
    SudokuSolvedResponse sudokuSolveWithHv(SudokuSubmitRequestHv sudokuSubmitRequestHv);

}
