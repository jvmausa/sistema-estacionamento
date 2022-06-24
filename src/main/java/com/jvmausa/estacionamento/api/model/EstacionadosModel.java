package com.jvmausa.estacionamento.api.model;

import java.time.OffsetDateTime;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EstacionadosModel extends RepresentationModel<EstacionadosModel> {

	private Long id;
	private String modelo;
	private String placa;
	private OffsetDateTime dataEntrada;

}
