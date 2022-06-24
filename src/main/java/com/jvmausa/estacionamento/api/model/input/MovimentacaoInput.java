package com.jvmausa.estacionamento.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovimentacaoInput {

	@NotBlank
	private String placa;

	@NotBlank
	private String modelo;

}
