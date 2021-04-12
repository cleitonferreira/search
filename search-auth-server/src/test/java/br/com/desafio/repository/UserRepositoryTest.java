package br.com.desafio.repository;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.desafio.model.User;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

	@Autowired
	private UserRepository repo;

	/**
	 * Metodo responsável por preparar o objeto.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {

		User user = new User();
		user.setId(1L);
		user.setEmail("cleitonferreiraa@hotmail.com");
		user.setLogin("cleitonferreiraa");
		user.setPassword("1234");
		user.setName("Cleiton Ferreira");

		repo.save(user);

	}

	/**
	 * Método resposável para validar o login
	 * 
	 */
	@Test
	public void testFindByLogin() {

		Optional<User> optionalUser = repo.findByLogin("cleitonferreiraa");

		System.out.println(" >>> "+optionalUser.get().getLogin());
		
		assertTrue(optionalUser.get().getLogin().equals("cleitonferreiraa"));

	}

	/**
	 * Método resposável para salvar o usuário
	 */
	@Test
	public void testPersistUserSuccess() {

		User user = new User();
		user.setEmail("cleitonferreiran@gmail.com");
		user.setLogin("cleitonferreiran");
		user.setPassword("1234");

		repo.save(user);

		assertTrue(user.getId() > 0);
	}

	/**
	 * Deletar todos os registros
	 */
	@After
	public final void tearDown() {
		repo.deleteAll();
	}

}
