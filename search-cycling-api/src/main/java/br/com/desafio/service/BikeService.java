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
import br.com.desafio.model.Bike;
import br.com.desafio.repository.BikeFilter;
import br.com.desafio.repository.BikeRepository;

@Service
public class BikeService {

	@Autowired
	private BikeRepository bikeRepository;

	public Bike save(Bike bike) {
		List<Bike> list = bikeRepository.findByModalityAndDistance(bike.getModality().toString(), bike.getDistance());
		if (list.size() == 0) {
			throw new ExistingException("Register[Bike] not found:" + bike.getId());
		}
		return bikeRepository.save(bike);
	}

	public List<Bike> findAll() {
		return bikeRepository.findAll();
	}

	public Optional<Bike> findById(Long id) {
		return bikeRepository.findById(id);
	}
	
	public ResponseEntity<?> searchBicycle(BikeFilter bikeFilter) {
		Bike bike = bikeRepository.searchBicycle(bikeFilter);		
		return bike != null ? ResponseEntity.ok(bike) : ResponseEntity.notFound().build();
	}

	public Bike update(Bike bike) {
		Bike a = bikeRepository.findById(bike.getId()).get();
		if (a != null) {
			throw new ExistingException("Register[Bike] not found:" + bike.getId());
		}
		return bikeRepository.save(bike);
	}

	public ResponseEntity<?> update(Long id, @Valid Bike bike) {
		Optional<Bike> optional = findById(id);

		if (optional.isPresent()) {
			BeanUtils.copyProperties(bike, optional.get(), "id");

			bikeRepository.save(optional.get());

			try {
				return ResponseEntity.ok(optional.get());
			} catch (IllegalArgumentException e) {
				return ResponseEntity.notFound().build();
			}

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new RetornoJson(LocalDateTime.now(), "Register[Bike] not found: " + id));
		}

	}

	public ResponseEntity<?> delete(Long id) {
		Optional<Bike> optional = findById(id);

		if (optional.isPresent()) {
			bikeRepository.delete(optional.get());
			return ResponseEntity.status(HttpStatus.OK)
					.body(new RetornoJson(LocalDateTime.now(), "Bike successfully deleted: " + id));

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new RetornoJson(LocalDateTime.now(), "Register[Bike] not found: " + id));
		}
	}


}
