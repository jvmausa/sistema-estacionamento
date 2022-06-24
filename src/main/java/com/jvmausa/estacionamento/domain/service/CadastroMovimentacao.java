package com.jvmausa.estacionamento.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jvmausa.estacionamento.domain.model.Movimentacao;
import com.jvmausa.estacionamento.domain.model.Valor;
import com.jvmausa.estacionamento.domain.repository.MovimentacaoRepository;
import com.jvmausa.estacionamento.domain.repository.ValorRepository;

@Service
public class CadastroMovimentacao {

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;

	@Autowired
	private ValorRepository valorRepository;

	@Transactional
	public Movimentacao salvar(Movimentacao movimentacao) {

		movimentacao.setDataEntrada(OffsetDateTime.now());

		return movimentacaoRepository.save(movimentacao);

	}

	@Transactional
	public Movimentacao atualizar(Movimentacao movimentacao) {

		return movimentacaoRepository.save(movimentacao);

	}

	public Movimentacao saidaDeVeiculo(Movimentacao movimentacao) {

		movimentacao.setDataSaida(OffsetDateTime.now());

		return movimentacaoRepository.save(calculoHoras(movimentacao));

	}

	public Movimentacao buscarMovimentacao(Long id) {
		return movimentacaoRepository.findById(id).orElseThrow();

	}

	public Movimentacao calculoHoras(Movimentacao movimentacao) {

		Valor valor = valorRepository.findById(1L).orElseThrow();

		double valorPrimeiraHora = valor.getValorPrimeiraHora();
		double valorDemaisHoras = valor.getValorDemaisHoras();

		int horaChegada = movimentacao.getDataEntrada().getHour();
		int horaSaida = movimentacao.getDataSaida().getHour();
		int diferenca = horaSaida - horaChegada;

		if (diferenca <= 1) {

			movimentacao.setTempo(1);
			movimentacao.setValorPago(valorPrimeiraHora);

		} else {

			movimentacao.setTempo(diferenca);
			movimentacao.setValorPago((diferenca - 1) * valorDemaisHoras + valorPrimeiraHora);

		}

		return movimentacao;

	}

}
