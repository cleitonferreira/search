package br.com.desafio.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.desafio.controller.dto.BikeDTO;

/**
 * Interface responsible to connect Bike microservice
 *
 */
@FeignClient(name = "bike", url = "http://localhost:8082")
public interface BikeClient {


    @RequestMapping("/bike/searchBicycle?distance={distance}")
	BikeDTO request(@PathVariable("distance") String distance);
}
