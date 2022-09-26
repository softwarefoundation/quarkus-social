package com.softwarefoundation.service;

import com.softwarefoundation.domain.Usuario;
import com.softwarefoundation.repository.UsuarioRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Inject
    public UsuarioService() {
        this.usuarioRepository = new UsuarioRepository();
    }
    
    public void cadastrarUsuario(Usuario usuario) {
        this.usuarioRepository.persist(usuario);
    }

    public void atualizarUsuario(Usuario usuario){
        usuarioRepository.atualizarUsuario(usuario);
    }

    public void excluirUsuario(Usuario usuario){
        usuarioRepository.excluirUsuario(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.listarUsuarios();
    }

}
