package br.com.desafio.repository.query;

import java.util.List;

import br.com.desafio.model.Bike;
import br.com.desafio.repository.BikeFilter;

public interface BikeRepositoryQuery {

	public List<Bike> searchBicycles(BikeFilter bikeFilter);
	public Bike searchBicycle(BikeFilter bikeFilter);

}
