CREATE TABLE IF NOT EXISTS "Cliente" (
	"codigoCliente"	INTEGER NOT NULL,
	"dni"	VARCHAR(9) NOT NULL,
	PRIMARY KEY("codigoCliente" AUTOINCREMENT),
	FOREIGN KEY("dni") REFERENCES "Persona"("dni")
);