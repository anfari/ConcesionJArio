CREATE TABLE IF NOT EXISTS "Direccion" (
	"identificador"	varchar(20) NOT NULL,
	"calle"	varchar(20) NOT NULL,
	"numero"	varchar(20) NOT NULL,
	"codigoPostal"	INTEGER NOT NULL,
	"provincia"	varchar(20) NOT NULL,
	"ciudad"	varchar(20) NOT NULL,
	"pais"	varchar(20) NOT NULL,
	PRIMARY KEY("identificador"),
	FOREIGN KEY("identificador") REFERENCES "Persona"("dni")
);