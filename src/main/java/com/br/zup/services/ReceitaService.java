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
	public void criarReceita(Receita receita) {
		receitaRepository.save(receita);
	}

	// R (Visualizar)
	public Iterable<Receita> pegarTodasReceitas() {
		return receitaRepository.findAll();
	}

	public Receita pegarReceitaPeloId(int id) {
		return receitaRepository.findById(id).get();
	}

	public long quantidadeDeReceitas() {
		return receitaRepository.count();
	}

	// U (Atualizar)

	public Receita atualizarReceita(int id, Receita atualizar) {
		Receita teste = new Receita();
		teste = receitaRepository.findById(id).get();

		if (teste != null) {
			atualizar.setId(id);
			return receitaRepository.save(atualizar);

		}
		return null;

	}

	// D (Deletar)
	public void excluirReceita(int id) {
		receitaRepository.deleteById(id);
	}

}
