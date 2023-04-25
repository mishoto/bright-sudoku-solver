package puzzle.sudoku.services;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import puzzle.sudoku.models.request.SudokuSubmitRequest;
import puzzle.sudoku.models.response.SudokuSolvedResponse;
import puzzle.sudoku.utils.SudokuSolver;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class UserServiceTest {

    private UserService userService;
    private SudokuSolver sudokuSolver;

    private final int[] validNumbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final int[] invalidNumbers = new int[]{0, 10, -1};

    @BeforeEach
    void setupUserService(){
        sudokuSolver = mock(SudokuSolver.class);
        userService = new UserServiceImpl(sudokuSolver);
    }

    @Test
    void checkIfSudokuSolveMethodIsCorrect(){
        SudokuSubmitRequest sudokuSubmitRequest = new SudokuSubmitRequest(new int[][]{
                {9, 8, 4, 0, 0, 2, 0, 0, 0},
                {2, 0, 7, 8, 0, 1, 6, 9, 0},
                {0, 0, 0, 0, 0, 9, 0, 0, 0},
                {1, 0, 0, 0, 0, 4, 0, 3, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 2, 0, 5, 0, 4, 6, 0},
                {3, 0, 8, 0, 0, 0, 9, 0, 0},
                {0, 0, 0, 7, 0, 0, 1, 5, 0},
                {0, 0, 0, 0, 2, 0, 3, 0, 0}
        });
        SudokuSolvedResponse sudokuSolvedResponse = new SudokuSolvedResponse(new int[][]{
                {9, 8, 4, 3, 6, 2, 5, 1, 7},
                {2, 5, 7, 8, 4, 1, 6, 9, 3},
                {6, 1, 3, 5, 7, 9, 2, 4, 8},
                {1, 6, 9, 2, 8, 4, 7, 3, 5},
                {7, 4, 5, 6, 9, 3, 8, 2, 1},
                {8, 3, 2, 1, 5, 7, 4, 6, 9},
                {3, 2, 8, 4, 1, 5, 9, 7, 6},
                {4, 9, 6, 7, 3, 8, 1, 5, 2},
                {5, 7, 1, 9, 2, 6, 3, 8, 4}
        });
        when(sudokuSolver.solveSudoku(sudokuSubmitRequest.getPuzzle()))
                .thenReturn(sudokuSolvedResponse.getSolution());

        assertEquals(9, sudokuSolvedResponse.getSolution().length);
    }
}
