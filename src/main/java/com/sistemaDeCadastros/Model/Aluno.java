package com.sistemaDeCadastros.Model;

import com.sistemaDeCadastros.Enums.Curso;
import com.sistemaDeCadastros.Enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Aluno {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
	@Size(min = 5, max = 35, message = "Coloque seu nome e sobrenome")
	@NotBlank(message = "O nome não pode ser vazio!")
    private String nome;

    @Column(name = "curso")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O curso não pode ser vazio!")
    private Curso curso;

    @Column(name = "matricula")
	@NotNull(message = "Clique no botão gerar mátricula")
	@Size(min = 3, message = "Clique no botão gerar matricular!")
	private String matricula;
    
    @Column(name = "status")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O campo não pode ser nulo!")
    private Status status;

    @NotBlank(message = "Não pode ser vazio!")
	@Size(min = 4, message = "O mínimo é quatro caracteres.")
    private String turno;
    
    public Aluno(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}