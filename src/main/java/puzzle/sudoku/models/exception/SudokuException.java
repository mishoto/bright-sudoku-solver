package puzzle.sudoku.models.exception;

import lombok.*;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
public class SudokuException {

    private String title;
    private String message;
    private String errorType;
    private String timeStamp;
}
