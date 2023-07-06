package com.sistemaDeCadastros.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sistemaDeCadastros.Model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    @Query("select a from Aluno a where a.status = 'ATIVO'")
	public List<Aluno> findByStatusAtivos();
	
	@Query("select b from Aluno b where b.status = 'INATIVO'")
	public List<Aluno> findByStatusInativo();
	
	@Query("select c from Aluno c where c.status = 'CANCELADO'")
	public List<Aluno> findByStatusCancelados();

	@Query("select t from Aluno t where t.status = 'TRANCADO'")
	public List<Aluno> findByStatusTrancados();
	
	public List<Aluno> findByNomeContainingIgnoringCase(String nome);
    
}
