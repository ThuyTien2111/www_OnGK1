package vn.edu.iuh.fit.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.entity.Candidate;
import vn.edu.iuh.fit.entity.Job;
import vn.edu.iuh.fit.entity.Skill;
import vn.edu.iuh.fit.service.CandidateSkillService;

import java.util.List;

@Path("/cand_skill")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CandidateSkillResource {
    private CandidateSkillService candidateSkillService;

    public CandidateSkillResource() {
        candidateSkillService=new CandidateSkillService();
    }
    @GET
    @Path("/getJobForCandidateOrderBySkill/{cand_id}")
    public Response getJobForCandidateOrderBySkil(@PathParam("cand_id") long cand_id){
        List<Job> rs= candidateSkillService.getJobForCandidateOrderBySkill(cand_id);
        if(rs!=null){
            return Response.ok(rs).build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    @GET
    @Path("/getSkillNotHaveToLearn/{cand_id}")
    public Response getSkillNotHaveToLearn(@PathParam("cand_id") long cand_id){
        List<Skill> rs=candidateSkillService.getSkillNotHaveToLearn(cand_id);
        if(rs!=null){
            return Response.ok(rs).build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/getCandidateOrderBySkill/{skill_id}")
    public Response getCandidateOrderBySkill(@PathParam("skill_id") long skill_id){
        List<Candidate> rs= candidateSkillService.getCandidateOrderBySkill(skill_id);
        if(rs!=null){
           return Response.ok(rs).build();
        }else {
           return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

}