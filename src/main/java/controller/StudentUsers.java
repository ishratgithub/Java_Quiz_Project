package controller;

import Utils.MyJSON;
import QuestionAndUser.Question;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class StudentUsers {
    public static void quizStart(String username) throws IOException, ParseException, java.text.ParseException {
        List<Question> questions = MyJSON.readQuestions("./src/main/resources/quiz.json");
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        //String start = scanner.nextLine();
        System.out.println("Welcome "+username+" to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking. Are you ready? Press 's' to start.");
        String start = scanner.nextLine();

        if (start.equalsIgnoreCase("s")) {
            System.out.println("Starting quiz...");
            int questionsToAsk = 10;
            if (questions.size() < questionsToAsk) {
                questionsToAsk = questions.size();
            }
            int askedQuestionIndices[] = new int[questionsToAsk]; //to ensure no repeat questions
            boolean questionAsked[] = new boolean[questions.size()];
            int questionIndex;

            for (int i = 0; i < questionsToAsk; i++) {
                do {
                    questionIndex = random.nextInt(questions.size());
                } while (questionAsked[questionIndex]);
                questionAsked[questionIndex] = true;
                askedQuestionIndices[i] = questionIndex;

                Question currentQuestion = questions.get(questionIndex);
                System.out.println("[model.Question " + (i + 1) + "] " + currentQuestion.getQuestionText());
                String[] options = currentQuestion.getOptions();
                for (int j = 0; j < options.length; j++) {
                    System.out.println((j + 1) + ". " + options[j]);
                }

                int studentAnswer;
                while (true) {
                    System.out.print("Your answer (1-4): ");
                    try {
                        studentAnswer = scanner.nextInt();
                        if (studentAnswer >= 1 && studentAnswer <= 4) {
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter a number between 1 and 4.");
                        }
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number between 1 and 4.");
                        scanner.next();
                    }
                }
                scanner.nextLine();

                if (studentAnswer == currentQuestion.getAnswerKey()) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect.");
                }
            }

            System.out.println("Quiz finished!");
            System.out.println("Your score: " + score + " out of " + questionsToAsk);
            displayResult(score, questionsToAsk);

            System.out.print("Would you like to start again? press s for start or q for quit");


        }
        else {
            System.out.println("Quiz not started.");
        }
    }

    private static void displayResult(int score, int totalQuestions) {
        double percentage = (double) score / totalQuestions * 100;
        if (percentage >= 80) {
            System.out.println("Excellent! You have got " + score + " out of " + totalQuestions);
        } else if (percentage >= 50) {
            System.out.println("Good. You have got " + score + " out of " + totalQuestions);
        } else if (percentage >= 20) {
            System.out.println("Very poor! You have got " + score + " out of " + totalQuestions);
        } else {
            System.out.println("Very sorry you are failed. You have got " + score + " out of " + totalQuestions);
        }
    }
}
