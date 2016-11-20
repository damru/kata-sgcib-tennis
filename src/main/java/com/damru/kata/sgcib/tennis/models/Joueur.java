package com.damru.kata.sgcib.tennis.models;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by damien on 18/11/2016.
 */
public class Joueur {

    public Joueur(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    @Getter
    @Setter
    private String nom;

    @Getter
    @Setter
    private String prenom;

}
