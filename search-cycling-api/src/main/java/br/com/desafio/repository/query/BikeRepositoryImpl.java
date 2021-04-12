package br.com.desafio.repository.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import br.com.desafio.model.Bike;
import br.com.desafio.repository.BikeFilter;

public class BikeRepositoryImpl implements BikeRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;


	@Override
	public List<Bike> searchBicycles(BikeFilter bikeFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Bike> criteria = builder.createQuery(Bike.class);
		Root<Bike> root = criteria.from(Bike.class);
		
		criteria.select(root);
		
		if (!StringUtils.isEmpty(bikeFilter.getModality())) {
			criteria.where(builder.equal(root.get("modality"), bikeFilter.getModality()));
		}
		
		if (!StringUtils.isEmpty(bikeFilter.getDistance())) {	
			Expression<String> path = root.get("distance");
			Expression<String> upper = builder.upper(path);
			criteria.where(builder.like(upper, "%" + bikeFilter.getDistance().toUpperCase() + "%"));
		}

		return manager.createQuery(criteria)
				.getResultList();
	}


	@Override
	public Bike searchBicycle(BikeFilter bikeFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Bike> criteria = builder.createQuery(Bike.class);
		Root<Bike> root = criteria.from(Bike.class);
		
		criteria.select(root);
		
		if (!StringUtils.isEmpty(bikeFilter.getModality())) {
			criteria.where(builder.equal(root.get("modality"), bikeFilter.getModality()));
		}
		
		if (!StringUtils.isEmpty(bikeFilter.getDistance())) {	
			Expression<String> path = root.get("distance");
			Expression<String> upper = builder.upper(path);
			criteria.where(builder.equal(upper, bikeFilter.getDistance().toUpperCase()));
		}

		return manager.createQuery(criteria)
				.getSingleResult();
	}


}
