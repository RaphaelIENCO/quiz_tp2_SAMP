package com.example.quiz_tp2_samp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class GestionAdapter extends RecyclerView.Adapter<GestionAdapter.ViewHolder> {

    Context ctx;
    private List<String> listQuestions;
    private List<String> listReponse;

    public GestionAdapter(Context context, List<String> questions, List<String> reponses){
        ctx = context;
        listQuestions = questions;
        listReponse = reponses;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView texte;

        public ViewHolder(View itemView) {
            super(itemView);
            texte = (TextView)itemView.findViewById(R.id.texte);
        }
    }


    @NonNull
    @Override
    public GestionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_question,parent,false);
        GestionAdapter.ViewHolder vh = new GestionAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
        final String name = listQuestions.get(position) + " - " + listReponse.get(position);
        holder.texte.setText(name);
        holder.texte.setOnClickListener(v->{
            Toast.makeText(ctx,listQuestions.get(holder.getAdapterPosition()),Toast.LENGTH_LONG).show();});

    }

    @Override
    public int getItemCount() {
        return listQuestions.size();
    }
}
