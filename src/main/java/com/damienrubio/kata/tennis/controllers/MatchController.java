package com.damienrubio.kata.tennis.controllers;

import com.damienrubio.kata.tennis.models.Joueur;
import com.damienrubio.kata.tennis.models.Match;
import com.damienrubio.kata.tennis.services.MatchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by damien on 21/11/2016.
 */
@Api(value = "/match",
     description = "Gestion des matchs.")
@Produces(MediaType.APPLICATION_JSON)
@RestController
@Path("/match")
@Slf4j
public class MatchController {

    @Autowired
    private MatchService matchService;

    @Path("/")
    public String home() {
        return "match controller";
    }

    @ApiOperation(value = "Créer un nouveau match",
                  notes = "Retourne un nouveau match",
                  response = Match.class)
    @ApiResponse(code = 200,
                 message = "Le match est créé")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/creer")
    public Response creer(@ApiParam("Joueur1 du match à créer") @RequestBody Joueur joueur1,
                          @ApiParam("Joueur2 du match à créer") @RequestBody Joueur joueur2,
                          @ApiParam("Nombre de sets nécessaires pour gagner le match") @QueryParam("nbSets") @DefaultValue("2")
                              int nbSetsGagnants) {
        return Response.ok(new Match(joueur1, joueur2, nbSetsGagnants)).build();
    }

    @ApiOperation(value = "Afficher un match",
                  notes = "Affiche un match",
                  response = Match.class)
    @ApiResponse(code = 200,
                 message = "Le match est créé")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/{matchId}")
    public Response afficher(@ApiParam("Id du match à afficher") @PathParam("matchId") Long matchId,
                             @ApiParam("Match à afficher") @RequestBody Match match) {
        return Response.ok(match).build();
    }

    @ApiOperation(value = "Un joueur marque un point dans le match",
                  notes = "Le joueur marque",
                  response = Match.class)
    @ApiResponse(code = 200,
                 message = "Le joueur a marqué un point")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/marquer")
    public Response marquer(@ApiParam("Match dans lequel un point est marqué") @RequestBody Match match,
                            @ApiParam("Joueur marquant le point") @RequestBody Joueur joueur) {
        matchService.marquerPoint(match, joueur);
        return Response.ok(match).build();
    }

}
