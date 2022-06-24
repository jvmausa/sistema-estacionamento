package com.jvmausa.estacionamento.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jvmausa.estacionamento.domain.model.Movimentacao;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

	@Query("from Movimentacao where tempo = 0")
	List<Movimentacao> veiculosEstacionados();

	@Query("from Movimentacao where tempo != 0")
	List<Movimentacao> veiculosSairam();
	
}
