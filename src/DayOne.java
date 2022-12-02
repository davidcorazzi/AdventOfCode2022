import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DayOne {
    public static void dayOneChallenges() throws IOException {
        topThreeCalories();
        findMostCalories();
    }

    private static void topThreeCalories() throws IOException {
        String input = InputHelper.getInputAsString("C:\\Users\\Dave\\Documents\\AdventOfCode\\Day1Input\\Section1.txt");
        List<String> elves = Arrays.asList(input.split("\r\n\r\n"));
        List<Integer> indElfTotals = elves.stream().map(DayOne::totalElfCalories).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int topThreeTotal = 0;
        for(int i=0; i<3; i++) {
            topThreeTotal += indElfTotals.get(i);
        }
        System.out.println("Top 3 total: " + topThreeTotal);
    }
    private static void findMostCalories() throws IOException {
        int mostCalories = 0;
        String input = new String(Files.readAllBytes(Paths.get("C:\\Users\\Dave\\Documents\\AdventOfCode\\Day1Input\\Section1.txt")));
        List<String> elves = Arrays.asList(input.split("\r\n\r\n"));
        for(String elf : elves) {
            mostCalories = totalElfCalories(elf) > mostCalories ? totalElfCalories(elf) : mostCalories;
        }
        System.out.println("Most Calories: " + mostCalories);
    }

    private static int totalElfCalories(String elfsCalories) {
        List<String> meals = Arrays.asList(elfsCalories.split("\r\n"));
        return meals.stream()
                .map(Integer::valueOf)
                .collect(Collectors.summingInt(Integer::intValue));
    }
}
