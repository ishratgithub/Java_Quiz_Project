package QuestionAndUser;

import java.util.Arrays;

public class Question {
    private String questionText;
    private String[] options;
    private int answerKey;

    public Question(String questionText, String[] options, int answerKey) {
        this.questionText = questionText;
        this.options = options;
        this.answerKey = answerKey;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getAnswerKey() {
        return answerKey;
    }

    @Override
    public String toString() {
        return "model.Question{" +
                "questionText='" + questionText + '\'' +
                ", options=" + Arrays.toString(options) +
                ", answerKey=" + answerKey +
                '}';
    }
}
