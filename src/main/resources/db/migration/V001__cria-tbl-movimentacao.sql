CREATE TABLE tbl_movimentacao(
	id bigint not null auto_increment,
    placa varchar(7),
    modelo varchar(20),
    data_entrada datetime,
    data_saida datetime,
    tempo int,
    valor_pago decimal(10,2),
    
    primary key(id)

)engine=innoDB;