package com.damru.kata.sgcib.tennis.models;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by damien on 18/11/2016.
 */
@Data
@Entity
public class Joueur {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String nom;

    @NonNull
    private String prenom;

}
