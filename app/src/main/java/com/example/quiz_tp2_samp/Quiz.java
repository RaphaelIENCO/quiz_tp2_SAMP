package com.example.quiz_tp2_samp;

import java.util.ArrayList;
import java.util.Arrays;

public class Quiz {
    private ArrayList<String> listQuestions;
    private ArrayList<Boolean> listReponse;

    public Quiz(){
        listQuestions = new ArrayList<String>();
        listReponse = new ArrayList<Boolean>();
        this.addAll();
    }

    public void addAll(){
        listQuestions.addAll(Arrays.asList("Le diable de Tasmanie vit dans la jungle du Brésil",
                "La sauterelle saute l'équivalent de 200 fois sa taille",
                "Les pandas hibernent",
                "On trouve des dromadaires en liberté en Australie",
                "Le papillon monarque vole plus de 4000km",
                "Les gorilles mâles dorment dans les arbres"
        ));

        listReponse.addAll(Arrays.asList(false,
                true,
                false,
                true,
                true,
                false
        ));
    }

    public ArrayList<Boolean> getListReponse() {
        return listReponse;
    }

    public ArrayList<String> getListQuestions() {
        return listQuestions;
    }

    public void add(String question, boolean reponse){
        listQuestions.add(question);
        listReponse.add(reponse);
    }

    public void add(int position, String question, boolean reponse){
        listQuestions.add(position,question);
        listReponse.add(position, reponse);
    }

    public void remove(int position){
        listQuestions.remove(position);
        listReponse.remove(position);
    }
}
