package com.jvmausa.estacionamento.api.model;

import java.time.OffsetDateTime;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovimentacaoModel extends RepresentationModel<MovimentacaoModel> {

	private Long id;

	private String placa;

	private String modelo;

	private OffsetDateTime dataEntrada;

	private OffsetDateTime dataSaida;

	private int tempo;

	private double valorPago;

}
