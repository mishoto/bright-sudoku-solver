package puzzle.sudoku.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import puzzle.sudoku.models.response.SudokuSolvedResponse;
import puzzle.sudoku.models.response.SudokuSolvedSerializer;

@Configuration
public class JacksonConfig {

    @Bean
    ObjectMapper jsonObjectMapper(){
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(SudokuSolvedResponse.class, new SudokuSolvedSerializer());
        mapper.registerModule(simpleModule);
        return mapper;
    }
}
