package com.softwarefoundation.resources;

import com.softwarefoundation.dto.UsuarioDTO;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/usuario")
public class UsuarioResource {

    @POST
    public Response cadastrarUsuario(UsuarioDTO usuarioDTO){
        return Response.ok().build();
    }

}
