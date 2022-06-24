package com.jvmausa.estacionamento.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jvmausa.estacionamento.domain.model.Valor;

@Repository
public interface ValorRepository extends JpaRepository<Valor, Long>{

}
