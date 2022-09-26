package com.softwarefoundation.resources;

import com.softwarefoundation.dto.UsuarioDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @POST
    public Response cadastrarUsuario(UsuarioDTO usuarioDTO){
        System.out.println(usuarioDTO.getNome());
        return Response.ok().build();
    }

    @GET
    public Response listarUsuarios(){
        return Response.ok().build();
    }

}
