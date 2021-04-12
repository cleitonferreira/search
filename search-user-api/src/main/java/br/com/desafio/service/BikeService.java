package br.com.desafio.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.desafio.client.BikeClient;
import br.com.desafio.controller.dto.BikeDTO;
import br.com.desafio.controller.filter.BikeFilter;

/**
 * This class responsible to provide services about donation
 *
 */
@Service
public class BikeService {

	private static final Logger LOG = LoggerFactory.getLogger(BikeService.class);
	
	
	@Autowired
	private BikeClient bikeClient;

	/**
	 * Responsible to call maicroservice
	 * 
	 * @param BikeFilter
	 */
	@HystrixCommand
	public BikeDTO makeBike(BikeFilter bikeFilter) {

		LOG.info("Bike {}", bikeFilter.toString());
		
		BikeDTO bikeDTO = bikeClient.request(bikeFilter);
		
		LOG.info("Bike okay!");
		return bikeDTO;
	}

}
