package vn.edu.iuh.fit.resource;

import vn.edu.iuh.fit.service.CandidateService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/candidates")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CandidateResource {
    private CandidateService candidateService;

    public CandidateResource() {
        candidateService = new CandidateService();
    }
    @POST
    @Path("/login")
    public Response logInCandidate(@QueryParam("cand_id") long candId, @QueryParam("pass") String password) {
        boolean loggedIn = candidateService.logInCandidate(candId, password);
        if (loggedIn) {
            return Response.status(Response.Status.OK).entity("Login successful").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Login failed").build();
        }
    }

}