package com.damru.kata.sgcib.tennis.models;

import com.damru.kata.sgcib.tennis.enums.Point;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * Created by damien on 18/11/2016.
 */
public class Match {

    @Getter @Setter
    private ArrayList<Set> partie;

    @Getter @Setter
    private Joueur joueur1;

    @Getter @Setter
    private Joueur joueur2;

    @Getter @Setter
    private Joueur vainqueur;

    @Getter @Setter
    int setsGagnants;

    public Match() throws Exception {
        throw new Exception("Un match a besoin de 2 joueurs.");
    }

    public Match(Joueur j1, Joueur j2) {
        this.setsGagnants = 2;
        this.joueur1 = j1;
        this.joueur2 = j2;
        this.partie = new ArrayList<Set>();
        Set set = new Set();
        set.setEnCours(true);
        partie.add(set);
        set.getJeux().get(0).getScores().put(this.getJoueur1(), Point.NUL);
        set.getJeux().get(0).getScores().put(this.getJoueur2(), Point.NUL);
        set.getJeux().get(0).setEnCours(true);
    }

    public Match(Joueur j1, Joueur j2, int setsGagnants) {
        this(j1, j2);
        this.setsGagnants = setsGagnants;
    }
}
