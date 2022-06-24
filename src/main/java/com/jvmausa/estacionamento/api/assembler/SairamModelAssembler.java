package com.jvmausa.estacionamento.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.jvmausa.estacionamento.api.controller.EstacionamentoController;
import com.jvmausa.estacionamento.api.model.SairamModel;
import com.jvmausa.estacionamento.domain.model.Movimentacao;

@Component
public class SairamModelAssembler extends RepresentationModelAssemblerSupport<Movimentacao, SairamModel> {

	@Autowired
	private ModelMapper modelMapper;

	public SairamModelAssembler() {
		super(EstacionamentoController.class, SairamModel.class);
	}

	@Override
	public SairamModel toModel(Movimentacao movimentacao) {
		return modelMapper.map(movimentacao, SairamModel.class);
	}

	@Override
	public CollectionModel<SairamModel> toCollectionModel(Iterable<? extends Movimentacao> entities) {

		return super.toCollectionModel(entities);

	}

}
