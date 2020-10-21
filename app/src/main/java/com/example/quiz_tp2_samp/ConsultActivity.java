package com.example.quiz_tp2_samp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConsultActivity extends AppCompatActivity {
    boolean reponse = false;
    boolean vueReponse = false;
    TextView reponseAffichage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        Intent data = getIntent();
        reponseAffichage = findViewById(R.id.reponse);

        reponse = data.getExtras().getBoolean(MainActivity.CLE_1);
    }

    public void back(View view) {
        finish();
    }

    @Override
    public void finish(){
        Intent data = new Intent();
        data.putExtra(MainActivity.CLE_1,vueReponse);
        setResult(RESULT_OK,data);
        super.finish();
    }

    public void showReponse(View view) {
        vueReponse = true;
        reponseAffichage.setText(Boolean.toString(reponse));
    }
}
