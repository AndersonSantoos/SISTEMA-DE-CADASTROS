package com.sistemaDeCadastros.Enums;

public enum Curso {

    ADMINISTRACAO("Administracao"),
	DIREITO("Direito"),
	CONTABILIDADE("Contabilidade"),
	DESENVOLVEDOR("Desenvolvedor"),
	ENFERMAGEM("Enfermagem"),
	MEDICINA("Medicina");

	private String curso;
	
	private Curso(String curso) {
		this.curso = curso;
	}
    
}
