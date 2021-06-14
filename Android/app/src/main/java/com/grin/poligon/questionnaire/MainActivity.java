package com.grin.poligon.questionnaire;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.text.InputType;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.grin.poligon.R;
import com.grin.poligon.questionnaire.data.Options;
import com.grin.poligon.questionnaire.data.Question;
import com.grin.poligon.questionnaire.data.QuestionSet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String QUESTION_NUMBER = "QUESTION_NUMBER";
    public static final String QUESTIONS = "QUESTIONS";

    private TextView questionTextView;
    private TextView numOfQuestionsTextView;
    private LinearLayout optionsLinearLayout;
    private ProgressBar progressBar;
     private Button nextButton;
    private Button prevButton;

    private int qNumber;
    private int totalQuestions;
    private ArrayList<Question> questions;
    private boolean answered;

    private Options optionsType;
    private View optionsView;
    private Toast toast;

    private View.OnClickListener nextButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            //save current set answer before displaying the next question
            saveUserAnswer();

            //if the current question is unanswered, alert the user as all questions are mandatory
            if (!answered) {
                alertQuestionUnanswered();
                return;
            }

            /*
            increment the question number and display the next question
            or display the results if it's the last question after confirming for submission from the user
             */
            qNumber++;
            if (qNumber < questions.size()) {
                displayQuestion();
            } else {
                qNumber--;
                displayConfirmAlert("Построить модель", false);
            }
        }
    };


    private View.OnClickListener prevButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //save current set answer before displaying the previous question
            saveUserAnswer();

            /*
            decrement the question number and display the previous question
            if this is the first question, display a toast message stating there are no previous questions
             */
            if (qNumber > 0) {
                qNumber--;
                displayQuestion();
            } else {
                alertNoPrevQuestions();
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main44);

        //obtain references to all the views in the main activity
        questionTextView = findViewById(R.id.question_text);
        numOfQuestionsTextView = findViewById(R.id.questions_remaining);
        optionsLinearLayout = findViewById(R.id.linearLayout_Options);
        progressBar = findViewById(R.id.determinantProgressBar);

        //register the click events for the previous and next buttons
        prevButton = findViewById(R.id.prev_button);
        prevButton.setOnClickListener(prevButtonClickListener);
        nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(nextButtonClickListener);

        //set up the listener for 'mark for review' option

        //implement the review button click functionality to display the questions marked for review
        ImageButton reviewButton = findViewById(R.id.review_button);
        reviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserAnswer();
             }
        });

        //get all the questions and determine the total number of questions
        questions = QuestionSet.getAllQuestions(this);
        totalQuestions = questions.size();

        //set progress bar max value
        progressBar.setMax(totalQuestions);

        displayQuestion();
    }

    private void displayQuestion() {

        //remove previous question and it's corresponding options
        optionsLinearLayout.removeAllViews();

        //update the state of 'mark for review' TextView appropriately
       
        //display the current question number and total number of questions
        String text = (qNumber + 1) + "/" + totalQuestions;
        numOfQuestionsTextView.setText(text);

        //update the progress bar status
        progressBar.setProgress(qNumber);

        if (answered)
            answered = false;

        Question currentSet = questions.get(qNumber);
        questionTextView.setText(currentSet.getQuestion());

        //set the button for last question to be 'Submit', rather than 'Next'
        if (qNumber == questions.size() - 1) {
            nextButton.setText("Построить модель");
        } else {
            nextButton.setText("Далее");
        }

        displayOptions();

    }

    private void displayOptions() {

        //get the current question and it's options
        Question question = questions.get(qNumber);
        String[] options = question.getOptions();
        Options currentOptionsType = question.getOptionsType();

        switch (currentOptionsType) {

            case RADIOBUTTON:
                //For the case of radiobuttons, create a RadioGroup and add each option as a RadioButton
                //to the group - set an ID for each RadioButton to be referred later
                RadioGroup radioGroup = new RadioGroup(this);
                for (int i = 0; i < options.length; i++) {
                    RadioButton button = new RadioButton(this);
                    button.setText(options[i]);
                    button.setId(i);
                    radioGroup.addView(button);

                }
                optionsLinearLayout.addView(radioGroup);

                //restore saved answers
                if (question.getUserSetAnswerId() != null && question.getUserSetAnswerId().size() > 0) {
                    RadioButton radioButton = (RadioButton) radioGroup.getChildAt(question.getUserSetAnswerId().get(0));
                    radioButton.setChecked(true);
                }

                optionsView = radioGroup;
                break;


            case CHECKBOX:
                //For the case of check boxes, create a new CheckBox for each option
                for (String option : options) {
                    CheckBox checkbox = new CheckBox(this);
                    checkbox.setText(option);
                    optionsLinearLayout.addView(checkbox);
                }

                //restore saved answers
                if (question.getUserSetAnswerId() != null && question.getUserSetAnswerId().size() > 0) {
                    for (int index : question.getUserSetAnswerId()) {
                        ((CheckBox) optionsLinearLayout.getChildAt(index)).setChecked(true);
                    }
                }
                optionsView = optionsLinearLayout;
                break;

            case EDITTEXT:
                //For the case of edit text, display an EditText for the user to enter the answer
                EditText editText = new EditText(this);
                //set the InputType to display digits only keyboard if applicable
                if (TextUtils.isDigitsOnly(questions.get(qNumber).getAnswer())) {
                    editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                }

                //restore saved answers, set hint text if answer is empty/remains unanswered
                if (!TextUtils.isEmpty(question.getUserAnswer())) {
                    editText.setText(question.getUserAnswer());
                    editText.setSelection(question.getUserAnswer().length());
                } else {
                    editText.setHint("Введите ваше хобби");
                }

                optionsLinearLayout.addView(editText);

                optionsView = editText;
                break;
        }
        optionsType = currentOptionsType;
    }


    private void saveUserAnswer() {

        if (qNumber < questions.size()) {
            Question currentQuestion = questions.get(qNumber);
            ArrayList<Integer> userSelectedAnswers = new ArrayList<>();

            String answer;

            switch (optionsType) {
                case RADIOBUTTON:
                    //save the selected RadioButton IDs
                    int selectedId = ((RadioGroup) optionsView).getCheckedRadioButtonId();
                    RadioButton selectedRadioButton = findViewById(selectedId);

                    if (selectedRadioButton == null) {
                        return;
                    } else {
                        userSelectedAnswers.add(selectedId);
                        currentQuestion.setUserSetAnswerId(userSelectedAnswers);
                        answered = true;
                    }
                    break;

                case CHECKBOX:
                    //save checkbox IDs that have been checked by the user
                    LinearLayout parentLayout = (LinearLayout) optionsView;
                    int numOfCheckBox = parentLayout.getChildCount();
                    for (int i = 0; i < numOfCheckBox; i++) {
                        CheckBox childCheckBox = (CheckBox) parentLayout.getChildAt(i);
                        if (childCheckBox.isChecked()) {
                            userSelectedAnswers.add(i);
                            answered = true;
                        }
                    }
                    currentQuestion.setUserSetAnswerId(userSelectedAnswers);
                    break;

                case EDITTEXT:
                    //save the EditText answer
                    EditText answerText = (EditText) optionsView;
                    answer = answerText.getText().toString();
                    if (!TextUtils.isEmpty(answer)) {
                        currentQuestion.setUserAnswer(answer);
                        answered = true;
                    } else {
                        currentQuestion.setUserAnswer(null);
                    }
                    break;
            }
        }
    }


    private void setMarkerForReview(View v) {
        if (!questions.get(qNumber).isMarkedForReview()) {
            questions.get(qNumber).setMarkedForReview(true);
            ((TextView) v).setCompoundDrawablesWithIntrinsicBounds(R.drawable.red2_style, 0, 0, 0);
        } else {
            questions.get(qNumber).setMarkedForReview(false);
            ((TextView) v).setCompoundDrawablesWithIntrinsicBounds(R.drawable.red2_style, 0, 0, 0);
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        saveUserAnswer();

        outState.putInt(QUESTION_NUMBER, qNumber);
        outState.putSerializable(QUESTIONS, questions);
    }


    /**
     * restore state of the quiz on activity resumes after stop/pause
     * @param savedInstanceState provides access to the data prior to activity resume
     */
    @Override
    @SuppressWarnings("unchecked")
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        qNumber = savedInstanceState.getInt(QUESTION_NUMBER);
        questions = (ArrayList<Question>) savedInstanceState.getSerializable(QUESTIONS);

        displayQuestion();
    }

    /**
     * display an alert toast message to the user
     * if the next button is clicked without answering the current question
     */
    private void alertQuestionUnanswered() {
        cancelToast();

        toast = Toast.makeText(this,"Ответьте на вопрос для продолжения", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 258);
        toast.show();
    }

    /**
     * when the previous button is clicked while in the first questions
     * display a toast message stating there are no previous questions
     */
    private void alertNoPrevQuestions() {
        cancelToast();

        toast = Toast.makeText(MainActivity.this, R.string.action_settings, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 258);
        toast.show();
    }

    /**
     * method to handle canceling of any previously displayed toast before displaying new one
     */
    private void cancelToast() {
        if (toast != null)
            toast.cancel();
    }

    /**
     * Navigate to new activity when user presses submit button
     * pass the questions object in the intent to be used by the ResultsActivity
     */
    private void displayResults() {
        Intent intent = new Intent(MainActivity.this,
                ResultsActivity.class);
        intent.putExtra(QUESTIONS, questions);
        startActivity(intent);
        finish();
    }

    /**
     * Navigate to new activity when user presses review list button
     * - pass the questions object in the intent to be used by the ReviewAnswersActivity
     */


    /**
     * display submission confirmation dialog to the user after all questions have been answered
     * display quiz activity exit confirmation if the back is pressed while the quiz is still ongoing
     */
    private void displayConfirmAlert(String message, final boolean isBackPressed) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setPositiveButton("Подтвердить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(isBackPressed) {
                            finish();
                        } else {

                            startActivity(new Intent(MainActivity.this, com.grin.poligon.adam.MainActivity.class));
                            //    displayResults();
                        }
                    }
                })
                .setNegativeButton("Назад", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(dialog != null) {
                            dialog.dismiss();
                        }
                    }
                })
                .create()
                .show();
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            qNumber = intent.getIntExtra(QUESTION_NUMBER, 0);
            displayQuestion();
        }
    }

    /**
     * if back is pressed while taking the quiz, alert the user that the answers will be lost
     * and confirm exiting the quiz activity
     */
    @Override
    public void onBackPressed() {
        displayConfirmAlert("Выйти из теста?", true);
    }
}
