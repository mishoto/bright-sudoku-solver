package puzzle.sudoku.services;

import org.springframework.stereotype.Service;
import puzzle.sudoku.models.request.SudokuSubmitRequest;
import puzzle.sudoku.models.response.SudokuSolvedResponse;
import puzzle.sudoku.utils.SudokuSolver;

@Service
public class UserServiceImpl implements UserService{
    private final SudokuSolver sudokuSolver;

    public UserServiceImpl(SudokuSolver sudokuSolver) {
        this.sudokuSolver = sudokuSolver;
    }

    @Override
    public SudokuSolvedResponse sudokuSolve(SudokuSubmitRequest sudokuSubmitRequest) {
        return new SudokuSolvedResponse(sudokuSolver.solveSudoku(sudokuSubmitRequest.getPuzzle()));
    }
}
