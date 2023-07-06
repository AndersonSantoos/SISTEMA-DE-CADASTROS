package com.sistemaDeCadastros.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sistemaDeCadastros.Model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // O @Query é uso do JPQL para bucar a lista de usuários


	
	@Query("select i from Usuario i where i.email = :email")
	public Usuario findByEmail(String email);
	
	@Query("select j from Usuario j where j.user = :user and j.senha = :senha")
	public Usuario buscarLogin(String user, String senha);
    
}
