package com.softwarefoundation.repository;

import com.softwarefoundation.domain.Usuario;
import com.softwarefoundation.exception.RegistroNaoLocalizadoException;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {

    public List<Usuario> listarUsuarios() {
        return findAll().list();
    }

    public Usuario pesquisarPorId(Long id) {
        return findByIdOptional(id).orElseThrow(() -> new RegistroNaoLocalizadoException("Usuário não localizado"));
    }

    public void atualizarUsuario(Usuario usuario) {
        Usuario usr = pesquisarPorId(usuario.getId());
        usr.setNome(usuario.getNome());
        usr.setEmail(usuario.getEmail());
        usr.setIdade(usuario.getIdade());
    }

    public void excluirUsuario(Usuario usuario) {
        delete(pesquisarPorId(usuario.getId()));
    }

}
