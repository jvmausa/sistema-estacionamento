package com.jvmausa.estacionamento.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.jvmausa.estacionamento.api.controller.EstacionamentoController;
import com.jvmausa.estacionamento.api.model.EstacionadosModel;
import com.jvmausa.estacionamento.domain.model.Movimentacao;

@Component
public class EstacionadosModelAssembler extends RepresentationModelAssemblerSupport<Movimentacao, EstacionadosModel> {

	@Autowired
	private ModelMapper modelMapper;

	public EstacionadosModelAssembler() {
		super(EstacionamentoController.class, EstacionadosModel.class);
	}

	@Override
	public EstacionadosModel toModel(Movimentacao movimentacao) {
		return modelMapper.map(movimentacao, EstacionadosModel.class);

	}

	@Override
	public CollectionModel<EstacionadosModel> toCollectionModel(Iterable<? extends Movimentacao> entities) {

		return super.toCollectionModel(entities);

	}

}
