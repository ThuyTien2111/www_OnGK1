package vn.edu.iuh.fit.resource;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.entity.Candidate;
import vn.edu.iuh.fit.service.ExperienceService;

import java.util.List;

@Path("/experience")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExperienceResource {
    private ExperienceService experienceService;

    public ExperienceResource() {
        experienceService=new ExperienceService();
    }
    @GET
    @Path("/getMaxExpYearCandidate")
    public Response getMaxExpYearCandidate(){
        List<Candidate> rs= experienceService.getMaxExpYearCandidate();
        if(rs!=null){
            return Response.ok(rs).build();
        }else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    @GET
    @Path("/getNotHaveExpCandidate")
    public Response getNotHaveExpCandidate(){
        List<Candidate> rs= experienceService.getNotHaveExpCandidate();
        if(rs!=null){
            return Response.ok(rs).build();
        }else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
