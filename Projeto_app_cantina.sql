create database gestao_venda2024;

use gestao_venda2024; 

create table categoria(
id int primary key auto_increment,
nome varchar(50) not null unique,
descricao varchar(100)
);

SELECT * FROM categoria WHERE nome = 'Vestuario';

create table usuario(
id bigint primary key auto_increment,
nome varchar(75) not null,
username varchar(100) not null unique,
senha varchar(100) not null,
perfil varchar(10) not null default "PADRAO",
estado boolean not null default true,
data_hora_criacao datetime not null default current_timestamp,
ultimo_login datetime not null default '0001-01-01 00:00:00'
);

insert into usuario(nome, username, senha) values ('Danielly Souza', 'daniellys', '123456');

select * from usuario;

SELECT * FROM usuario WHERE username = 'daniellys';

create table produto(
id bigint primary key auto_increment,
nome varchar(75) not null unique,
descricao varchar(200),
preco decimal(10, 2) not null,
quantidade int not null,
categoria_id int not null,
usuario_id bigint not null,
data_hora_criacao datetime default current_timestamp,
constraint fk_produto_categoria foreign key(categoria_id) references categoria(id),
constraint fk_produto_usuario foreign key(usuario_id) references usuario(id)
);

insert into categoria(nome, descricao) values('Alimentação', 'Produtos alimentares 100% nacional e com qualidade');

create table cliente(
id int primary key auto_increment,
nome varchar(50),
telefone varchar(15),
morada varchar(100)
);

create table venda(
id int primary key auto_increment,
total_venda decimal(10,2) not null,
valor_pago decimal(10, 2) not null,
troco decimal(10, 2) not null,
desconto decimal(10, 2) not null,
cliente_id int,
usuario_id bigint not null,
data_hora_criacao datetime default current_timestamp,
ultima_actualizacao datetime default current_timestamp,
constraint fk_venda_cliente foreign key(cliente_id) references cliente(id),
constraint fk_venda_usuario foreign key(usuario_id) references usuario(id)
);

create table venda_item(
venda_id int not null,
produto_id bigint not null,
quantidade int not null,
total decimal(10, 2) not null,
desconto decimal(10, 2) not null,
constraint fk_venda_item_venda foreign key(venda_id) references venda(id),
constraint fk_venda_item_produto foreign key(produto_id) references produto(id)
);

















