package com.damru.kata.sgcib.tennis.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by damien on 18/11/2016.
 */
public class Set {

    @Getter
    @Setter
    private List<Jeu> jeux;

    @Getter
    @Setter
    private Joueur vainqueur;

    @Getter
    @Setter
    private boolean enCours;

    public Set() {
        jeux = new ArrayList<Jeu>();
        Jeu jeu = new Jeu();
        jeu.setEnCours(true);
        jeux.add(jeu);
    }
}