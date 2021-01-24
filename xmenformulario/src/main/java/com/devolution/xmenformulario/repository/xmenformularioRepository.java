package com.devolution.xmenformulario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.devolution.xmenformulario.model.xmenformulario;

@Repository //Fio do controle - Faz a ligação entre o Controller e a Aplicação.
public interface xmenformularioRepository extends JpaRepository<xmenformulario, Long>
{
	public List<xmenformulario> findAllByNomeIgnoreCase(String nome);
	
	public List<xmenformulario> findAllByAmeaca(boolean ameaca);
	
	public List<xmenformulario> findByNivelPoderGreaterThan(int nivelPoder);
			
}
