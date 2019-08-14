package com.br.zup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.models.Receita;
import com.br.zup.repositories.ReceitaRepository;

@Service
public class ReceitaService {

	@Autowired
	private ReceitaRepository receitaRepository;

	// CRUD

	// C (Create)
	public void salvarReceita(Receita receita) {
		receitaRepository.save(receita);
	}

	// R (Visualizar)
	public Iterable<Receita> pegarReceitas() {
		return receitaRepository.findAll();
	}

	public Receita pegarReceitaPeloId(int id) {
		return receitaRepository.findById(id).get();
	}
	
	public long quantidadeDeReceitas() {
		return receitaRepository.count();
	}

	// U (Atualizar)
	
	
	// D (Deletar)
	
	
}
