package puzzle.sudoku.models.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import puzzle.sudoku.validators.ValidMatrix;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SudokuSubmitRequestHv implements Serializable {

    @Serial
    @JsonIgnore
    private static final long serialVersionUID = 5158010223030786209L;

    @ValidMatrix
    private Integer[][] puzzle;

}
