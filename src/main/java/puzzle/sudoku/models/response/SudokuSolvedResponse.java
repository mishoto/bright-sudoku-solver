package puzzle.sudoku.models.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@JsonSerialize(using = SudokuSolvedSerializer.class)
public class SudokuSolvedResponse implements Serializable {

    @Serial
    @JsonIgnore
    private static final long serialVersionUID = 5425880735228975265L;

    private Integer[][] solution;

}
