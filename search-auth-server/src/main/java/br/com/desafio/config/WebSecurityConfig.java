package br.com.desafio.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.desafio.security.AuthenticatorService;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private Environment env;
	
	@Autowired
	AuthenticatorService authenticatorService;

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	/**
	 * Return password encoder for password encrypt encrypt hash
	 * 
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Method responsible to authenticate user.
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
			
			auth.inMemoryAuthentication()
				.passwordEncoder(passwordEncoder())
				.withUser("admin")
				.password(passwordEncoder()
				.encode("admin"))
			    .roles("USER");
		}else {
			//integrated authenticator
			auth.userDetailsService(authenticatorService).passwordEncoder(new BCryptPasswordEncoder());
		}
	}

	/**
	 * Resource configurations, imgs
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**",
				"/swagger-resources/**");
	}
}
