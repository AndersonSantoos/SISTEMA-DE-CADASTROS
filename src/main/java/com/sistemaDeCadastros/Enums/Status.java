package com.sistemaDeCadastros.Enums;

public enum Status {
    
    ATIVO("ativo"),
    INATIVO("inativo"),
    TRANCADO("trancado"),
    CANCELADO("cancelado");

    private String status;

    private Status(String status) {
		this.status = status;
	}

}
