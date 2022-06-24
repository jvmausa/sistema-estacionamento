package com.jvmausa.estacionamento.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jvmausa.estacionamento.api.model.input.MovimentacaoInput;
import com.jvmausa.estacionamento.domain.model.Movimentacao;

@Component
public class MovimentacaoInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Movimentacao toDomainObject(MovimentacaoInput movimentacaoInput) {
		return modelMapper.map(movimentacaoInput, Movimentacao.class);

	}

	public void copyToDomainObject(MovimentacaoInput movimentacaoInput, Movimentacao movimentacao) {
		modelMapper.map(movimentacao, movimentacao);
	}

}
