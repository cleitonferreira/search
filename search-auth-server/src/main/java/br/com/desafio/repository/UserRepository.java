package br.com.desafio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Return User by login
	 * @param username
	 * @return
	 */
	Optional<User> findByLogin(String login); 
	
	/**
	 * Return user by email
	 * @param email
	 * @return
	 */
	Optional<User> findByEmail(String email);

}
