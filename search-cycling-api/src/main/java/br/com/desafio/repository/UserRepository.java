package br.com.desafio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.model.User;

/**
 * This class responsible to access user tables
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Return User by username
	 * @param username
	 * @return
	 */
	Optional<User> findByUsername(String username);
}
