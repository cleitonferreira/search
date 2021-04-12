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
import br.com.desafio.model.Accessory;
import br.com.desafio.service.AccessoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Accessory")
@RestController
@RequestMapping("accessory")
public class AccessoryController {
	
	@Autowired
	private AccessoryService accessoryService;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	
	@ApiOperation(value = "Permite realizar a consulta de todas os acessórios.")
	@GetMapping("/findAll")
	public ResponseEntity<List<Accessory>> getFindAll() {

		List<Accessory> list = accessoryService.findAll();
		return list != null ? ResponseEntity.ok(list) : ResponseEntity.notFound().build();
	}
	
	@ApiOperation(value = "Permite realizar a consulta de um acessório específico.")
	@GetMapping("/findById")
	public ResponseEntity<?> findById(@RequestParam(required = true) Long id) {
		Optional<Accessory> accessory = accessoryService.findById(id);
		return accessory != null ? ResponseEntity.ok(accessory) : ResponseEntity.notFound().build();
	}
	
	
	@ApiOperation(value = "Permite salvar o acessório.")
	@PostMapping
	public ResponseEntity<Accessory> save(@Valid @RequestBody Accessory accessory, HttpServletResponse response) {
		Accessory accessorySave = accessoryService.save(accessory);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, accessorySave.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(accessorySave);
	}
	
	@ApiOperation(value = "Permite deletar o acessório.")
	@DeleteMapping
	public ResponseEntity<?> delete(@RequestParam(required = true) Long id) {	
		return accessoryService.delete(id);
	}
	
	@ApiOperation(value = "Permite alterar o acessório.")
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Accessory accessory) {
			return accessoryService.update(id, accessory);
	}


}
