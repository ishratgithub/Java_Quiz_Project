# Project Title: Simple-Quiz-project-on-java
This is a Java-based Quiz System application that allows administrators to manage questions and students to take quizzes.

## Features:
- User Authentication: Users can log in with their username and password. The system supports two roles: administrators and students.
- Admin Question Management: Administrators can add new multiple-choice questions to the quiz.
- Student Quiz Taking: Students can take quizzes consisting of randomly selected questions. The system calculates and displays the student's score.
- Data Storage: User and quiz data are stored in JSON files (users.json and quiz.json).
  
## Technology used:
- Intellij IDEA
- java
- json-simple library for JSON processing
  
## Prerequisites:
- Java Development Kit (JDK) 8 or later
- IntelliJ IDEA (or your preferred Java IDE)
- Gradle (if you want to use the provided Gradle build)

## Project Scenerio:
This is a simple role-based quiz system that allows:
Admin users to add multiple-choice questions (MCQs) to a question bank.
Student users to take a quiz based on the question bank.
The system uses two files for persistence:
users.json: Stores user credentials and roles.
quiz.json: Stores the MCQ question bank.

- users.json
Contains login credentials for both admin and student users:
json
CopyEdit
[
  { "username": "admin", "password": "1234", "role": "admin" },
  { "username": "salman", "password": "1234", "role": "student" }
]
- quiz.json
Stores all the MCQs added by the admin in the following format:
[
  {
    "question": "Which is not part of system testing?",
    "option 1": "Regression Testing",
    "option 2": "Sanity Testing",
    "option 3": "Load Testing",
    "option 4": "Unit Testing",
    "answerkey": 4
  }
]

- Login Flow
Admin Login:
System:> Enter your username
User:> admin
System:> Enter password
User:> 1234
System:> Welcome admin! Please create new questions in the question bank.
Student Login:
System:> Enter your username
User:> salman
System:> Enter password
User:> 1234
System:> Welcome salman to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking. Are you ready? Press 's' to start.
-  Admin Features
After successful login, an admin user can continuously add MCQs until they press 'q' to quit.
System:> Input your question
Admin:> Which is not part of system testing?
System:> Input option 1:
Admin:> Regression Testing
System:> Input option 2:
Admin:> Sanity Testing
System:> Input option 3:
Admin:> Load Testing
System:> Input option 4:
Admin:> Unit Testing
System:> What is the answer key?
Admin:> 4
System:> Saved successfully!
System:> Do you want to add more questions? (press 's' to start, 'q' to quit)

- Student Quiz Flow
System randomly selects 10 questions from the question bank.
Duplicate questions may appear if the question bank is small.
The student earns 1 mark for each correct answer.
No negative marking.
System:> [Question 1] Which is not part of system testing?
1. Regression Testing
2. Sanity Testing
3. Load Testing
4. Unit Testing
Student:> 4

## Output Vedio:
https://github.com/user-attachments/assets/239a6abe-61f2-4560-82df-034200a8d37a



