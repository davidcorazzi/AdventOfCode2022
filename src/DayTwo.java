import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DayTwo {
    public static final String OPP_ROCK = "A";
    public static final String OPP_PAPER = "B";
    public static final String OPP_SCISSORS = "C";
    public static final String ME_ROCK = "X";
    public static final String ME_PAPER = "Y";
    public static final String ME_SCISSORS = "Z";
    public static final String LOSE = "X";
    public static final String DRAW = "Y";
    public static final String WIN = "Z";

    public static void dayTwoChallenges() throws IOException {
        String input = InputHelper.getInputAsString("C:\\Users\\Dave\\Documents\\AdventOfCode\\Day2Input\\Section1.txt");
        rockPaperScissorsPart1(input);
        rockPaperScissorsPart2(input);
    }

    private static void rockPaperScissorsPart2(String input) {
        List<String> rounds = Arrays.asList(input.split("\r\n"));
        int total = rounds.stream()
                .map(DayTwo::getRoundPointsPart2)
                .collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Rock Paper Scissors points Round 2: " + total);
    }

    private static void rockPaperScissorsPart1(String input) {
        List<String> rounds = Arrays.asList(input.split("\r\n"));
        int total = rounds.stream()
                .map(DayTwo::getRoundPoints)
                .collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Rock Paper Scissors points: " + total);
    }

    private static int getRoundPoints(String round) {
        int roundPoints = 0;
        String[] plays = round.split("\\s+");
        String opponent = plays[0];
        String me = plays[1];
        roundPoints += getPlayedPoints(me);
        roundPoints+= getMatchPoints(opponent, me);
        return roundPoints;
    }

    private static int getPlayedPoints(String play) {
        switch(play) {
            case(ME_ROCK):
                return 1;
            case(ME_PAPER):
                return 2;
            case(ME_SCISSORS):
                return 3;
            default:
                return 0;
        }
    }

    private static int getMatchPoints(String opp, String me) {
        switch(opp) {
            case(OPP_ROCK):
                if(ME_PAPER.equals(me)) {
                    return 6;
                } else if(ME_ROCK.equals(me)) {
                    return 3;
                } else {
                    return 0;
                }
            case(OPP_PAPER):
                if(ME_SCISSORS.equals(me)) {
                    return 6;
                } else if(ME_PAPER.equals(me)) {
                    return 3;
                } else {
                    return 0;
                }
            case(OPP_SCISSORS):
                if(ME_ROCK.equals(me)) {
                    return 6;
                } else if(ME_SCISSORS.equals(me)) {
                    return 3;
                } else {
                    return 0;
                }
            default:
                return 0;
        }
    }

    private static int getRoundPointsPart2(String round) {
        int roundPoints = 0;
        String[] plays = round.split("\\s+");
        String opponent = plays[0];
        String me = getMyPlay(opponent, plays[1]);
        roundPoints += getPlayedPoints(me);
        roundPoints+= getMatchPoints(opponent, me);
        return roundPoints;
    }

    private static String getMyPlay(String opp, String me) {
        switch(opp) {
            case(OPP_ROCK):
                if(WIN.equals(me)) {
                    return ME_PAPER;
                } else if(DRAW.equals(me)) {
                    return ME_ROCK;
                } else {
                    return ME_SCISSORS;
                }
            case(OPP_PAPER):
                if(WIN.equals(me)) {
                    return ME_SCISSORS;
                } else if(DRAW.equals(me)) {
                    return ME_PAPER;
                } else {
                    return ME_ROCK;
                }
            case(OPP_SCISSORS):
                if(WIN.equals(me)) {
                    return ME_ROCK;
                } else if(DRAW.equals(me)) {
                    return ME_SCISSORS;
                } else {
                    return ME_PAPER;
                }
            default:
                return "INVALID";
        }
    }
}
