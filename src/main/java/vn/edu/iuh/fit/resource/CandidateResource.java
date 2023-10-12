package vn.edu.iuh.fit.resource;

import vn.edu.iuh.fit.entity.Candidate;
import vn.edu.iuh.fit.service.CandidateService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;
import java.util.Map;

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
    @GET
    @Path("/getCandByYearBorn")
    public Response getCandByYearBorn(){
        Map<Integer, Long> map= candidateService.getCandByYearBorn();
        if(map!=null){
            return Response.ok(map).build();
        }else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    @GET
    @Path("/getTotalSkillByCand")
    public Response getTotalSkillByCand(){
        Map<Candidate, Long> map= candidateService.getTotalSkillByCand();
        if(map!=null){
            return Response.ok(map).build();
        }else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    @GET
    @Path("/getTotalJobSkillByCand")
    public Response getTotalJobSkillByCand(){
        Map<Candidate, Long> map= candidateService.getTotalJobSkillByCand();
        if(map!=null){
            return Response.ok(map).build();
        }else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }



}