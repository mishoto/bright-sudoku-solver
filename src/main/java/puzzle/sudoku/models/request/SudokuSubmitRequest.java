package puzzle.sudoku.models.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class SudokuSubmitRequest {

    @NotEmpty(message = "Please provide sudoku puzzle with 9 rows and 9 columns!")
    @Size(min = 9, max = 9, message = "Sudoku must have {min} rows and {max} columns")
    private int[][] puzzle;
}
