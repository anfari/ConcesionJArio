Create table Cliente(
 codigoCliente varchar(20) auto_increment primary key,
 foreing key(codigoCliente) references Persona(dni)
);