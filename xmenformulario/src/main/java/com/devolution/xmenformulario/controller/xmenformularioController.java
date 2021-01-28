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
import com.devolution.xmenformulario.model.xmenformulario;
import com.devolution.xmenformulario.repository.xmenformularioRepository;

@RestController
@RequestMapping("/mutantes")
@CrossOrigin("*")

public class xmenformularioController {

	@Autowired

	private xmenformularioRepository repositorioXmen;

	@GetMapping
	public ResponseEntity<List<xmenformulario>> GetAll() {
		return ResponseEntity.ok(repositorioXmen.findAll());
	}

	@GetMapping("nome/{nome}")
	public List<xmenformulario> GetByNome(@PathVariable String nome) {
		return repositorioXmen.findAllByNomeIgnoreCase(nome);
	}

	@GetMapping("codigo/{codigo}")
	public ResponseEntity<xmenformulario> GetById(@PathVariable long codigo) {
		return repositorioXmen.findById(codigo).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("ameaca/{ameaca}")
	public List<xmenformulario> GetByameaca(@PathVariable boolean ameaca) {
		return repositorioXmen.findAllByAmeaca(ameaca);
	}

	@GetMapping("identidade/{identidade}")
	public List<xmenformulario> GetByidentidade(@PathVariable String identidade) {
		return repositorioXmen.findByIdentidade(identidade);
	}

	@PutMapping
	public ResponseEntity<xmenformulario> put(@RequestBody xmenformulario mutantes) {
		return ResponseEntity.status(HttpStatus.OK).body(repositorioXmen.save(mutantes));
	}

	@PostMapping
	public ResponseEntity<xmenformulario> post(@RequestBody xmenformulario NovoMutante) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositorioXmen.save(NovoMutante));
	}

	@DeleteMapping("codigo/{codigo}")
	public void deletarMutante(@PathVariable long codigo) {
		repositorioXmen.deleteById(codigo);
	}

}