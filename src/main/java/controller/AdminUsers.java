package controller;

import Utils.MyJSON;
import QuestionAndUser.Question;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class AdminUsers {
    public static void addQuestion() throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("System:> Input your question");
        String questionText = scanner.nextLine();

        String[] options = new String[4];
        System.out.println("System: Input option 1:");
        options[0] = scanner.nextLine();
        System.out.println("System: Input option 2:");
        options[1] = scanner.nextLine();
        System.out.println("System: Input option 3:");
        options[2] = scanner.nextLine();
        System.out.println("System: Input option 4:");
        options[3] = scanner.nextLine();

        System.out.println("System: What is the answer key?");
        int answerKey = scanner.nextInt();
        scanner.nextLine();
        Question question = new Question(questionText, options, answerKey);

        MyJSON.writeQuestionToJson("./src/main/resources/quiz.json", question);

        System.out.print("System:> Saved successfully! Do you want to add more questions? (press s for start and q for quit)");

    }
}
