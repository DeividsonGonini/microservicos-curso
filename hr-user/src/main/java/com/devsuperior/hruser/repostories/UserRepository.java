package com.devsuperior.hruser.repostories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	//faz a busca por emails
	User findByEmail(String email);
}
