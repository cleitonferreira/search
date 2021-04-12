package br.com.desafio.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.desafio.model.User;
import br.com.desafio.repository.UserRepository;

/**
 * This class responsible provide methods about authentication
 *
 */
@Service
public class AuthenticatorService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	/**
	 * This method responsible to load username in the application
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> optional = repository.findByUsername(username);

		if (optional.isPresent()) {
			return optional.get();
		}

		throw new UsernameNotFoundException("Dados inválidos");
	}

}
