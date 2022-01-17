CREATE TABLE IF NOT EXISTS  programa (
id serial primary key,
nombre_programa varchar(50),
version varchar(20)
);

CREATE TABLE IF NOT EXISTS descargas (
id serial primary key,
numero_descarga varchar(30),
fecha_descarga varchar(40),
programa_id int,
foreign key (programa_id) references programa(id)
);

CREATE TABLE IF NOT EXISTS usuario(
id serial primary key,
username varchar(20) not null,
descargas_id int,
foreign key (descargas_id) references descargas(id)
);
