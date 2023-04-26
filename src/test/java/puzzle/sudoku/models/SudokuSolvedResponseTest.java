package puzzle.sudoku.models;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import puzzle.sudoku.models.response.SudokuSolvedResponse;

import java.io.IOException;


import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class SudokuSolvedResponseTest {

    @Autowired
    private JacksonTester<SudokuSolvedResponse> responseJacksonTester;

    @Test
    void jacksonTesterIsLoadedInContext(){
        assertThat(responseJacksonTester).isNotNull();
    }

    @Test
    void testResponseSerialization() throws IOException {

        SudokuSolvedResponse serverResponsePayloadAsObject = new SudokuSolvedResponse(new int[][]{
                {5, 4, 6, 2, 1, 9, 8, 3, 7},
                {9, 8, 7, 3, 6, 5, 1, 2, 4},
                {3, 1, 2, 8, 7, 4, 6, 9, 5},
                {4, 2, 5, 7, 9, 8, 3, 6, 1},
                {8, 6, 9, 1, 4, 3, 7, 5, 2},
                {1, 7, 3, 6, 5, 2, 4, 8, 9},
                {6, 5, 8, 4, 2, 1, 9, 7, 3},
                {7, 9, 1, 5, 3, 6, 2, 4, 8},
                {2, 3, 4, 9, 8, 7, 5, 1, 6}
        });

        String clientReceivePayloadAsJson = """
                {
                 "solution":
                    [
                        [5, 4, 6, 2, 1, 9, 8, 3, 7],
                        [9, 8, 7, 3, 6, 5, 1, 2, 4],
                        [3, 1, 2, 8, 7, 4, 6, 9, 5],
                        [4, 2, 5, 7, 9, 8, 3, 6, 1],
                        [8, 6, 9, 1, 4, 3, 7, 5, 2],
                        [1, 7, 3, 6, 5, 2, 4, 8, 9],
                        [6, 5, 8, 4, 2, 1, 9, 7, 3],
                        [7, 9, 1, 5, 3, 6, 2, 4, 8],
                        [2, 3, 4, 9, 8, 7, 5, 1, 6]
                    ]
                }
                """;

        JsonContent<SudokuSolvedResponse> testResponse = responseJacksonTester.write(serverResponsePayloadAsObject);
        assertThat(testResponse.getJson()).isEqualTo(clientReceivePayloadAsJson);
    }
}
