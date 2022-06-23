set foreign_key_checks = 0;

delete from tbl_movimentacao;
delete from tbl_valor;

insert into tbl_movimentacao(id, placa, modelo, data_entrada, data_saida, tempo,  valor_pago) 
	values (1, 'BRA2E19', 'celta prata', '2022-06-23 18:51:40', '2022-06-23 19:25:40', 34, 6.00);

insert into tbl_valor(id, valor_primeira_hora, valor_demais_horas, data_fim)
	values(1, 6.00, 4.00, null);

set foreign_key_checks = 1;

