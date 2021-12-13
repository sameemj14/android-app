package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //private static final String TAG = "MainActivity";
    private TextView questionTV, questionNumberTV;
    private Button option1Bt, option2Bt, option3Bt, option4Bt;
    private ArrayList<QuizModel> quizModelArrayList;
    Random random;
    int currentScore = 0;
    int questionAttempted = 1;
    int currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTV = findViewById(R.id.idTVQuestion);
        questionNumberTV = findViewById(R.id.idTVQuestionAttempted);
        option1Bt = findViewById(R.id.idButnOption1);
        option2Bt = findViewById(R.id.idButnOption2);
        option3Bt = findViewById(R.id.idButnOption3);
        option4Bt = findViewById(R.id.idButnOption4);
        quizModelArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModelArrayList);
        currentPos = random.nextInt(quizModelArrayList.size());
        setDataToView(currentPos);

        //from here to line 93 is where the score will increment each time it has been answered correctly
        option1Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().
                        equals(option1Bt.getText().toString().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToView(currentPos);
            }
        });

        option2Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().
                        equals(option2Bt.getText().toString().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToView(currentPos);
            }
        });

        option3Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().
                        equals(option3Bt.getText().toString().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToView(currentPos);
            }
        });

        option4Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().
                        equals(option4Bt.getText().toString().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToView(currentPos);
            }
        });


        /**
        TextView theTextView = (TextView) findViewById(R.id.textView1);
        theTextView.setText("Welcome to the Quiz App!");
        String stringFromTextView = theTextView.getText().toString();
        Log.d(TAG, "onCreate: " + stringFromTextView);
         */
    }
    //This is were it will show the total score out of 10
    private void showScoreSheet(){
        BottomSheetDialog scoreSheetDialog = new BottomSheetDialog(MainActivity.this);
        View ScoreSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_sheet,
                (LinearLayout) findViewById(R.id.idLLScore));
        TextView scoreTV = ScoreSheetView.findViewById(R.id.idTVScore);
        Button restartQuiz = ScoreSheetView.findViewById(R.id.idButnRestart);
        scoreTV.setText("The score is " + currentScore + "/10");
        restartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToView(currentPos);
                questionAttempted = 1;
                currentScore = 0;
                scoreSheetDialog.dismiss();
            }
        });
        scoreSheetDialog.setCancelable(false);
        scoreSheetDialog.setContentView(ScoreSheetView);
        scoreSheetDialog.show();
    }

    //This is to make sure the users answered 10 questions or more if desire
    private void setDataToView(int currentPos){
        questionNumberTV.setText("Question you have attempted: " + questionAttempted + "/10");
        //Check if questions attempted has been 10 or change it if wanted to
        if (questionAttempted == 10){
            showScoreSheet();
        } else {
            questionTV.setText(quizModelArrayList.get(currentPos).getQuestion());
            option1Bt.setText(quizModelArrayList.get(currentPos).getOption1());
            option2Bt.setText(quizModelArrayList.get(currentPos).getOption2());
            option3Bt.setText(quizModelArrayList.get(currentPos).getOption3());
            option4Bt.setText(quizModelArrayList.get(currentPos).getOption4());
        }

    }

    //This is where the question will be added
    private void getQuizQuestion(ArrayList<QuizModel> quizModelArrayList) {
        //Question 1
        quizModelArrayList.add(new QuizModel("What is an app architecture?", "A buiding of apps.", "A structure of the app",
                "the patterns and techniques used to design and build an application.", "Just show people how the app was built",
                "the patterns and techniques used to design and build an application."));
        //Question 2
        quizModelArrayList.add(new QuizModel("Which one of these is not the stages in software engineering?", "Design.", "Maintenance.",
                "Implementation.", "Sketch.", "Sketch."));
        //Question 3
        quizModelArrayList.add(new QuizModel("What is the good of the spiral model?", "Risk management part of lifecycle.", "Project monitoring easily.",
                "Schedule and cost more realistic over time.", "All of the above.",
                "All of the above."));
        //Question 4
        quizModelArrayList.add(new QuizModel("Why do version control systems?", "Keep seperate branches of development.", "Roll back if introduce bugs.",
                "Track what changed between revisions of a project.", "All of the above.",
                "All of the above"));
        //Question 5
        quizModelArrayList.add(new QuizModel("What is the basic Version Control Systems operations?", "Check out/ update.", "Commit.",
                "Branch.", "All of the above.", "All of the above."));
        //Question 6
        quizModelArrayList.add(new QuizModel("Where would you set up a DB used in multiple tests?", "@Test", "@After",
                "@Before", "@BeforeClass", "@BeforeClass"));
        //Question 7
        quizModelArrayList.add(new QuizModel("Where would you tear down a DB used in multiple tests?", "@Test", "@After",
                "@Before", "@AfterClass", "@AfterClass"));
        //Question 8
        quizModelArrayList.add(new QuizModel("What is part of the distrubuted layered for software architecture?", "Client - Server", "Peer-to-peer",
                "All of the above", "None of the above", "All of the above"));
        //Question 9
        quizModelArrayList.add(new QuizModel("What does not describe an UML?", "Consists of several different diagram types.", "It is not a language but a method.",
                "Can be used at different abstraction levels.", "It is a graphical language for visualizing.",
                "It is not a language but a method."));
        //Question 10
        quizModelArrayList.add(new QuizModel("What does a class in UML consists of?", "Attributes", "Operations", "None of the above.",
                "All of the above.", "All of the above."));
        //Question 11
        quizModelArrayList.add(new QuizModel("What is not a step of the Spiral Model?", "Develop and verify prototype", "Determine objectives and constraints",
                "Lots of documents per iteration", "Plan next iteration", "Lots of documents per iteration"));
        //Question 12
        quizModelArrayList.add(new QuizModel("What's bad about the spiral model?", "Long iteration", "Cost of process is high",
                "Lots of rules to follow, hard for the whole project", "All of the above", "All of the above"));
        //Question 13
        quizModelArrayList.add(new QuizModel("What does agile development model features?", "Short iteration from 1 to 2 weeks", "It embraces changes",
                "It's Test-Driven development", "All of the above", "All of the above"));
        //Question 14
        quizModelArrayList.add(new QuizModel("What is white box testing?", "You can test the white box instead of black box", "You test a program when you are not familiar with the code",
                "Testing a system when you know the code", "Testing a system you didn't build", "Testing a system when you know the code"));
        //Question 15
        quizModelArrayList.add(new QuizModel("What is an example of Refactoring?", "Renaming a method", "Moving a field from one class to another",
                "Changing public methods to private", "All of the above", "All of the above"));
        //Question 16
        quizModelArrayList.add(new QuizModel("What is/are the stage of failure?", "Defect", "Infection",
                "Failure", "All of the above", "All of the above"));
        //Question 17
        quizModelArrayList.add(new QuizModel("Why should you simplify a test case?", "Easier to debug", "Identify duplicates",
                "Both of the above", "None of the above", "None of the above"));
        //Question 18
        quizModelArrayList.add(new QuizModel("What is Postcondition failure?", "Infection within method", "Object is in the bad state",
                "Infection before method", "Infection after method", "Infection within method"));
        //Question 19
        quizModelArrayList.add(new QuizModel("What is Precondition failure?", "Infection after method", "Object is in the bad state",
                "Infection within method", "Infection before method", "Infection before method"));
        //Question 20
        quizModelArrayList.add(new QuizModel("What is a Heisenbug?", "A bug that does show up on debug but does not show up in general execution",
                "A bug that does not show up in your code at all", "A bug that doesn't show up on debug but does show up in general execution",
                "A bug that does show up on debug but does show up in general execution",
                "A bug that doesn't show up on debug but does show up in general execution"));
    }
}