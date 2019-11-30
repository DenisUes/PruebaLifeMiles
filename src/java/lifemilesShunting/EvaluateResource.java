/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifemilesShunting;

import com.sun.jersey.core.header.MediaTypes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Pavilion
 */
@Path("evaluate")
public class EvaluateResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EvaluateResource
     */
    public EvaluateResource() {
    }

    /**
     * Retrieves representation of an instance of lifemilesShunting.EvaluateResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/evaluate")
    @Consumes("application/xml")
    public Result getXml() {
        return new Result("2.5+1-2/6*1","",0.0);
        //throw new UnsupportedOperationException();
    }
    
/**
 * Sub-resource locator method for {id}
 */

    /**
     * PUT method for updating or creating an instance of EvaluateResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    @POST
    @Path("/evaluate")
    @Consumes("application/xml")
    public void postXml(String content){
        //return new Result("2.5+1-2/6*1","",0.0);
    }
}
