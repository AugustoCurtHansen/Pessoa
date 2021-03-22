package br.com.formularioPessoa.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.formularioPessoa.modelo.Pessoa;

public interface UsuarioRepository extends JpaRepository<Pessoa, String> {
	
	@Query("Select u from Pessoa u where u.nome = :nome")
	List<Pessoa> buscarPorPessoa(@Param("nome") String userId);
	//List<Usuario> findByUserId();
}