package com.damienrubio.kata.tennis.controllers;

import com.damienrubio.kata.tennis.models.Joueur;
import com.damienrubio.kata.tennis.services.MatchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@Api(value = "/joueur",
     description = "Gestion des joueurs.")
@Produces(MediaType.APPLICATION_JSON)
@Path("/joueur")
@Slf4j
public class JoueurController {

    @Autowired
    private MatchService matchService;

    @ApiOperation(value = "Créer un nouveau joueur",
                  notes = "Retourne un nouveau joueur",
                  response = Joueur.class)
    @ApiResponse(code = 200,
                 message = "Le joueur est créé")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/creer")
    public Response creer(@ApiParam("Nom du joueur à créer") @QueryParam("nom") String nom,
                          @ApiParam("Prénom du joueur à créer") @QueryParam("prenom") String prenom) {
        return Response.ok(new Joueur(nom, prenom)).build();
    }

    @ApiOperation(value = "Afficher un joueur",
                  notes = "Affiche un joueur",
                  response = Joueur.class)
    @ApiResponse(code = 200,
                 message = "Le joueur est affiché")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{joueurId}")
    public Response afficher(@ApiParam("Id du joueur à afficher") @PathParam("joueurId") Long joueurId,
                             @ApiParam("Joueur à afficher") @RequestBody Joueur joueur) {
        return Response.ok(joueur).build();
    }

}
