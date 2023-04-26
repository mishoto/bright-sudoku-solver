# sudoku-solver
sudoku solver using backtracking brute force approach  
For every cell with 0 solver() method recursively tries to fill it with 1 to 9 and validates the conditions of Sudoku. If conditions are not met it steps back while filling cells with 0 and tries next possible numbers until all cells are visited  when meeting constrains or  there is no solution for the given grid.  
Using spring starter-aop dependency to launch PerformanceMonitorInterceptor for logging sudoku solver method execution.
