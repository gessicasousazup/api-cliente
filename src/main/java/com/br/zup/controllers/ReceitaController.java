package com.br.zup.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.br.zup.models.Receita;
import com.br.zup.services.ReceitaService;

@RestController
@RequestMapping("/api/receitas")
public class ReceitaController {

	@Autowired
	private ReceitaService receitaService;

	// C
	@PostMapping
	public ResponseEntity<?> criaReceitas(@Valid @RequestBody Receita receita) {
		try {
			receitaService.salvarReceita(receita);
			return ResponseEntity.status(HttpStatus.CREATED).body(receita);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	// R
	@GetMapping("/{id}")
	public ResponseEntity<?> pegarReceita(@PathVariable int id) {
		try {
			Receita receita = receitaService.pegarReceitaPeloId(id);
			return ResponseEntity.ok(receita);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping
	public ResponseEntity pegarReceitas() {
		if (receitaService.quantidadeDeReceitas() > 0) {
			return ResponseEntity.ok(receitaService.pegarReceitas());
		}

		return ResponseEntity.noContent().build();
	}
	// U

	// D
	@DeleteMapping("/{id}")
	public ResponseEntity<?> apagarReceita(@PathVariable int id) {
//		receitaService;
		return ResponseEntity.ok().build();
	}
}
