package br.com.desafio.controller.dto;

import java.util.List;

import lombok.Data;

@Data
public class BikeDTO {

	private Long id;
	private String distance;
	private String modality;
	private List<AccessoryDTO> accessories;


}
