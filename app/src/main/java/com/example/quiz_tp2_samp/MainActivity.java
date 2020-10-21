package com.example.quiz_tp2_samp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private static final int CODE_CONSULTACTIVITY = 1 ;
    private static final int CODE_GESTIONACTIVITY = 2 ;
    public static final String CLE_1 = "key1";
    public static final String CLE_2 = "key2";


    private TextView question;
    private Button consultation;
    private Quiz quiz = new Quiz();
    private int numQuestion = 0;
    private int point = 0;
    private boolean showAnswer = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = findViewById(R.id.question);
        consultation = findViewById(R.id.consultation);
        question.setText(quiz.getListQuestions().get(0));
    }

    public void repVrai(View view) {
        if(numQuestion <  quiz.getListQuestions().size()) {
            if (quiz.getListReponse().get(numQuestion)) {
                String text;
                if(showAnswer){
                    text = "Vous avez vu la réponse !";
                }else{
                    text = "Correct !";
                }
                point++;
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Incorrect !", Toast.LENGTH_SHORT).show();
            }
            next(view);
        }
    }

    public void repFaux(View view) {
        if(numQuestion <  quiz.getListQuestions().size()) {
            if (!quiz.getListReponse().get(numQuestion)) {
                String text;
                if(showAnswer){
                    text = "Vous avez vu la réponse !";
                }else{
                    text = "Correct !";
                }
                point++;
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Incorrect !", Toast.LENGTH_SHORT).show();
            }
            next(view);
        }
    }

    public void next(View view) {
        showAnswer = false;
        if(numQuestion < quiz.getListQuestions().size()-1) {
            numQuestion++;
            question.setText(quiz.getListQuestions().get(numQuestion));
        }else{
            numQuestion++;
            String scoreAffichage = "Votre score final est de : " + point;
            question.setText(scoreAffichage);
        }

    }

    public void startConsult(View view) {
        if(numQuestion < quiz.getListQuestions().size()-1) {
            Intent intent = new Intent(MainActivity.this, ConsultActivity.class);
            intent.putExtra(CLE_1, quiz.getListReponse().get(numQuestion));
            startActivityForResult(intent, CODE_CONSULTACTIVITY);
        }
    }

    public void startGestion(View view) {
        Intent intent = new Intent(MainActivity.this, GestionActivity.class);
        intent.putExtra(CLE_1, quiz.getListQuestions());
        //intent.putExtra(CLE_2,quiz.getListReponse());
        ArrayList<String> arrayReponse = new ArrayList<>();
        for (int i = 0; i < quiz.getListReponse().size(); i++) {
            arrayReponse.add(i,quiz.getListReponse().get(i).toString());
        }
        intent.putExtra(CLE_2,arrayReponse);
        startActivityForResult(intent, CODE_GESTIONACTIVITY);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case CODE_CONSULTACTIVITY:
                if (resultCode == RESULT_OK) {
                    showAnswer = data.getExtras().getBoolean(CLE_1);
                }
                break;

            case CODE_GESTIONACTIVITY:
                if(resultCode == RESULT_OK){
                    System.out.println("retour gestion");
                }
                break;

            default:
                break;
        }
    }

    public void startQuiz(View view) {
        LinearLayout start = findViewById(R.id.layoutStart);
        LinearLayout game = findViewById(R.id.layoutGame);

        start.setVisibility(View.INVISIBLE);
        game.setVisibility(View.VISIBLE);
    }
}