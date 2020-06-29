package com.br.zup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.models.User;
import com.br.zup.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void criarUser(User user) {
		userRepository.save(user);
	}

	public Iterable<User> pegarTodasUser() {
		return userRepository.findAll();
	}

	public User pegarUserPeloId(Long id) {
		return userRepository.findById(id).get();
	}

	public Long quantidadeDeUser() {
		return userRepository.count();
	}

	public User atualizarUser(Long id, User atualizar) {
		User teste = new User();
		teste = userRepository.findById(id).get();

		if (teste != null) {
			atualizar.setId(id);
			return userRepository.save(atualizar);

		}
		return null;

	}

	public void excluirUser(long id) {
		userRepository.deleteById(id);
	}

}
