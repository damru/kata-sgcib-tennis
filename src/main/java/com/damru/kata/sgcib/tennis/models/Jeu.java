package com.damru.kata.sgcib.tennis.models;

import com.damru.kata.sgcib.tennis.enums.Point;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by damien on 18/11/2016.
 */
@Data
@Entity
public class Jeu {

    @Id
    private Long id;

    @OneToMany
    private Map<Joueur, Point> scores;

    private boolean enCours;

    @OneToOne
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
