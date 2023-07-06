package com.sistemaDeCadastros.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Email
    private String email;
    @Size(min = 3, max = 20, message = "Usuario deve conter entre 3 e 20 caracteres")
    private String user;
    private String senha;

    public Usuario(){}

    

    public Usuario(Long id, @Email String email,
            @Size(min = 3, max = 20, message = "Usuario deve conter entre 3 e 20 caracteres") String user,
            String senha) {
        this.id = id;
        this.email = email;
        this.user = user;
        this.senha = senha;
    }



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }


    


    
}
