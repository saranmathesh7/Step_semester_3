package class_problems;

import java.util.Scanner;

interface Question {
    double calculateScore();
}

class MCQQuestion implements Question {
    String correctAnswer;
    String studentAnswer;
    int points;

    MCQQuestion(String correctAnswer, String studentAnswer, int points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double calculateScore() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }

        return 0;
    }
}

class TFQuestion implements Question {
    String correctAnswer;
    String studentAnswer;
    int points;

    TFQuestion(String correctAnswer, String studentAnswer, int points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double calculateScore() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }

        return 0;
    }
}

class EssayQuestion implements Question {
    String correctAnswer;
    String studentAnswer;
    int points;

    EssayQuestion(String correctAnswer, String studentAnswer, int points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        String answer = studentAnswer.toLowerCase();

        int matched = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                matched++;
            }
        }

        if (matched >= 2) {
            return points * 0.75;
        } else if (matched == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class ExaminationGrader {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double totalScore = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            String[] parts = line.split("\"");

            String type = parts[0].trim().split(" ")[0];

            Question question;

            if (type.equals("MCQ")) {
                String correctAnswer = parts[3].trim();
                String studentAnswer = parts[5].trim();
                int points = Integer.parseInt(parts[6].trim());

                question = new MCQQuestion(
                        correctAnswer,
                        studentAnswer,
                        points);

            } else if (type.equals("TF")) {
                String correctAnswer = parts[3].trim();
                String studentAnswer = parts[5].trim();
                int points = Integer.parseInt(parts[6].trim());

                question = new TFQuestion(
                        correctAnswer,
                        studentAnswer,
                        points);

            } else {
                String correctAnswer = parts[3].trim();
                String studentAnswer = parts[5].trim();
                int points = Integer.parseInt(parts[6].trim());

                question = new EssayQuestion(
                        correctAnswer,
                        studentAnswer,
                        points);
            }

            double score = question.calculateScore();
            totalScore += score;

            System.out.printf("%s: %.2f%n", type, score);
        }

        System.out.printf("Total Score: %.2f%n", totalScore);

        sc.close();
    }
}