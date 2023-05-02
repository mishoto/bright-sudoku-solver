package puzzle.sudoku.models.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class SudokuSubmitRequest implements Serializable {

    @Serial
    @JsonIgnore
    private static final long serialVersionUID = -4165610349262056394L;

    @NotEmpty(message = "Please provide sudoku puzzle with 9 rows and 9 columns!")
    private Integer[][] puzzle;
}
