package com.damienrubio.kata.tennis.controllers;

import com.damienrubio.kata.tennis.models.Joueur;
import com.damienrubio.kata.tennis.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Created by damien on 21/11/2016.
 */
@RestController
@RequestMapping("/joueur")
public class JoueurController {

    @Autowired
    private MatchService matchService;

    @Path(value = "/creer")
    @POST
    public Joueur creer(
            @RequestParam(value="nom") String nom
            , @RequestParam String prenom) {
        return new Joueur(nom,prenom);
    }

    @Path(value = "/{joueurId}")
    @POST
    public Joueur afficher(@PathVariable String joueurId
            , @RequestBody Joueur joueur) {
        return joueur;
    }

}
