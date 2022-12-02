import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class InputHelper {
    public static String getInputAsString(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
