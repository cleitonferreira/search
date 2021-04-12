package br.com.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.model.Accessory;

public interface AccessoryRepository extends JpaRepository<Accessory, Long> {

	List<Accessory> findByNameContainingIgnoreCase(String name);
	
}
