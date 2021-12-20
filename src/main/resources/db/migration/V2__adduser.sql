CREATE TABLE IF NOT EXISTS users(
id serial primary key,
username varchar(40) not null,
password varchar(30) not null,
unique (username)
);
