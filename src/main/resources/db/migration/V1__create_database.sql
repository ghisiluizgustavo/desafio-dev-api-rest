create table pessoas (
     id_pessoa int not null auto_increment primary key ,
     nome varchar(255),
     cpf char(11),
     data_nascimento date
);

create table contas (
    id_conta int not null auto_increment primary key ,
    id_pessoa int not null,
    saldo decimal(19,4),
    limite_saque_diario decimal(19,4),
    flag_ativo boolean,
    tipo_conta int,
    data_criacao date,
    foreign key (id_pessoa) references pessoas (id_pessoa)
);

create table transacoes (
    id_transacao int not null auto_increment primary key,
    id_conta int not null,
    valor decimal(19,4),
    data_transacao date,
    foreign key (id_conta) references contas (id_conta)
);