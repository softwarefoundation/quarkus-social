package com.softwarefoundation.domain;

import com.softwarefoundation.dto.UsuarioDTO;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TB01_USUARIO")
@Entity
public class Usuario extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long id;

    @Column(name = "NOME", length = 50)
    private String nome;

    @Column(name = "IDADE")
    private Integer idade;

    @Column(name = "EMAIL", length = 50)
    private String email;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Usuario fromDTO(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.nome = usuarioDTO.getNome();
        usuario.idade = usuarioDTO.getIdade();
        usuario.email = usuarioDTO.getEmail();
        return usuario;
    }
}
