package br.com.desafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.desafio.model.User;
import br.com.desafio.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	UserRepository repo;

	/**
	 * Return all users from database;
	 * 
	 * @return
	 */
	public List<User> findAll() {
		return repo.findAll();
	}

	/**
	 * Responsible to save user
	 * @param user
	 * @return
	 */
	public User save(User user) {
		return repo.save(user);
	}

	/**
	 * Return all user from database;
	 * 
	 * @param pageable
	 * @return
	 */
	public Page<User> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	/**
	 * Return user by id
	 * @param id
	 * @return
	 */
	public Optional<User> findById(Long id){
		return repo.findById(id); 
	}
	
	/**
	 * Delete user by Id
	 * @param id
	 */
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
}
