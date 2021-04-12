package br.com.desafio.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.event.ResourceCreatedEvent;
import br.com.desafio.model.Bike;
import br.com.desafio.repository.BikeFilter;
import br.com.desafio.service.BikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Bike")
@RestController
@RequestMapping("bike")
public class BikeController {

	@Autowired
	private BikeService bikeService;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	
	@ApiOperation(value = "Permite realizar a consulta de todas as bicicletas.")
	@GetMapping("/findAll")
	public ResponseEntity<List<Bike>> getFindAll() {

		List<Bike> list = bikeService.findAll();
		return list != null ? ResponseEntity.ok(list) : ResponseEntity.notFound().build();
	}
	
	@ApiOperation(value = "Permite realizar a consulta de uma bicicleta específica.")
	@GetMapping("/findById")
	public ResponseEntity<?> findById(@RequestParam(required = true) Long id) {
		Optional<Bike> bike = bikeService.findById(id);
		return bike != null ? ResponseEntity.ok(bike) : ResponseEntity.notFound().build();
	}
	
	@ApiOperation(value = "Permite realizar a pesquisa da bicicleta ideal pela distancia percorrida.")
	@GetMapping("/searchBicycle")
	public ResponseEntity<?> searchBicycle(BikeFilter bikeFilter) {
		return bikeService.searchBicycle(bikeFilter);
	}
	
	
	@ApiOperation(value = "Permite salvar a bicicleta.")
	@PostMapping
	public ResponseEntity<Bike> save(@Valid @RequestBody Bike bike, HttpServletResponse response) {
		Bike bikeSave = bikeService.save(bike);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, bikeSave.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(bikeSave);
	}
	
	@ApiOperation(value = "Permite deletar a bicicleta.")
	@DeleteMapping
	public ResponseEntity<?> delete(@RequestParam(required = true) Long id) {	
		return bikeService.delete(id);
	}
	
	@ApiOperation(value = "Permite alterar a bicicleta.")
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Bike bike) {
			return bikeService.update(id, bike);
	}


}
