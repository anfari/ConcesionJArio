Create table Persona(
  nombre varchar(20) not null,
  apellidos varchar(20) not null,
  dni varchar(9) primary key not null,
  fechaNacimiento varchar(20) not null,
  telefono varchar(20),
  foreing key (id_direccion) references Direccion(identificador)
);