package ru.alfabank.bcm.optionmanagment.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/teamMember")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class TeamMemberApi {
    @GET
    public Response getProducts() {
        return Response.ok("Welcome to Hell").build();
    }
    /*private final TeamMemberService teamMemberService;
    Gson gson = new Gson();

    public TeamMemberApi(@ComponentImport TeamMemberService teamMemberService) {
        this.teamMemberService = teamMemberService;
    }

    @GET
    @Path("/allForObject")
    public Response getAllTeamMembers() {
        return Response.ok(gson.toJson(teamMemberService.all())).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response saveTeamMember(@Context HttpServletRequest request, TeamMemberDTO teamMember){
        return Response.ok(gson.toJson(teamMemberService.add(teamMember))).build();
    }*/
}
