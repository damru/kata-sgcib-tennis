package com.damienrubio.kata.tennis.controllers;

import com.damienrubio.kata.tennis.models.Joueur;
import com.damienrubio.kata.tennis.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by damien on 21/11/2016.
 */
@RestController
@RequestMapping("/joueur")
public class JoueurController {

    @Autowired
    private MatchService matchService;

    @RequestMapping(value = "/creer", method = RequestMethod.GET)
    public Joueur creer(
            @RequestParam(value="nom") String nom
            , @RequestParam String prenom) {
        return new Joueur(nom,prenom);
    }

    @RequestMapping(value = "/{joueurId}", method = RequestMethod.POST)
    public Joueur afficher(@PathVariable String joueurId
            , @RequestBody Joueur joueur) {
        return joueur;
    }

}
