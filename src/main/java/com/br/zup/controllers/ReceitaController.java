package com.br.zup.controllers;

import javax.validation.Valid;

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
import com.br.zup.models.Receita;
import com.br.zup.services.ReceitaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/receitas")
public class ReceitaController {

	@Autowired
	private ReceitaService receitaService;

	// C
	@PostMapping("/")
	public ResponseEntity<?> criaReceitas(@Valid @RequestBody Receita receita) {
		try {
			receitaService.criarReceita(receita);
			return ResponseEntity.status(HttpStatus.CREATED).body(receita);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	// R
	@GetMapping("/")
	public ResponseEntity<?> exibirTodos() {
		try {
			return ResponseEntity.ok().body(receitaService.pegarTodasReceitas());

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> pegarReceita(@PathVariable int id) {
		try {
			Receita receita = receitaService.pegarReceitaPeloId(id);
			return ResponseEntity.ok(receita);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	// U
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarReceita(@PathVariable int id, @RequestBody Receita receita) {

		try {

			return ResponseEntity.ok().body(receitaService.atualizarReceita(id, receita));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	// D
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirReceita(@PathVariable int id) {
		try {
			receitaService.excluirReceita(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
