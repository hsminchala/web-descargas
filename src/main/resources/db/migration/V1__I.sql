CREATE TABLE IF NOT EXISTS usuario(
id serial primary key,
user varchar(20) not null,
status boolean
);

CREATE TABLE IF NOT EXISTS  programa (
id serial primary key,
nombre_programa varchar(50),
version varchar(20)
);

CREATE TABLE IF NOT EXISTS  descargas (
id serial primary key,
n_descarga int primary key,
fecha_descarga varchar(40),
programa_id int,
foreign key (programa_id) references programa(id)
);