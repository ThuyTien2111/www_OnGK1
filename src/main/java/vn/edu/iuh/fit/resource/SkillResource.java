package vn.edu.iuh.fit.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.entity.Skill;
import vn.edu.iuh.fit.service.SkillService;

import java.util.List;

@Path("/skill")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SkillResource {
    private SkillService skillService;

    public SkillResource() {
        skillService=new SkillService();
    }
    @GET
    @Path("/{id}")
    public Response getSkillByID(@PathParam("id") long skill_id){
        Skill skill=skillService.getSkillByID(skill_id);
        if(skill!=null){
            return Response.ok(skill).build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    @GET
    public Response getAllSkill(){
       List<Skill> rs= skillService.getAllSkill();
       if(rs!=null){
           return Response.ok(rs).build();
       }else {
           return Response.status(Response.Status.NOT_FOUND).build();
       }
    }
    @POST
    public Response addSkill(Skill skill) {
        if (skillService.addSkill(skill)) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid skill type").build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateSkill(@PathParam("id") long id, Skill skill) {
        if (skillService.updateSkill(skill)) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid skill type").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteSkill(@PathParam("id") long id) {
        if (skillService.deleteSkill(id)) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}/activate")
    public Response activateSkill(@PathParam("id") long id) {
        if (skillService.activeSkill(id)) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
