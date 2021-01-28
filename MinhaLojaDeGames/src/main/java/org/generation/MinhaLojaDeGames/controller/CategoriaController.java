package org.generation.MinhaLojaDeGames.controller;

import java.util.List;

import org.generation.MinhaLojaDeGames.model.Categoria;
import org.generation.MinhaLojaDeGames.repository.CategoriaRepository;
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


@RestController	  
@RequestMapping("/categoria")	  
@CrossOrigin
	  
public class CategoriaController {

		    
	  @Autowired private CategoriaRepository repository;
	  
	  @GetMapping public ResponseEntity<List<Categoria>> GetAll(){ return
	  ResponseEntity.ok(repository.findAll()); }
	  
	  
	  @GetMapping("/{codigo}") public ResponseEntity<Categoria>
	  GetById(@PathVariable long codigo) { //nome do metodo return
	  return repository.findById(codigo) .map(resp -> ResponseEntity.ok(resp))
	  .orElse(ResponseEntity.notFound().build());
	  
	  }
	  
	  @GetMapping ("/Categoria/{Categoria}") public ResponseEntity<List<Categoria>>
	  GetByCategoria(@PathVariable String nomeCategoria){ 
	  return ResponseEntity.ok(repository.findAllByNomeCategoriaContainingIgnoreCase(nomeCategoria));
	  }
	  
	  @PostMapping public ResponseEntity<Categoria> post (@RequestBody Categoria
	  Categoria){
	  
	  return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(Categoria)); }
	  
	  @PutMapping public ResponseEntity<Categoria> put (@RequestBody Categoria
	  Categoria){
	  
	  return ResponseEntity.status(HttpStatus.OK).body(repository.save(Categoria));
	  }
	  
	  @DeleteMapping ("/{codigo}")
	  
	  public void delete (@PathVariable long codigo ) {
	  
	  repository.deleteById(codigo); }
	
}
