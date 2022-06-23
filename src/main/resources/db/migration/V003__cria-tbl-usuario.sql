create table tbl_usuario(
	id bigint not null auto_increment,
    nome varchar(40),
    usuario varchar(20),
    senha varchar(20),
    
    primary key(id)
);