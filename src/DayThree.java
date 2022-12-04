import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayThree {

    public static void dayThreeChallenges() throws IOException {
        List<String> input = InputHelper.getListOfLinesFromInput("C:\\Users\\Dave\\Documents\\AdventOfCode\\Day3Input\\Section1.txt");
        System.out.println("Part 1 output: " + part1Challenge(input));
        System.out.println("Part2 output: " + part2Challenge(input));
    }

    protected static int part2Challenge(List<String> input) {
        List<String> elfGroup = new ArrayList<>();
        int total = 0;
        for(int i=0; i<input.size(); i++) {
            elfGroup.add(input.get(i));
            if((i+1) % 3 == 0) {
                String badge = findCommonBadgeInElfGroup(elfGroup);
                total += getValueOfContents(badge);
                elfGroup.clear();
            }
        }
        return total;
    }

    protected static String findCommonBadgeInElfGroup(List<String> elfGroup) {
        List<String> elfOne = Arrays.asList(elfGroup.get(0).split(""));
        List<String> elfTwo = Arrays.asList(elfGroup.get(1).split(""));
        List<String> elfThree = Arrays.asList(elfGroup.get(2).split(""));
        String commonBadge = "";
        for(String badge1:elfOne) {
            for(String badge2:elfTwo) {
                if(badge1.equals(badge2)) {
                    for(String badge3:elfThree) {
                        if(badge3.equals(badge2)) {
                            if (commonBadge.equals("") || commonBadge.equals(badge1)) {
                                commonBadge = badge1;
                            } else {
                                new RuntimeException("Multiple badges found");
                            }
                        }
                    }
                }
            }
        }
        return commonBadge;
    }

    public static int part1Challenge(List<String> input) {
        int total = 0;
        for(String ruckSack:input) {
            total += processRuckSack(ruckSack);
        }
        return total;
    }

    protected static int processRuckSack(String ruckSack) {
        List<String> compartments = splitCompartments(ruckSack);
        String matchingChar = getMatchingItemsInRuckSack(compartments);
        return getValueOfContents(matchingChar);
    }

    protected static String getMatchingItemsInRuckSack(List<String> compartments) {
        List<String> compartment1 = Arrays.asList(compartments.get(0).split(""));
        List<String> compartment2 = Arrays.asList(compartments.get(1).split(""));
        String matchingChar = "";
        for(String letter1:compartment1) {
            for(String letter2:compartment2) {
                if(letter1.equals(letter2)) {
                    if(matchingChar.equals("") || matchingChar.equals(letter1)) {
                        matchingChar = letter1;
                    } else {
                        new RuntimeException("Already found a match");
                    }
                }
            }
        }
        return matchingChar;
    }
    protected static List<String> splitCompartments(String ruckSack) {
        List<String> compartments = new ArrayList<>();
        int subStringIndex = ruckSack.length()/2;
        compartments.add(ruckSack.substring(0, subStringIndex));
        compartments.add(ruckSack.substring(subStringIndex));

        return compartments;
    }

    protected static int getValueOfContents(String letter) {
        int asciiCode = (int) letter.charAt(0);
        int value = 0;
        if(asciiCode < 91) {
            value = asciiCode - 38;
        } else {
            value = asciiCode - 96;
        }
        return value;
    }
}
