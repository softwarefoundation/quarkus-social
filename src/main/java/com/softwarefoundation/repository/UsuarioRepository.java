package com.softwarefoundation.repository;

import com.softwarefoundation.domain.Usuario;

public class UsuarioRepository {

    public void salvar(Usuario usuario){
        usuario.persist();
    }

}
