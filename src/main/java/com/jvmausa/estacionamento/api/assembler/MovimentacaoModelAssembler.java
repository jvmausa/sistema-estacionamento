package com.jvmausa.estacionamento.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.jvmausa.estacionamento.api.controller.EstacionamentoController;
import com.jvmausa.estacionamento.api.model.MovimentacaoModel;
import com.jvmausa.estacionamento.domain.model.Movimentacao;

@Component
public class MovimentacaoModelAssembler extends RepresentationModelAssemblerSupport<Movimentacao, MovimentacaoModel> {

	@Autowired
	private ModelMapper modelMapper;

	public MovimentacaoModelAssembler() {
		super(EstacionamentoController.class, MovimentacaoModel.class);
	}

	@Override
	public MovimentacaoModel toModel(Movimentacao movimentacao) {
		return modelMapper.map(movimentacao, MovimentacaoModel.class);

	}

	@Override
	public CollectionModel<MovimentacaoModel> toCollectionModel(Iterable<? extends Movimentacao> entities) {

		return super.toCollectionModel(entities);

	}

}
