import java.io.IOException;
import java.util.*;

public class DayFive {
    private static final int NUMBER_OF_CHARS_PER_STACK = 4;

    public static void dayFiveChallenges() throws IOException {
        List<String> input = InputHelper.getListOfLinesFromInput("C:\\Users\\Dave\\Documents\\AdventOfCode\\Day5Input\\Section1.txt");
        challengeOne(input);
        challengeTwo(input);
    }

    protected static void challengeOne(List<String> input) {
        int numberOfStacks = (input.get(0).length()+1)/NUMBER_OF_CHARS_PER_STACK;
        List<Integer> indexes = new ArrayList<>();
        for(int i=1; i < numberOfStacks*NUMBER_OF_CHARS_PER_STACK; i+=NUMBER_OF_CHARS_PER_STACK) {
            indexes.add(i);
        }
        Map<Integer, List<String>> stacks = buildStacks(input, indexes, numberOfStacks);
        stacks = processStacks(input, stacks);
        System.out.println("Challenge one " + getTopCrates(stacks));
    }

    protected static void challengeTwo(List<String> input) {
        int numberOfStacks = (input.get(0).length()+1)/NUMBER_OF_CHARS_PER_STACK;
        List<Integer> indexes = new ArrayList<>();
        for(int i=1; i < numberOfStacks*NUMBER_OF_CHARS_PER_STACK; i+=NUMBER_OF_CHARS_PER_STACK) {
            indexes.add(i);
        }
        Map<Integer, List<String>> stacks = buildStacks(input, indexes, numberOfStacks);
        stacks = processStacksForChallengeTwo(input, stacks);
        System.out.println("Challenge two " + getTopCrates(stacks));
    }

    protected static Map<Integer, List<String>> buildStacks(List<String> input, List<Integer> indexes, Integer numberOfStacks) {
        //Loop until index 1 is a "1"
        //Get char at index if not whitespace, put it into map with updated list
        Map<Integer, List<String>> stacks = initializeMap(numberOfStacks);
        for(String row:input){
            if("1".equals(String.valueOf(row.charAt(1)))) {
                break;
            }
            for(int i=0; i<numberOfStacks; i++){
                String crate = String.valueOf(row.charAt(indexes.get(i)));
                if(!" ".equals(crate)) {
                    List<String> stack = stacks.get(i+1);
                    stack.add(crate);
                    stacks.put(i+1, stack);
                }
            }
        }
        return stacks;
    }

    protected static Map<Integer, List<String>> initializeMap(Integer numberOfStacks) {
        Map<Integer, List<String>> initializedMap = new HashMap<>();
        for(int i=0; i<numberOfStacks; i++) {
            initializedMap.put(i+1, new ArrayList<>());
        }
        return initializedMap;
    }

    protected static Map<Integer, List<String>> processStacks(List<String> input, Map<Integer, List<String>> stacks) {
        for(String row:input) {
            if ("".equals(row) || !"m".equals(String.valueOf(row.charAt(0)))) {
                continue;
            }
            Integer numberToMove = Integer.valueOf(row.substring(row.indexOf("e") + 2, row.indexOf("f") - 1));
            Integer originStackId = Integer.valueOf(row.substring(row.lastIndexOf("m") + 2, row.indexOf("t") - 1));
            Integer destinationStackId = Integer.valueOf(row.substring(row.lastIndexOf("o") + 2));
            List<String> originStack = new ArrayList<>(stacks.get(originStackId));
            List<String> destinationStack = new ArrayList<>(stacks.get(destinationStackId));

            for(int i=0; i<numberToMove; i++) {
                destinationStack.add(0, originStack.get(0));
                originStack.remove(0);
            }
            stacks.put(originStackId, originStack);
            stacks.put(destinationStackId, destinationStack);
        }
        return stacks;
    }

    protected static String getTopCrates(Map<Integer, List<String>> stacks) {
        String output = "";
        for(int i=1; i<10; i++) {
            output = output + stacks.get(i).get(0);
        }
        return output;
    }

    protected static Map<Integer, List<String>> processStacksForChallengeTwo(List<String> input, Map<Integer, List<String>> stacks) {
        for(String row:input) {
            if ("".equals(row) || !"m".equals(String.valueOf(row.charAt(0)))) {
                continue;
            }
            Integer numberToMove = Integer.valueOf(row.substring(row.indexOf("e") + 2, row.indexOf("f") - 1));
            Integer originStackId = Integer.valueOf(row.substring(row.lastIndexOf("m") + 2, row.indexOf("t") - 1));
            Integer destinationStackId = Integer.valueOf(row.substring(row.lastIndexOf("o") + 2));


            for(int i=numberToMove-1; i>=0; i--) {
                List<String> originStack = new ArrayList<>(stacks.get(originStackId));
                List<String> destinationStack = new ArrayList<>(stacks.get(destinationStackId));

                destinationStack.add(0, originStack.get(i));
                originStack.remove(i);

                stacks.put(originStackId, originStack);
                stacks.put(destinationStackId, destinationStack);
            }

        }
        return stacks;
    }
}
