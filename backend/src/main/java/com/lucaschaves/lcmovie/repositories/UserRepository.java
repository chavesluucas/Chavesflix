package com.lucaschaves.lcmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaschaves.lcmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);
	
}
