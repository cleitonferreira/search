package br.com.desafio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.desafio.repository.UserRepository;
import br.com.desafio.security.AuthenticatorService;
import br.com.desafio.security.TokenService;

/**
 * This class responsible to configure Spring Security in this project Control
 * Access in end points in application
 *
 */
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	AuthenticatorService authenticatorService;

	@Autowired
	TokenService tokenService;

	@Autowired
	UserRepository userRepository;

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {

		return super.authenticationManager();
	}

	/**
	 * Responsible to configure authentication, login, control access
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authenticatorService).passwordEncoder(new BCryptPasswordEncoder());
	}

	/**
	 * Authorization configuration, urls
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/*http.authorizeRequests().antMatchers("/").permitAll().and()
        				.authorizeRequests().antMatchers("/console/**").permitAll();
		http.csrf().disable();
		http.headers().frameOptions().disable();*/

		http.authorizeRequests().antMatchers(HttpMethod.GET, "/users").permitAll()
				.antMatchers(HttpMethod.GET, "/actuator/**").permitAll().antMatchers(HttpMethod.POST, "/auth")
				.permitAll().antMatchers(HttpMethod.POST, "/donates/**").permitAll().anyRequest().authenticated().and()
				.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.addFilterBefore(new AuthenticatorTokenFilter(tokenService, userRepository),
						UsernamePasswordAuthenticationFilter.class);

	}

	/**
	 * Resource configurations, imgs
	 */
	// Configuracoes de recursos estaticos(js, css, imagens, etc.)
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**",
				"/swagger-resources/**");
	}

}
