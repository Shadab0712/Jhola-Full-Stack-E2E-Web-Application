package com.jhola.repository;

import org.springframework.data.repository.CrudRepository;

import com.jhola.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
