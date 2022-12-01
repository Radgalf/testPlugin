package ru.alfabank.bcm.optionmanagment.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class HelloApi {
    @GET
    public Response getProducts() {
        return Response.ok("Welcome to Hell").build();
    }
}
