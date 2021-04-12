package br.com.desafio.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.desafio.model.User;
import br.com.desafio.repository.UserRepository;


@Service
public class AuthenticatorService implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;
	
	/**
	 * This method responsible to load login in the application
	 */
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		Optional<User> optional = repository.findByLogin(login);

		//check exists
		if (optional.isPresent()) {
			return optional.get();
		}
		
		if(!optional.get().isEnable()) {
			throw new UsernameNotFoundException("Usuário desabilitado");
		}

		throw new UsernameNotFoundException("Dados inválidos");
	}


}
