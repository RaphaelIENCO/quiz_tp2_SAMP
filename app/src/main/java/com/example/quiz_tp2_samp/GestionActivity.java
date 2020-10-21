package com.example.quiz_tp2_samp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class GestionActivity extends AppCompatActivity {
    private ArrayList<String> listQuestions;
    private ArrayList<String> listReponse;

    private RecyclerView vueQuestions;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion);
        Intent data = getIntent();


        this.listQuestions = data.getExtras().getStringArrayList(MainActivity.CLE_1);
        this.listReponse = data.getExtras().getStringArrayList(MainActivity.CLE_2);

        System.out.println(listQuestions);
        System.out.println(listReponse);

        vueQuestions = (RecyclerView)findViewById(R.id.vue_questions);
        layoutManager = new LinearLayoutManager(this);
        vueQuestions.setLayoutManager(layoutManager);
        adapter = new GestionAdapter(this,listQuestions,listReponse);
        vueQuestions.setAdapter(adapter);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback =
              new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP| ItemTouchHelper.DOWN, ItemTouchHelper.LEFT| ItemTouchHelper.RIGHT) {
                  @Override
                  public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder source, @NonNull RecyclerView.ViewHolder target) {
                      if(source.getItemViewType() != target.getItemViewType()){ return false;}
                      return true;
                  }

                  @Override
                  public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                  }
              };

    }


    @Override
    public void finish(){
        Intent data = new Intent();
        data.putExtra(MainActivity.CLE_1,listQuestions);
        data.putExtra(MainActivity.CLE_2,listReponse);
        setResult(RESULT_OK,data);
        super.finish();
    }

    public void backGestion(View view) { finish(); }
}
