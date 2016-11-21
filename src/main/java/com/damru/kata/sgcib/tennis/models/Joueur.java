package com.damru.kata.sgcib.tennis.models;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * Created by damien on 18/11/2016.
 */
@Data
public class Joueur {

    @Getter @Setter @NonNull
    private String nom;

    @Getter @Setter @NonNull
    private String prenom;

}
