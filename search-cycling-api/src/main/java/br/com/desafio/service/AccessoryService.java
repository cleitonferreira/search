package br.com.desafio.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.desafio.config.exception.ExistingException;
import br.com.desafio.model.Accessory;
import br.com.desafio.repository.AccessoryRepository;

@Service
public class AccessoryService {

	@Autowired
	private AccessoryRepository accessoryRepository;

	public Accessory save(Accessory accessory) {
		List<Accessory> list = accessoryRepository.findByNameContainingIgnoreCase(accessory.getName());
		if (list.size() == 0) {
			throw new ExistingException("Register[Accessory] not found:" + accessory.getId());
		}
		return accessoryRepository.save(accessory);
	}

	public List<Accessory> findAll() {
		return accessoryRepository.findAll();
	}

	public Optional<Accessory> findById(Long id) {
		return accessoryRepository.findById(id);
	}

	public Accessory update(Accessory accessory) {
		Accessory a = accessoryRepository.findById(accessory.getId()).get();
		if (a != null) {
			throw new ExistingException("Register[Accessory] not found:" + accessory.getId());
		}
		return accessoryRepository.save(accessory);
	}

	public ResponseEntity<?> update(Long id, @Valid Accessory accessory) {
		Optional<Accessory> optional = findById(id);

		if (optional.isPresent()) {
			BeanUtils.copyProperties(accessory, optional.get(), "id");

			accessoryRepository.save(optional.get());

			try {
				return ResponseEntity.ok(optional.get());
			} catch (IllegalArgumentException e) {
				return ResponseEntity.notFound().build();
			}

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new RetornoJson(LocalDateTime.now(), "Register[Accessory] not found: " + id));
		}

	}

	public ResponseEntity<?> delete(Long id) {
		Optional<Accessory> optional = findById(id);

		if (optional.isPresent()) {
			accessoryRepository.delete(optional.get());
			return ResponseEntity.status(HttpStatus.OK)
					.body(new RetornoJson(LocalDateTime.now(), "Accessory successfully deleted: " + id));

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new RetornoJson(LocalDateTime.now(), "Register[Accessory] not found: " + id));
		}
	}

}
