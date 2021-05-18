Create table Empleado(
 codigoEmpleado varchar(20) auto_increment primary key,
 rango varchar(20) not null,
 contraseña varchar(20) not null,
 foreing key(codigoEmpleado) references Persona(dni)
);