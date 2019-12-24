drop table if exists filial;
drop table if exists subConta;
drop table if exists conta;
drop table if exists entidade;
drop table if exists municipio;
drop table if exists usuario;

create table filial (
    versao  varchar(10),
    logo    blob sub_type 0 segment size 1000);

create table municipio(
    id int not null constraint pk_municipio primary key,
    nome varchar (60) not null,
    UF varchar(2),
    cep varchar(10));
    
create table entidade(
    id int not null constraint pk_entidade primary key,
    nome varchar(200) not null,
    telefone varchar(40),
    email varchar(100),    
    municipioId int,
    cep varchar(10),
    bairro varchar(30),
    rua varchar(40),
    numero varchar (8),    
    cpf varchar(14),
    rg varchar(25),
    cnpj varchar(18),
    ie varchar(20),
    constraint fk_entidade_municipio foreign key (municipioid) references municipio (id) );

create table conta (
  id int not null constraint pk_conta primary key, 
  entidadeID int not null, 
  dataCriacao date not null,
  valorTotal numeric(16,4),
  obs varchar (500),
  status int default 0 not null, --(0 = receber, 1 = pagar)
  constraint fk_conta_entidade foreign key (entidadeID) references entidade (id));

create table subConta (
  contaID int not null,
  sequencia int not null,
  dataVencimento date not null,
  dataPagamento date,
  valorParcela numeric(16,4),
  valorPago numeric(16,4),
  situacao int DEFAULT (0), --(0 = aberto, 1 = Pago, 2 = cancelado)
  repassado int DEFAULT (0), --(0 = Não, 1 = Sim)
  constraint pk_subConta primary key (contaID, sequencia),
  constraint fk_subConta_conta foreign key (contaID) references conta (id));

create table usuario(
    id int not null constraint pk_usuario primary key,
    senha int not null,
    email varchar(100),
    administrador int default 0 not null,
    numeroseguranca int);