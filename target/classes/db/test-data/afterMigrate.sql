set foreign_key_checks = 0;

delete from tbl_movimentacao;
delete from tbl_valor;
delete from tbl_usuario;

alter table tbl_movimentacao auto_increment = 1;
alter table tbl_valor auto_increment = 1;
alter table tbl_usuario auto_increment = 1;

insert into tbl_movimentacao(id, placa, modelo, data_entrada, data_saida, tempo,  valor_pago) 
	values (1, 'BRA2E19', 'celta prata', '2022-06-23 18:51:40', '2022-06-23 19:25:40', 1, 6.00);

insert into tbl_movimentacao(id, placa, modelo, data_entrada, data_saida, tempo,  valor_pago) 
	values (2, 'ARG3J20', 'vectra branco', '2022-06-23 15:50:00', null, 0, 0);
	

insert into tbl_valor(id, valor_primeira_hora, valor_demais_horas, data_fim)
	values(1, 6.00, 4.00, null);

insert into tbl_usuario(id, nome, usuario, senha)
	values(1, 'admin', 'admin', '123456');

set foreign_key_checks = 1;

