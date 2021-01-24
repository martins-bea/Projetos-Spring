package com.devolution.xmenformulario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devolution.xmenformulario.model.Poder;

public interface PoderRepository extends JpaRepository<Poder, String>
{
	public List<Poder> findAllByNomePoderContainingIgnoreCase(String nomePoder);
	
	
	
}
