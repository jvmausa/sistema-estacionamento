package com.jvmausa.estacionamento.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "tbl_valor")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Valor {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double valorPrimeiraHora;
	
	private double valorDemaisHoras;
	
	private OffsetDateTime dataFim;
	
}
