package puzzle.sudoku.models.response;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;


import java.io.IOException;
import java.io.Serial;
import java.util.Arrays;


public class SudokuSolvedSerializer extends StdSerializer<SudokuSolvedResponse>{
    @Serial
    private static final long serialVersionUID = 4596197852252390284L;

    public SudokuSolvedSerializer() {
        this(null);
    }

    public SudokuSolvedSerializer(Class<SudokuSolvedResponse> t) {
        super(t);
    }

    @Override
    public void serialize(SudokuSolvedResponse sudokuSolvedResponse, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
      jsonGenerator.writeStartObject();
      jsonGenerator.writeStringField("solution", Arrays.deepToString(sudokuSolvedResponse.getSolution()));
      jsonGenerator.writeEndObject();
    }
}
