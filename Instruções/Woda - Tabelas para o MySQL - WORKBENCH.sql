create database dbartists;

/*UTF=8*/
ALTER DATABASE dbartists COLLATE = 'utf8mb4_unicode_ci';

create table artists(
idartist int primary key auto_increment,
nome varchar(50) not null,
email varchar(50) unique default null, 
sexo varchar(10),
datadenascimento date not null,
nacionalidade varchar (20) not null,
cpf varchar(11) unique default null
);

create table arts(
idart int primary key auto_increment,
nome varchar(50) not null,
descricao varchar(240) not null,
datadepublicacao date,
datadeexposicao date
);

create table properties (
idprop int primary key auto_increment,
idartistfk int,
idartfk int,
foreign key (idartistfk) references artists(idartist),
foreign key (idartfk) references arts(idart)
);

create table authenticate(
userId int not null unique primary key,
userLogin varchar(50) unique not null,
userPassword varchar(50) not null
);

/*INSERIR LOGIN E SENHA DO PRIMEIRO USUARIO:*/
insert into authenticate (userId,userLogin,userPassword) values ('1','admin','admin123321');