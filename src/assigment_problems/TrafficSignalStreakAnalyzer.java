package assigment_problems;

import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {

    static void findLongestStreak(String signalLog) {

        if (signalLog.length() == 0) {
            System.out.println("Empty Signal Log");
            return;
        }

        char currentSignal = signalLog.charAt(0);
        char longestSignal = currentSignal;

        int currentStreak = 1;
        int longestStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == currentSignal) {
                currentStreak++;
            } else {
                currentSignal = signalLog.charAt(i);
                currentStreak = 1;
            }

            if (currentStreak > longestStreak) {
                longestStreak = currentStreak;
                longestSignal = currentSignal;
            }
        }

        System.out.println(
                "Longest Streak: '"
                + longestSignal
                + "' repeated "
                + longestStreak
                + " times"
        );
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter signal log: ");
        String signalLog = sc.nextLine();

        findLongestStreak(signalLog);
    }
}