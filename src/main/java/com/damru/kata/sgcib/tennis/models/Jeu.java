package com.damru.kata.sgcib.tennis.models;

import com.damru.kata.sgcib.tennis.enums.Point;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by damien on 18/11/2016.
 */
public class Jeu {

    private Map<Joueur, Point> scores;

    @Getter @Setter
    private boolean enCours;

    @Getter @Setter
    private Joueur vainqueur;

    public Jeu() {
        this.scores = new HashMap<Joueur,Point>();
    }

    public Jeu(Joueur joueur1, Joueur joueur2) {
        this();
        this.addScore(joueur1, Point.NUL);
        this.addScore(joueur2, Point.NUL);
    }

    public Map getScores() {
        return this.scores;
    }

    public void setScores(Map scores) {
        this.scores = scores;
    }

    public void addScore(Joueur jouer, Point point) {
        this.scores.put(jouer, point);
    }
}
