package br.com.desafio.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.desafio.controller.dto.BikeDTO;

/**
 * Interface responsible to connect Bike microservice
 *
 */
@FeignClient("bike")
public interface BikeClient {


    @RequestMapping(method = RequestMethod.GET, value = "/searchBicycle", consumes = "application/json")
	Long create(@RequestBody BikeDTO bikeDTO);
}
