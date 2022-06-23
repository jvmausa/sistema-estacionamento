CREATE TABLE tbl_valor(
	id bigint not null auto_increment,
    valor_primeira_hora decimal(10,2),
    valor_demais_horas decimal(10,2),
    data_fim datetime,
    
    primary key(id)
)engine=innoDB;