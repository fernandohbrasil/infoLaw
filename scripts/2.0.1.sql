--drop table filial;
--drop table subconta;
--drop table conta;
--drop table entidade;
--drop table municipio;
--drop table usuario;

create table filial (
    versao  varchar(10),
    logo    blob sub_type 0 segment size 1000);

create table usuario(
    id int not null constraint pk_usuario primary key,
    senha int not null,
    username varchar(100),
    administrador int default 0 not null);

insert into usuario (id, senha, username, administrador) values (1, 1234, 'alvaro', 0);
insert into usuario (id, senha, username, administrador) values (2, 1234, 'rita', 0);

create table municipio(
    id int not null constraint pk_municipio primary key,
    nome varchar (60) not null,
    uf varchar(2),
    cep varchar(10));
    
create table entidade(
    id int not null constraint pk_entidade primary key,
    nome varchar(200) not null,
    telefone varchar(40),
    email varchar(100),    
    municipioid int,
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
  entidadeid int not null, 
  datacriacao date not null,
  valortotal numeric(16,4),
  obs varchar (500),
  status int default 0 not null, --(0 = receber, 1 = pagar)
  usuarioid int default 1 not null ,
  usuarioidalteracao int default 1 not null,
  constraint fk_conta_entidade foreign key (entidadeid) references entidade (id));

create table subconta (
  contaid int not null,
  sequencia int not null,
  datavencimento date not null,
  datapagamento date,
  valorparcela numeric(16,4),
  valorpago numeric(16,4),
  situacao int default 0, --(0 = aberto, 1 = pago, 2 = cancelado)
  repassado int default 0, --(0 = não, 1 = sim)
  usuarioid int default 1 not null ,
  usuarioidalteracao int default 1 not null,
  constraint pk_subconta primary key (contaid, sequencia),
  constraint fk_subconta_conta foreign key (contaid) references conta (id));