package com.softwarefoundation.service;

import com.softwarefoundation.domain.Usuario;
import com.softwarefoundation.repository.UsuarioRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.transaction.Transactional;
import java.util.List;

public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService() {
        this.usuarioRepository = new UsuarioRepository();
    }

    @Transactional
    public void cadastrarUsuario(Usuario usuario) {
        this.usuarioRepository.salvar(usuario);
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
