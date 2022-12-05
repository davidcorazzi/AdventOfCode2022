import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DayFourTest {

    @Test
    void partOneChallenge() {
        List<String> input = Arrays.asList("2-4,6-8",
                "2-3,4-5",
                "5-7,7-9",
                "2-8,3-7",
                "6-6,4-6",
                "2-6,4-8");
        Integer output = DayFour.partOneChallenge(input);
        assertEquals(2, output);
    }

    @Test
    void getRanges() {
        List<String> input = Arrays.asList("2-4","6-8");
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("2","4"),
                Arrays.asList("6","8"));
        List<List<String>> output = DayFour.getRanges(input);
        assertEquals(expected, output);

        input = Arrays.asList("2-3","4-5");
        expected = Arrays.asList(
                Arrays.asList("2","3"),
                Arrays.asList("4","5"));
        output = DayFour.getRanges(input);
        assertEquals(expected, output);

        input = Arrays.asList("6-6","4-6");
        expected = Arrays.asList(
                Arrays.asList("6","6"),
                Arrays.asList("4","6"));
        output = DayFour.getRanges(input);
        assertEquals(expected, output);
    }

    @Test
    void partTwoChallenge() {
        List<String> input = Arrays.asList("2-4,6-8",
                "2-3,4-5",
                "5-7,7-9",
                "2-8,3-7",
                "6-6,4-6",
                "2-6,4-8");
        Integer output = DayFour.partTwoChallenge(input);
        assertEquals(4, output);
    }
}