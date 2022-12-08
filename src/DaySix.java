import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DaySix {
    public static void daySixChallenges() throws IOException {
        String input = InputHelper.getInputAsString("C:\\Users\\Dave\\Documents\\AdventOfCode\\Day6Input\\Section1.txt");
        System.out.println("Part One:" + partOneChallenge(input));
        System.out.println("Part Two: " + partTwoChallenge(input));
    }

    public static Integer partTwoChallenge(String input) {
        List<String> packet = initializeList(input, 14);
        for(int i=14; i<input.length(); i++) {
            String currentLetter = String.valueOf(input.charAt(i));
            packet = updateProcessArray(packet, currentLetter);
            if(!doesPacketContainDuplicate(packet)) {
                return i+1;
            }
        }
        return 0;
    }

    protected static Integer partOneChallenge(String input) {
        List<String> packet = initializeList(input, 4);
        for(int i=4; i<input.length(); i++) {
            String currentLetter = String.valueOf(input.charAt(i));
            packet = updateProcessArray(packet, currentLetter);
            if(!doesPacketContainDuplicate(packet)) {
                return i+1;
            }
        }
        return 0;
    }

    protected static Boolean doesPacketContainDuplicate(List<String> packet) {
        Set<String> testSet = new HashSet<>();

        for(String letter:packet) {
            if (!testSet.add(letter)) {
                return true;
            }
        }
        return false;
    }

    protected static List<String> updateProcessArray(List<String> packet, String newLetter) {
        packet.add(newLetter);
        packet.remove(0);
        return packet;
    }

    protected static List<String> initializeList(String input, Integer numberOfChars) {
        List<String> initializedList = new ArrayList<>();
        for(int i=0; i<numberOfChars; i++) {
            initializedList.add(String.valueOf(input.charAt(i)));
        }
        return initializedList;
    }
}
