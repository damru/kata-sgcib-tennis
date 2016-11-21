package com.damru.kata.sgcib.tennis.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;

/**
 * Created by damien on 18/11/2016.
 */
public class Match {

    @Getter
    @Setter
    private ArrayList<Set> partie;

    @Getter
    @Setter
    @NonNull
    private Joueur joueur1;

    @Getter
    @Setter
    @NonNull
    private Joueur joueur2;

    @Getter
    @Setter
    private Joueur vainqueur;

    @Getter
    @Setter
    int nbSetsGagnants = 2;

    public Match() throws Exception {
        throw new Exception("Un match se déroule obligatoirement entre 2 joueurs.");
    }

    public Match(Joueur j1, Joueur j2) {
        this.partie = new ArrayList<Set>();
        this.joueur1 = j1;
        this.joueur2 = j2;
        Set set = new Set(j1,j2);
        set.setEnCours(true);
        this.addSet(set);
    }

    public Match(Joueur j1, Joueur j2, int nbSetsGagnants) {
        this(j1, j2);
        this.nbSetsGagnants = nbSetsGagnants;
    }

    public void addSet(Set set) {
        this.partie.add(set);
    }
}
