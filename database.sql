drop database if exists proyectopwa;
create database proyectopwa;
ALTER DATABASE proyectopwa CHARACTER SET utf8 COLLATE utf8_general_ci;
use proyectopwa;

create table users (
  id int primary key AUTO_INCREMENT,
  username varchar(30) unique,
  password varchar(255),
  enabled  tinyint,
  nombre varchar(255),
  primer_apellido varchar(255),
  segundo_apellido varchar(255)
);

create table carreras(
  id int primary key AUTO_INCREMENT,
  id_jefe int,
  nombre varchar(255) not null,
  clave varchar(255) not null,
  foreign key (id_jefe) references users(id)
);

create table materias(
  id int primary key AUTO_INCREMENT,
  id_carrera int not null,
  nombre varchar(255) not null,
  clave varchar(255) not null,
  foreign key (id_carrera) references carreras(id)
);

CREATE TABLE authorities (
  id int primary key AUTO_INCREMENT,
  user_id int not null,
  id_carrera int,
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (id_carrera) REFERENCES carreras(id)
);




/*inserts*/

insert into carreras (nombre, clave) values('Ingeniería en Sistemas Computacionales', 'ISX-2010');
insert into carreras (nombre, clave) values('Ingeniería en Tecnologías de la Información y la Comunicación', 'TIX-2010');

insert into materias (id_carrera, nombre, clave) values(2,'Cálculo Diferencial', 'SCD-2010');
insert into materias (id_carrera, nombre, clave) values(1,'Matemáticas Discretas', 'MTD-210');
/*admin*/
insert into users (username, password, enabled, nombre, primer_apellido, segundo_apellido)
  values('jose', '$2y$12$c41vAyFBea4o4zFcDOufleekG2FKph0z5iut51nCzHFPH6d1VCNB6', 1, 'Jose Gerardo', 'Carpio', 'Flores');

insert into users (username, password, enabled, nombre, primer_apellido, segundo_apellido)
  values('antonio', '$2y$12$c41vAyFBea4o4zFcDOufleekG2FKph0z5iut51nCzHFPH6d1VCNB6', 1, 'Antonio', 'Aguila', 'Reyes');

insert into users (username, password, enabled, nombre, primer_apellido, segundo_apellido)
  values('luis', '$2y$12$c41vAyFBea4o4zFcDOufleekG2FKph0z5iut51nCzHFPH6d1VCNB6', 1, 'Luis Eduardo', 'Gutierrez', 'Ayala');

insert into authorities (user_id, authority) values(1, 'USER');
insert into authorities (user_id, authority) values(1, 'ADMINISTRADOR');

insert into authorities (user_id, id_carrera, authority) values(1, 1, 'JEFE');




