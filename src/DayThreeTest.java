import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DayThreeTest {

    public DayThreeTest(){}
    @Test
    public void givenStringWithEvenLength_whenCallingSplitCompartments_ReturnListOfStringsSplitEvenly() {
        String input = "vJrwpWtwJgWrhcsFMMfFFhFp";
        List<String> output = DayThree.splitCompartments(input);

        assertEquals("vJrwpWtwJgWr", output.get(0));
        assertEquals("hcsFMMfFFhFp", output.get(1));
    }

    @Test
    public void givenRuckSackContents_whenCallingGetMatchingItemsInRuckSack_ReturnMatchingLetter() {
        List<String> input = Arrays.asList("vJrwpWtwJgWr", "hcsFMMfFFhFp");
        String output = DayThree.getMatchingItemsInRuckSack(input);

        assertEquals("p", output);
    }

    @Test
    public void givenLetter_whenCallingGetValueOfContents_ReturnValue() {
        int output = DayThree.getValueOfContents("p");
        assertEquals(16, output);

        output = DayThree.getValueOfContents("L");
        assertEquals(38, output);

        output = DayThree.getValueOfContents("P");
        assertEquals(42, output);

        output = DayThree.getValueOfContents("v");
        assertEquals(22, output);
    }

    @Test
    public void givenValidInput_whenCallingPart1Challenge_ReturnValue() {
        List<String> input = Arrays.asList("vJrwpWtwJgWrhcsFMMfFFhFp", "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", "PmmdzqPrVvPwwTWBwg",
                "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn", "ttgJtRGJQctTZtZT", "CrZsJsPPZsGzwwsLwLmpwMDw");
        int output = DayThree.part1Challenge(input);

        assertEquals(157, output);
    }

    @Test
    public void givenValidInput_whenCallingPart2Challenge_ReturnValue() {
        List<String> input = Arrays.asList("vJrwpWtwJgWrhcsFMMfFFhFp","jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL","PmmdzqPrVvPwwTWBwg");
        int output = DayThree.part2Challenge(input);

        assertEquals(18, output);
    }
}