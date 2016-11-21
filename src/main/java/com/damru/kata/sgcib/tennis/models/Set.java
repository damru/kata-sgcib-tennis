package com.damru.kata.sgcib.tennis.models;

import com.damru.kata.sgcib.tennis.enums.Point;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
        this.jeux = new ArrayList<Jeu>();
    }

    public Set(Joueur j1, Joueur j2) {
        this();
        Jeu jeu = new Jeu(j1,j2);
        jeu.setEnCours(true);
        this.addJeu(jeu);
    }

    public void addJeu(Jeu jeu) {
        this.jeux.add(jeu);
    }
}