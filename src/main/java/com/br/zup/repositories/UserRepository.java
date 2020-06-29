package com.br.zup.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.zup.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
