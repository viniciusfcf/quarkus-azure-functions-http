package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/resteasy")
public class ResteasyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloResteasy() {
        return "Executou com Resteasy";
    }

}
