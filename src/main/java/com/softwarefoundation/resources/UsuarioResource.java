package com.softwarefoundation.resources;

import com.softwarefoundation.domain.Usuario;
import com.softwarefoundation.dto.UsuarioDTO;
import com.softwarefoundation.service.UsuarioService;

import javax.transaction.Transactional;
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

    private UsuarioService usuarioService;

    @POST
    @Transactional
    public Response cadastrarUsuario(UsuarioDTO usuarioDTO){
        usuarioService = new UsuarioService();
        Usuario usuario = Usuario.fromDTO(usuarioDTO);
        usuarioService.cadastrarUsuario(usuario);
        return Response.ok().build();
    }

    @GET
    public Response listarUsuarios(){
        usuarioService = new UsuarioService();
        return Response.ok(usuarioService.listarUsuarios()).build();
    }

}
