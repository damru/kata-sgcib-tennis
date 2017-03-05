package com.damienrubio.kata.tennis.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by damien on 04/03/2017.
 */
@Produces(MediaType.TEXT_PLAIN)
@Path("/")
public class DefaultResource {

    @GET
    public Response home() {
        return Response.ok("Kata Tennis API").build();
    }
}
