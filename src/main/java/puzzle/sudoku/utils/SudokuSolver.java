package puzzle.sudoku.utils;

import org.springframework.stereotype.Component;

@Component
public class SudokuSolver {

    public int[][] solveSudoku(int[][] submittedGrid) {
        if(solver(submittedGrid)){
            return submittedGrid;
        }
        return new int[1][1];
    }

    private boolean solver(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] != 0) {
                    continue;
                }

                for (int k = 1; k <= 9; k++) {
                    if (isValid(grid, i, j, k)) {
                        grid[i][j] = k;
                        if (solver(grid)) {
                            return true;
                        }
                        grid[i][j] = 0;
                    }
                }
                return false;
            }
        }
        return true; //if all cells are checked
    }

    private boolean isValid(int[][] grid, int row, int col, int n) {
        for (int i = 0; i < 9; i++) {
            if (grid[i][col] != 0 && grid[i][col] == n) {
                return false;
            }

            if (grid[row][i] != 0 && grid[row][i] == n) {
                return false;
            }

            int subGridRow = 3 * (row / 3) + i / 3;
            int subGridColumn = 3 * (col / 3) + i % 3;
            if (grid[subGridRow][subGridColumn] != 0
                    &&
                    grid[subGridRow][subGridColumn] == n) {
                return false;
            }
        }
        return true;
    }
}
