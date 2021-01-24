package com.devolution.xmenformulario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devolution.xmenformulario.model.Poder;
import com.devolution.xmenformulario.repository.PoderRepository;

@RestController
@RequestMapping ("/poder")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class PoderController 
{
	@Autowired
	private PoderRepository repositorioPoder;
	
	@GetMapping
	public ResponseEntity<List<Poder>> GetAll() {
		return ResponseEntity.ok(repositorioPoder.findAll());
	}
	
	@GetMapping("nomepoder/{nomePoder}")
	public List<Poder> GetByNomePoder(@PathVariable String nomePoder) {
		return repositorioPoder.findAllByNomePoderContainingIgnoreCase(nomePoder);
	}
	
	@PutMapping
	public ResponseEntity<Poder> Put (@RequestBody Poder poder) {
		return ResponseEntity.ok(repositorioPoder.save(poder));
	}
	
	@PostMapping
	public ResponseEntity<Poder> Post (@RequestBody Poder poder) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositorioPoder.save(poder));
	}
	
	@DeleteMapping ("nomepoder/{nomePoder}")
	public void deletarPoder (@PathVariable String nomePoder) {
		repositorioPoder.deleteById(nomePoder);
	}
	
	
	

	
}
