package com.softwarefoundation.repository;

import com.softwarefoundation.domain.Usuario;
import com.softwarefoundation.exception.RegistroNaoLocalizadoException;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import java.util.List;

public class UsuarioRepository {

    public void salvar(Usuario usuario) {
        usuario.persist();
    }

    public List<Usuario> listarUsuarios() {
        PanacheQuery<Usuario> query = Usuario.findAll();
        return query.list();
    }

    public Usuario pesquisarPorId(Long id) {
        return  (Usuario) Usuario.findByIdOptional(id).orElseThrow(() -> new RegistroNaoLocalizadoException("Usuário não localizado"));
    }

    public void atualizarUsuario(Usuario usuario) {
        Usuario usr = pesquisarPorId(usuario.getId());
        usr.setNome(usuario.getNome());
        usr.setEmail(usuario.getEmail());
        usr.setIdade(usuario.getIdade());
    }

    public void excluirUsuario(Usuario usuario) {
        pesquisarPorId(usuario.getId()).delete();
    }

}
