package br.com.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.desafio.model.Bike;
import br.com.desafio.repository.query.BikeRepositoryQuery;

public interface BikeRepository extends JpaRepository<Bike, Long>, BikeRepositoryQuery {

	@Query("FROM Bike WHERE modality = :modality AND distance = :distance")
	List<Bike> findByModalityAndDistance(@Param("modality") String modality, @Param("distance") String distance);


}
