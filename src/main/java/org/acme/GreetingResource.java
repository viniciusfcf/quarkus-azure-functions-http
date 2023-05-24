package org.acme;

import io.quarkus.funqy.Funq;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Olá";
    }

    @GET
    @Path("resteasy")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloResteasy() {
        return "Executou com Resteasy";
    }

    @Funq("funq")
    public String minhaFuncao() {
        return "Executou com Funq";
    }

}
