package br.com.desafio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.controller.dto.TokenDTO;
import br.com.desafio.controller.form.LoginForm;
import br.com.desafio.security.TokenService;

/**
 * Class responsible to provide authenticator
 *
 */
@RestController
@RequestMapping("/auth")
public class AuthenticatorController {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;

	/**
	 * Responsible to authenticate user
	 * 
	 * @param form
	 * @return
	 */
	@PostMapping
	public ResponseEntity<TokenDTO> auth(@RequestBody @Valid LoginForm form) {

		UsernamePasswordAuthenticationToken userInfo = form.converter();

		try {
			
			Authentication authentication = authManager.authenticate(userInfo);
			String token = tokenService.createToken(authentication);
			
			return ResponseEntity.ok(new TokenDTO(token,"Bearer"));
			
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}

	}
}
