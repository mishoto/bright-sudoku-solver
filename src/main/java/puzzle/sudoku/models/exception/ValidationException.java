package puzzle.sudoku.models.exception;

import lombok.*;

import java.util.List;



@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ValidationException {

    private String objectName;
    private List<String> defaultMessages;

}
