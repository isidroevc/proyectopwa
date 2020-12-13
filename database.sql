drop database if exists proyectopwa;
create database proyectopwa;
ALTER DATABASE proyectopwa CHARACTER SET utf8 COLLATE utf8_general_ci;
use proyectopwa;

create table users (
  id int primary key AUTO_INCREMENT,
  role varchar(60) not null,
  username varchar(30) unique,
  email varchar(100) unique,
  telefono varchar(25) unique,
  id_carrera int,
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
  creditos int not null,
  nombre varchar(255) not null,
  clave varchar(255) not null,
  foreign key (id_carrera) references carreras(id)
);



create table horario (
  id int AUTO_INCREMENT,
  turno varchar(30),
  detalle varchar(255),
  dias varchar(30),
   primary key (id)
);

insert into horario (turno, detalle, dias) 
values
  ('matutino', '7:00 - 8:40', 'L-M-V'),
  ('matutino', '8:45 - 10:25', 'L-M-V'),
  ('matutino', '10:30 - 12:10', 'L-M-V'),
  ('matutino', '12:15 - 14:30', 'L-M-V'),
  ('matutino', '7:00 - 8:40', 'Ma-J-V'),
  ('matutino', '8:45 - 10:25', 'Ma-J-V'),
  ('matutino', '10:30 - 12:10', 'Ma-J-V'),
  ('matutino', '12:15 - 13:55', 'Ma-J-V');


create table aula(
  id int primary key,
  nombre varchar(255)
);

insert into aula (id, nombre) values
(1, 'D-1'),
(3, 'D-3'),
(4, 'D-4'),
(5, 'D-5'),
(6, 'D-6'),
(7, 'D-7');

create table profesor_tiene_materia_en_horario_con_grupo(
  id int AUTO_INCREMENT,
  id_profesor int,
  id_materia int,
  id_horario int,
  id_aula int,
  id_carrera int,
  semestre int,
  numero_alumnos int,
  grupo varchar(4),
  constraint fk_horario_profesor foreign key (id_profesor) references users(id),
  constraint fk_horario_materia foreign key (id_materia) references materias(id),
  constraint fk_horario_horario foreign key (id_horario) references horario(id),
  constraint fk_horario_aula foreign key (id_aula) references aula(id),
  constraint fk_horario_carrera foreign key (id_carrera) references carreras(id),
  primary key(id)
);



/*inserts*/

insert into carreras (nombre, clave) values('Ingeniería en Sistemas Computacionales', 'ISX-2010');
insert into carreras (nombre, clave) values('Ingeniería en Tecnologías de la Información y la Comunicación', 'TIX-2010');

insert into materias (id_carrera, nombre, clave, creditos) values(2,'Cálculo Diferencial', 'SCD-2010', 5);
insert into materias (id_carrera, nombre, clave, creditos) values(1,'Matemáticas Discretas', 'MTD-210', 5);
/*admin*/
insert into users (username, email, telefono, id_carrera, role, password, enabled, nombre, primer_apellido, segundo_apellido)
  values('jose', 'jose@itleon.edu.mx', '4772394522', 1, 'ADMINISTRADOR', '$2y$12$c41vAyFBea4o4zFcDOufleekG2FKph0z5iut51nCzHFPH6d1VCNB6', 1, 'Jose Gerardo', 'Carpio', 'Flores');

insert into users (username, email, telefono, id_carrera, role, password, enabled, nombre, primer_apellido, segundo_apellido)
  values('antonio', 'antonio@itleon.edu.mx', '4772394521', 1, 'JEFE', '$2y$12$c41vAyFBea4o4zFcDOufleekG2FKph0z5iut51nCzHFPH6d1VCNB6', 1, 'Antonio', 'Aguila', 'Reyes');

insert into users (username, email, telefono, id_carrera, role, password, enabled, nombre, primer_apellido, segundo_apellido)
  values('luis', 'luis@itleon.edu.mx', '4772394523', 2, 'ADMINISTRADOR', '$2y$12$c41vAyFBea4o4zFcDOufleekG2FKph0z5iut51nCzHFPH6d1VCNB6', 1, 'Luis Eduardo', 'Gutierrez', 'Ayala');

insert into users (username, email, telefono, id_carrera, role, password, enabled, nombre, primer_apellido, segundo_apellido)
  values('cirino', 'cirino@itleon.edu.mx', '4772394524', 2, 'ADMINISTRADOR', '$2y$12$c41vAyFBea4o4zFcDOufleekG2FKph0z5iut51nCzHFPH6d1VCNB6', 1, 'Cirino', 'Silva', 'Tovar');

update carreras set id_jefe = 2 where true;



