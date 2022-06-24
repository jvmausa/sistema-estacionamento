package com.jvmausa.estacionamento.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvmausa.estacionamento.api.assembler.EstacionadosModelAssembler;
import com.jvmausa.estacionamento.api.assembler.MovimentacaoInputDisassembler;
import com.jvmausa.estacionamento.api.assembler.MovimentacaoModelAssembler;
import com.jvmausa.estacionamento.api.assembler.SairamModelAssembler;
import com.jvmausa.estacionamento.api.model.EstacionadosModel;
import com.jvmausa.estacionamento.api.model.MovimentacaoModel;
import com.jvmausa.estacionamento.api.model.SairamModel;
import com.jvmausa.estacionamento.api.model.input.MovimentacaoInput;
import com.jvmausa.estacionamento.domain.model.Movimentacao;
import com.jvmausa.estacionamento.domain.repository.MovimentacaoRepository;
import com.jvmausa.estacionamento.domain.service.CadastroMovimentacao;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(path = "/estacionamento")
public class EstacionamentoController {

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;

	@Autowired
	private EstacionadosModelAssembler estacionadosModelAssembler;

	@Autowired
	private MovimentacaoModelAssembler movimentacaoModelAssembler;

	@Autowired
	private SairamModelAssembler sairamModelAssembler;

	@Autowired
	private MovimentacaoInputDisassembler movimentacaoInputDisassembler;

	@Autowired
	private CadastroMovimentacao cadastroMovimentacao;

	@GetMapping("/veiculos-estacionados")
	public CollectionModel<EstacionadosModel> listarVeiculosEstacionados() {

		return estacionadosModelAssembler.toCollectionModel(movimentacaoRepository.veiculosEstacionados());

	}

	@GetMapping("/veiculos-sairam")
	public CollectionModel<SairamModel> listarVeiculosSairam() {

		return sairamModelAssembler.toCollectionModel(movimentacaoRepository.veiculosSairam());

	}

	@PostMapping("/nova-entrada-veiculo")
	public EstacionadosModel adicionar(@RequestBody @Valid MovimentacaoInput movimentacaoInput) {
		Movimentacao movimentacao = movimentacaoInputDisassembler.toDomainObject(movimentacaoInput);

		movimentacao = cadastroMovimentacao.salvar(movimentacao);

		EstacionadosModel estacionadosModel = estacionadosModelAssembler.toModel(movimentacao);

		return estacionadosModel;

	}

	@PutMapping("/editar-entrada/{id}")
	public EstacionadosModel editar(@PathVariable Long id, @RequestBody @Valid MovimentacaoInput movimentacaoInput) {
		Movimentacao movimentacaoAtual = cadastroMovimentacao.buscarMovimentacao(id);

		movimentacaoInputDisassembler.copyToDomainObject(movimentacaoInput, movimentacaoAtual);

		return estacionadosModelAssembler.toModel(cadastroMovimentacao.atualizar(movimentacaoAtual));

	}

	@PutMapping("saida-veiculo/{id}")
	public MovimentacaoModel saidaDeVeiculo(@PathVariable Long id) {
		Movimentacao movimentacaoAtual = cadastroMovimentacao.buscarMovimentacao(id);

		return movimentacaoModelAssembler.toModel(cadastroMovimentacao.saidaDeVeiculo(movimentacaoAtual));

	}

}
