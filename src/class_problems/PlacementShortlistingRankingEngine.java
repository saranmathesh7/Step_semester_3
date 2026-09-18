package class_problems;

import java.util.Arrays;
import java.util.Scanner;

public class PlacementShortlistingRankingEngine {

    private String name;
    private double cgpa;
    private int codingScore;

    public PlacementShortlistingRankingEngine(
            String name,
            double cgpa,
            int codingScore) {

        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    static boolean isEligible(double cgpa) {

        return cgpa >= 7.5;
    }

    static boolean isEligible(
            double cgpa,
            int codingScore) {

        return cgpa >= 6.5 && codingScore >= 60;
    }

    private double getCompositeScore() {

        return cgpa * 10 + codingScore;
    }

    public int compareTo(
            PlacementShortlistingRankingEngine other) {

        return Double.compare(
                other.getCompositeScore(),
                this.getCompositeScore()
        );
    }

    static String shortlistAndRank(
            PlacementShortlistingRankingEngine[] candidates) {

        PlacementShortlistingRankingEngine[] shortlisted =
                new PlacementShortlistingRankingEngine[candidates.length];

        int count = 0;

        for (PlacementShortlistingRankingEngine candidate : candidates) {

            if (isEligible(candidate.cgpa)
                    || isEligible(
                    candidate.cgpa,
                    candidate.codingScore)) {

                shortlisted[count] = candidate;
                count++;
            }
        }

        shortlisted = Arrays.copyOf(shortlisted, count);

        Arrays.sort(
                shortlisted,
                (a, b) -> a.compareTo(b)
        );

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < shortlisted.length; i++) {

            result.append(i + 1)
                    .append(". ")
                    .append(shortlisted[i].name)
                    .append(" (")
                    .append(shortlisted[i].getCompositeScore())
                    .append(")");

            if (i < shortlisted.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        sc.nextLine();

        PlacementShortlistingRankingEngine[] candidates =
                new PlacementShortlistingRankingEngine[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Enter candidate name: ");
            String name = sc.nextLine();

            System.out.print("Enter CGPA: ");
            double cgpa = sc.nextDouble();

            System.out.print("Enter coding score: ");
            int codingScore = sc.nextInt();
            sc.nextLine();

            candidates[i] =
                    new PlacementShortlistingRankingEngine(
                            name,
                            cgpa,
                            codingScore
                    );
        }

        System.out.println(
                shortlistAndRank(candidates)
        );
    }
}