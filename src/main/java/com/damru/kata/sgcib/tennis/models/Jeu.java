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

    @Getter
    @Setter
    private Map<Joueur, Point> scores;

    @Getter
    @Setter
    private boolean enCours;

    @Getter
    @Setter
    private Joueur vainqueur;

    public Jeu() {
        this.scores = new HashMap<Joueur,Point>();
    }

}
