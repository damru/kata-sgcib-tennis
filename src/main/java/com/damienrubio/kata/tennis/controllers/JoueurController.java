package com.damienrubio.kata.tennis.controllers;

import com.damienrubio.kata.tennis.models.Joueur;
import com.damienrubio.kata.tennis.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by damien on 21/11/2016.
 */
@RestController
@Path("/joueur")
public class JoueurController {

    @Autowired
    private MatchService matchService;

    @Path("/creer")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Joueur creer(@QueryParam("nom") String nom, @QueryParam("prenom") String prenom) {
        return new Joueur(nom, prenom);
    }

    @Path("/{joueurId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Joueur afficher(@RequestBody Joueur joueur) {
        return joueur;
    }

}
