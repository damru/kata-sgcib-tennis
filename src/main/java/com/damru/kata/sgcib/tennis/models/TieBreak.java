package com.damru.kata.sgcib.tennis.models;

import com.damru.kata.sgcib.tennis.enums.Point;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by damien on 18/11/2016.
 */
public class TieBreak extends Jeu{

    private Map<Joueur, Integer> scores;

    public TieBreak() {
        this.scores = new HashMap<Joueur,Integer>();
    }

    public TieBreak(Joueur joueur1, Joueur joueur2) {
        this();
        this.addScore(joueur1, 0);
        this.addScore(joueur2, 0);
    }

    public Map getScores() {
        return this.scores;
    }

    public void addScore(Joueur jouer, Integer point) {
        this.scores.put(jouer, point);
    }

}
