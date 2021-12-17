INSERT INTO payment.pessoas (nome,cpf,data_nascimento) VALUES
('Luiz','12345678910','2021-09-30');

INSERT INTO payment.contas (id_pessoa,saldo,limite_saque_diario,flag_ativo,tipo_conta,data_criacao) VALUES
(1,1000.5000,200.0000,1,13,'2021-12-16'),
(1,12450.5000,1000.0000,1,13,'2021-12-16'),
(1,0.0000,500.0000,1,13,'2021-12-16');

INSERT INTO payment.transacoes (id_conta,valor,data_transacao) VALUES
(1,50.0000,'2021-12-16');