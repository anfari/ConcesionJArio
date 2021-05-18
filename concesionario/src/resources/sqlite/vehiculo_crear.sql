Create table Vehiculo(
	    bastidor varchar(30) primary key not null,
        matricula varchar(10) not null,
	    marca varchar(20) not null,
	    modelo varchar(20) not null,
	    color varchar(20) not null,
	    precio float(2) not null,
        extrasInstalados varchar(50) not null,
        motor varchar(20) not null,
        potencia int(10) not null,
        cilindrada varchar(20) not null,
        tipo varchar(30) not null
);