package br.com.desafio.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.desafio.client.BikeClient;
import br.com.desafio.controller.dto.BikeDTO;

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
	 * Responsible to call maicroservice payment
	 * 
	 * @param bikeDTO
	 * @return return uuid payment.
	 */
	@HystrixCommand(fallbackMethod = "makeBikeFallback")
	public Long makeBike(BikeDTO bikeDTO) {

		LOG.info("Bike {}", bikeDTO.toString());
		
		Long uuid = bikeClient.create(bikeDTO);
		
		LOG.info("Bike okay!");
		return uuid;
	}
	
	/**
	 * This method responsible to return fallback in make bike
	 * @param bikeDTO
	 * @return
	 */
	public Long makeBikeFallback(BikeDTO bikeDTO) {
		return 0L;
	}

}
