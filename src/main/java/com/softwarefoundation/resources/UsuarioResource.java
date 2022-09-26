package com.softwarefoundation.resources;

import com.softwarefoundation.domain.Usuario;
import com.softwarefoundation.dto.UsuarioDTO;
import com.softwarefoundation.exception.RegistroNaoLocalizadoException;
import com.softwarefoundation.service.UsuarioService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;

@Path("/usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    private UsuarioService usuarioService;
    private Validator validator;

    @Inject
    public UsuarioResource(UsuarioService usuarioService, Validator validator) {
        this.usuarioService = usuarioService;
        this.validator = validator;
    }

    @POST
    @Transactional
    public Response cadastrarUsuario(UsuarioDTO usuarioDTO) {

        Set<ConstraintViolation<UsuarioDTO>> validacoes = validator.validate(usuarioDTO);
        if(!validacoes.isEmpty()){
            ConstraintViolation<UsuarioDTO> erro = validacoes.stream().findFirst().get();
            return Response.status(Response.Status.BAD_REQUEST).entity(erro.getMessage()).build();
        }

        usuarioService = new UsuarioService();
        Usuario usuario = Usuario.fromDTO(usuarioDTO);
        usuarioService.cadastrarUsuario(usuario);
        return Response.ok().build();
    }

    @GET
    public Response listarUsuarios() {
        usuarioService = new UsuarioService();
        return Response.ok(usuarioService.listarUsuarios()).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response excluirUsuario(@PathParam("id") Long id) {
        try {
            usuarioService = new UsuarioService();
            Usuario usuario = Usuario.fromDTO(new UsuarioDTO(id));
            usuarioService.excluirUsuario(usuario);
            return Response.noContent().build();
        } catch (RegistroNaoLocalizadoException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response atualizarUsuario(@PathParam("id") Long id, UsuarioDTO usuarioDTO) {
        usuarioService = new UsuarioService();
        Usuario usuario = Usuario.fromDTO(usuarioDTO);
        usuario.setId(id);
        usuarioService.atualizarUsuario(usuario);
        return Response.ok().build();
    }

}
