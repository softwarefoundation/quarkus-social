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
    public void cadastrarUsuario(Usuario usuario){
        this.usuarioRepository.salvar(usuario);
    }

    public List<Usuario> listarUsuarios(){
        PanacheQuery<Usuario> query = Usuario.findAll();
        return query.list();
    }

}
