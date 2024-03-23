package me.madcabbage.shopping_system.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {

    private static final BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));

    private Console() {
        // hide implicit public constructor
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printSpaced(String message) {
        print(message + '\n');
    }

    public static String prompt(String prompt) {
        System.out.println(prompt);
        String answer;
        try {
            answer = cin.readLine();
        } catch (IOException ignored) {
            answer = "";
        }

        return answer;
    }

    public static String promptSpaced(String prompt) {
        String answer = prompt(prompt);
        System.out.println();
        return answer;
    }

    public static void printSpace() {
        System.out.println();
    }

    public static String promptWithChoices(String prompt, String[] choices) {
        System.out.println(prompt);
        return getValidAnswer(choices);
    }

    private static String getValidAnswer(String[] choices) {
        String chosenAnswer = null;
        while (chosenAnswer == null) {
            System.out.println(formatAnswers(choices));
            String userInput = "";

            try {
                userInput = cin.readLine();
                chosenAnswer = parseAnswerFromInt(userInput, choices);

            } catch (NumberFormatException e) {
                chosenAnswer = parseAnswer(userInput, choices);
            } catch (IOException ignored) {
                // do nothing
            }

            if (chosenAnswer == null) {
                System.out.println("\nIncorrect choice. Please enter the corresponding number or the choice text.");
            }
        }
        return chosenAnswer;
    }

    private static String parseAnswerFromInt(String input, String[] choices) {
        int choice = Integer.parseInt(input);
        if (choice - 1 < choices.length && choice - 1 >= 0) {
            return choices[choice-1];
        }
        return null;
    }

    private static String parseAnswer(String input, String[] choices) {
        for (String answer : choices) {
            if (input.equalsIgnoreCase(answer)) {
                return answer;
            }
        }
        return null;
    }

    public static String promptWithChoicesSpaced(String prompt, String[] choices) {
        String choice = promptWithChoices(prompt, choices);
        System.out.println();
        return choice;
    }

    private static String formatAnswers(String[] answers) {
        StringBuilder validAnswers = new StringBuilder();
        for (int i = 0; i < answers.length; i++) {
            validAnswers.append(i + 1).append(". ").append(answers[i]);
            if (i != answers.length - 1) {
                validAnswers.append('\n');
            }
        }
        return validAnswers.toString();
    }

    public static void close() throws IOException {
        cin.close();
    }

    public static int promptSpacedInt(String prompt) {
        int answer = promptInt(prompt);
        System.out.println();
        return answer;
    }
    public static int promptInt(String prompt) {
        System.out.println(prompt);

        int promptInt;
        while (true){
            try
            {
                String userInput = cin.readLine(); // Read user input from the console
                promptInt = Integer.parseInt(userInput); // Parse the user input as an integer
                break;
            }
            catch (NumberFormatException e) {
                // If parsing fails, display an error message and continue the loop
                System.out.println("Invalid input. Please enter a number.");
            } catch (IOException e) {
                // If an IO error occurs, display an error message and continue the loop
                System.out.println("An error occurred while reading input. Please try again.");
            }
        }
        return promptInt;
    }


}
