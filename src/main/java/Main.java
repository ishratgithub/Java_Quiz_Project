import Utils.MyJSON;
import controller.AdminUsers;
import controller.StudentUsers;
import QuestionAndUser.User;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException, java.text.ParseException {
        String usersFilePath = "./src/main/resources/users.json";
        List<User> users = MyJSON.readUsers(usersFilePath);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        User loggedInUser = null;
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                loggedInUser = user;
                break;
            }
        }

        if (loggedInUser != null) {
            System.out.println("Login successful!");
            if (loggedInUser.getRole().equals("admin")) {
                System.out.println("Welcome admin! Please create new questions in the question bank.");
                char choice;
                do {
                    AdminUsers.addQuestion();
                    System.out.println("Do you want to add more questions? (press s for start and q for quit)");
                    choice = scanner.next().charAt(0);
                    scanner.nextLine();
                } while (choice == 's');

            } else if (loggedInUser.getRole().equals("student")) {
                System.out.println("Welcome " + loggedInUser.getUsername() + " to the quiz!");
                StudentUsers.quizStart(loggedInUser.getUsername());
                char choice;
                do {
                    System.out.println("Would you like to start again? press s for start or q for quit");
                    choice = scanner.next().charAt(0);
                    scanner.nextLine();
                    if (choice == 's') {
                        StudentUsers.quizStart(loggedInUser.getUsername());
                    }
                } while (choice == 's');
            }
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
        scanner.close();
    }
}
