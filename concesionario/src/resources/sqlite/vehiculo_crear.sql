CREATE TABLE IF NOT EXISTS "Vehiculo" (
	"bastidor"	varchar(30) NOT NULL,
	"matricula"	varchar(30) UNIQUE,
	"marca"	varchar(30) NOT NULL,
	"modelo"	varchar(30) NOT NULL,
	"color"	varchar(30) NOT NULL,
	"precio"	REAL NOT NULL,
	"extrasInstalados"	varchar(30),
	"motor"	varchar(30) NOT NULL,
	"potencia"	INTEGER NOT NULL,
	"cilindrada"	varchar(30) NOT NULL,
	"tipo"	varchar(30) NOT NULL,
	"estado" varchar(20) NOT NULL,
	PRIMARY KEY("bastidor")
);