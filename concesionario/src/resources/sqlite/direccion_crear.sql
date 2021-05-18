Create table Direccion(
   identificador varchar(20) primary key not null,
   calle varchar(20) not null,
   numero int (10) not null,
   codigoPostal varchar(5) not null,
   provincia varchar(20) not null,
   ciudad varchar(20) not null,
   pais varchar(20) not null
);