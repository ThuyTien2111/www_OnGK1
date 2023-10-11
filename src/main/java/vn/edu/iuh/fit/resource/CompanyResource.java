package vn.edu.iuh.fit.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.service.CompanyService;

@Path("/company")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompanyResource {
    private CompanyService companyService;

    public CompanyResource() {
        companyService= new CompanyService();
    }
    @POST
    @Path("/login")
    public Response loginCompany(@QueryParam("comp_id") long comp_id, @QueryParam("pass") String pass){
        boolean logged= companyService.logInCompany(comp_id, pass);
        if(logged) {
            return Response.status(Response.Status.OK).entity("Login succesfull").build();
        }else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Login failed").build();
        }

    }

}
