import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class ExampleReader {
    public static List<Example> readExamples(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return List.of(mapper.readValue(Paths.get(filePath).toFile(), Example[].class));
    }
}