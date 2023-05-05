package puzzle.sudoku.models;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import puzzle.sudoku.models.request.SudokuSubmitRequest;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class SudokuSubmitRequestTest {

    @Autowired
    JacksonTester<SudokuSubmitRequest> requestJacksonTester;

    @Test
    void jacksonTesterIsLoadedInContext(){
        assertThat(requestJacksonTester).isNotNull();
    }

    @Test
    void testRequestDeserialization() throws IOException {

        SudokuSubmitRequest serverPostPayloadAsObject = new SudokuSubmitRequest(new Integer[][]{
                {0, 0, 0, 2, 0, 9, 8, 3, 0},
                {0, 0, 7, 3, 0, 0, 1, 0, 0},
                {0, 1, 2, 0, 0, 0, 0, 0, 5},
                {0, 0, 0, 0, 9, 8, 0, 0, 1},
                {0, 0, 9, 0, 0, 0, 7, 0, 0},
                {1, 0, 0, 6, 5, 0, 0, 0, 0},
                {6, 0, 0, 0, 0, 0, 9, 7, 0},
                {0, 0, 1, 0, 0, 6, 2, 0, 0},
                {0, 3, 4, 9, 0, 7, 0, 0, 0}
        });

        String clientPostPayloadAsJson = """
                {
                 "puzzle":
                    [
                        [0, 0, 0, 2, 0, 9, 8, 3, 0],
                        [0, 0, 7, 3, 0, 0, 1, 0, 0],
                        [0, 1, 2, 0, 0, 0, 0, 0, 5],
                        [0, 0, 0, 0, 9, 8, 0, 0, 1],
                        [0, 0, 9, 0, 0, 0, 7, 0, 0],
                        [1, 0, 0, 6, 5, 0, 0, 0, 0],
                        [6, 0, 0, 0, 0, 0, 9, 7, 0],
                        [0, 0, 1, 0, 0, 6, 2, 0, 0],
                        [0, 3, 4, 9, 0, 7, 0, 0, 0]
                    ]
                }
                """;

         SudokuSubmitRequest testRequest = requestJacksonTester.parseObject(clientPostPayloadAsJson);
        assertThat(serverPostPayloadAsObject.getPuzzle()).isEqualTo(testRequest.getPuzzle());
    }
}
