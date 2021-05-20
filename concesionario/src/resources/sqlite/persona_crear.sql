CREATE TABLE IF NOT EXISTS "Persona" (
	"nombre"	varchar(20) NOT NULL,
	"apellidos"	varchar(20) NOT NULL,
	"dni"	varchar(9) NOT NULL,
	"fechaNacimiento"	varchar(20) NOT NULL,
	"telefono"	varchar(20) NOT NULL,
	PRIMARY KEY("dni")
);