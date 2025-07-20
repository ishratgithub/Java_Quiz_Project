package Utils;

import QuestionAndUser.Question;
import QuestionAndUser.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MyJSON {
    public static List<Question> readQuestions(String filePath) throws FileNotFoundException, org.json.simple.parser.ParseException, ParseException {
        List<Question> questions = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {
            JSONArray jsonArray = (JSONArray) parser.parse(reader);

            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                String questionText = (String) jsonObject.get("question");
                String option1 = (String) jsonObject.get("option 1");
                String option2 = (String) jsonObject.get("option 2");
                String option3 = (String) jsonObject.get("option 3");
                String option4 = (String) jsonObject.get("option 4");
                String[] options = {option1, option2, option3, option4};
                int answerKey = ((Number) jsonObject.get("answerkey")).intValue();
                questions.add(new Question(questionText, options, answerKey));
            }

        } catch (IOException e) {
            System.err.println("Error reading quiz file: " + e.getMessage());
        }

        return questions;
    }

    public static List<User> readUsers(String filePath) throws org.json.simple.parser.ParseException, ParseException {
        List<User> users = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("./src/main/resources/users.json")) {
            JSONArray jsonArray = (JSONArray) parser.parse(reader);

            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                String username = (String) jsonObject.get("username");
                String password = (String) jsonObject.get("password");
                String role = (String) jsonObject.get("role");
                users.add(new User(username, password, role));
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return users;
    }

    public static void writeQuestionToJson(String filePath, Question question) throws IOException, org.json.simple.parser.ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonArray;

        try (FileReader reader = new FileReader("./src/main/resources/quiz.json")) {
            Object obj = parser.parse(reader);
            if (obj instanceof JSONArray) {
                jsonArray = (JSONArray) obj;
            } else {
                jsonArray = new JSONArray();
            }
        } catch (IOException e) {

            jsonArray = new JSONArray();
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("question", question.getQuestionText());
        jsonObject.put("option 1", question.getOptions()[0]);
        jsonObject.put("option 2", question.getOptions()[1]);
        jsonObject.put("option 3", question.getOptions()[2]);
        jsonObject.put("option 4", question.getOptions()[3]);
        jsonObject.put("answerkey", question.getAnswerKey());

        jsonArray.add(jsonObject);

        try (FileWriter file = new FileWriter("./src/main/resources/quiz.json")) {
            file.write(jsonArray.toJSONString());
            file.flush();
        }
    }
}
