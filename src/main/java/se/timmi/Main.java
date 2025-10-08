package se.timmi;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static byte yesScore = 0;
    static byte noScore = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("=== ESCAPE TERMINAL ===");
        System.out.println("You wake up in a dimly lit digital chamber.");
        System.out.println("A mechanical voice echoes: 'To exit, you must prove logical stability.'");
        printEmptyLines(1);

        String[] questions = {
                "Do you understand where you are?",
                "Will you stay calm and analyze before acting?",
                "Do you believe every puzzle has a solution?",
                "Would you trust your own logic over instinct?",
                "Are you ready to face the unknown?"
        };

        for (int i = 0; i < questions.length; i++) {
            printEmptyLines(1);
            System.out.println(questions[i]);
            System.out.print("Answer (Yes/No): ");
            String answer = scanner.nextLine();
            checkAnswer(answer);
        }

        if (yesScore > noScore) {
            printEmptyLines(1);
            System.out.println("SYSTEM STATUS: Cognitive alignment detected...");
            printEmptyLines(1);
            boolean passed = mindfulChallange();

            if (passed) {
                printEmptyLines(1);
                System.out.println("SYSTEM: Verification successful.");
                System.out.println("The chamber hums as energy surges through the walls...");
                System.out.println("ACCESS GRANTED — the digital gate opens before you.");
                System.out.println("You’ve escaped the simulation!");
            }
        } else {
            printEmptyLines(1);
            System.out.println("----------------------------------------------");
            System.out.println("SYSTEM: Logic unstable. Terminal lockdown engaged.");
            System.out.println("Try again when your mind is balanced.");
        }

    }

    public static void checkAnswer(String answer) {
        if (answer.equalsIgnoreCase("yes")) {
            yesScore++;
        } else {
            noScore++;
        }
    }

    public static boolean mindfulChallange() {

        int challangeScore = 0;
        String[] statements = {
                "Observe your surroundings carefully...",
                "Close your eyes. Breathe. Remember who you are...",
                "Stretch your hands — feel the virtual air shifting..."
        };

        String[] questions = {
                "Did you follow the system instructions?",
                "Do you feel ready to continue the sequence?"
        };

        int seconds = 10;
        Random random = new Random();
        printEmptyLines(1);
        System.out.println("SYSTEM MESSAGE: " + statements[random.nextInt(statements.length)]);
        printEmptyLines(1);
        System.out.println("Calibrating neural focus... Please wait " + seconds + " seconds.");

        // Countdown
        printEmptyLines(1);
        for (int i = seconds; i > 0; i--) {
            try {
                System.out.print("\rProcessing: " + i + " seconds remaining...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        printEmptyLines(1);
        System.out.println("Calibration complete.");
        printEmptyLines(1);

        scanner.nextLine();

        for (int i = 0; i < questions.length; i++) {
            printEmptyLines(1);
            System.out.println(questions[i]);
            System.out.print("Answer (Yes/No): ");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                challangeScore++;
            }
        }

        if (challangeScore == 2) {
            return true;
        } else {
            printEmptyLines(1);
            System.out.println("SYSTEM: Incomplete synchronization. Escape attempt failed.");
            return false;
        }
    }

    public static void printEmptyLines(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println();
        }
    }
}
