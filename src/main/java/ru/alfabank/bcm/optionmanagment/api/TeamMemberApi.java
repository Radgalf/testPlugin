package ru.alfabank.bcm.optionmanagment.api;

import com.google.gson.Gson;
import ru.alfabank.bcm.optionmanagment.model.TeamMemberDTO;
import ru.alfabank.bcm.optionmanagment.services.TeamMemberService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@Path("/teamMember")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class TeamMemberApi {
    private final TeamMemberService teamMemberService;
    Gson gson = new Gson();

    public TeamMemberApi(TeamMemberService teamMemberService) {
        this.teamMemberService = teamMemberService;
    }

    @GET
    @Path("/allForObject")
    public Response getAllTeamMembers() {
        return Response.ok(gson.toJson(teamMemberService.all().stream().map(TeamMemberDTO::new).collect(Collectors.toList()))).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response saveTeamMember(@Context HttpServletRequest request, TeamMemberDTO teamMember) {
        return Response.ok(gson.toJson(teamMemberService.add(teamMember))).build();
    }
}
