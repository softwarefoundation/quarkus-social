package com.softwarefoundation.dto;

//import lombok.Data;
//
//@Data
public class UsuarioDTO {

    private Long id;
    private String nome;
    private Integer idade;
    private String email;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id) {
        this.id = id;
    }

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
}
