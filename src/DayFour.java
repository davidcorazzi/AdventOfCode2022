import java.io.IOException;
import java.util.*;

public class DayFour {

    public static void dayFourChallenges() throws IOException {
        List<String> input = InputHelper.getListOfLinesFromInput("C:\\Users\\Dave\\Documents\\AdventOfCode\\Day4Input\\Section1.txt");
        System.out.println(partOneChallenge(input));
        System.out.println(partTwoChallenge(input));
    }

    protected static Integer partTwoChallenge(List<String> input) {
        int total = 0;
        for(String cleaningPairs:input) {
            List<String> cleaningAssignments = Arrays.asList(cleaningPairs.split(","));
            List<List<String>> ranges = getRanges(cleaningAssignments);
            if(areRangesOverlapping(ranges)) {
                total++;
            }
        }
        return total;
    }

    protected static Integer partOneChallenge(List<String> input) {
        int total = 0;
        for(String cleaningPairs:input) {
            List<String> cleaningAssignments = Arrays.asList(cleaningPairs.split(","));
            List<List<String>> ranges = getRanges(cleaningAssignments);
            if(isOneRangeContainedInTheOther(ranges)) {
                total++;
            }
        }
        return total;
    }

    //Returns map key is lowerRange, value is upperRange
    protected static List<List<String>> getRanges(List<String> cleaningAssignments) {
        List<List<String>> cleaningAssignment = new ArrayList<>();
        for(String assignment:cleaningAssignments) {
            cleaningAssignment.add(Arrays.asList(assignment.split("-")));
        }
        return cleaningAssignment;
    }

    protected static boolean areRangesOverlapping(List<List<String>> ranges) {
        List<String> range1 = ranges.get(0);
        List<String> range2 = ranges.get(1);

        if(getLowerRangeInt(range1) > getUpperRangeInt(range2) || getUpperRangeInt(range1) < getLowerRangeInt(range2)) {
            return false;
        } else {
            return true;
        }
    }

    protected static boolean isOneRangeContainedInTheOther(List<List<String>> ranges) {
        List<String> range1 = ranges.get(0);
        List<String> range2 = ranges.get(1);

        if(getLowerRangeInt(range1) <= getLowerRangeInt(range2) && getUpperRangeInt(range1) >= getUpperRangeInt(range2) ||
                getLowerRangeInt(range2) <= getLowerRangeInt(range1) && getUpperRangeInt(range2) >= getUpperRangeInt(range1)) {
            return true;
        } else {
            return false;
        }
    }

    protected static Integer getLowerRangeInt(List<String> range) {
        return Integer.valueOf(range.get(0));
    }

    protected static Integer getUpperRangeInt(List<String> range) {
        return Integer.valueOf(range.get(1));
    }
}
