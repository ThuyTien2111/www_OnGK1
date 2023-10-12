package vn.edu.iuh.fit.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.service.JobSkillService;

@Path("/job-skill")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JobSkillResource {
    private JobSkillService jobSkillService;

    public JobSkillResource() {
        jobSkillService=new JobSkillService();
    }
    @GET
    @Path("/calcProposedSalary/{id}")
    public Response calcProposedSalary(@PathParam("id") Long job_id){
        Integer rs= jobSkillService.calcProposedSalary(job_id);
        if(rs!=0){
            return Response.ok(rs).build();
        }else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
