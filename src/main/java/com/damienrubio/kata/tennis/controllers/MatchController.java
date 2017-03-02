package com.damienrubio.kata.tennis.controllers;

import com.damienrubio.kata.tennis.models.Joueur;
import com.damienrubio.kata.tennis.models.Match;
import com.damienrubio.kata.tennis.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * Created by damien on 21/11/2016.
 */
@RestController
@Path("/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @Path("/")
    public String home() {
        return "match controller";
    }

    @Path(value = "/creer")
    @POST
    public Match creer(@RequestBody Joueur joueur1, @RequestBody Joueur joueur2,
                       @QueryParam("nbSets") @DefaultValue("2") int nbSetsGagnants) {
        return new Match(joueur1, joueur2, nbSetsGagnants);
    }

    @Path(value = "/{matchId}")
    @POST
    public Match afficher(@RequestBody Match match) {
        return match;
    }

    @Path(value = "/marquer")
    @POST
    public Match marquer(@RequestBody Match match, @RequestBody Joueur joueur) {
        matchService.marquerPoint(match, joueur);
        return match;
    }

}
