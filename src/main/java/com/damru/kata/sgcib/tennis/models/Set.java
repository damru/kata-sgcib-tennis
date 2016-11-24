package com.damru.kata.sgcib.tennis.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by damien on 18/11/2016.
 */
@Data
@Entity
public class Set {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<Jeu> jeux;

    @OneToOne
    private Joueur vainqueur;

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