CREATE TABLE IF NOT EXISTS "Empleado" (
	"codigoEmpleado"	INTEGER NOT NULL,
	"rango"	varchar(20) NOT NULL,
	"contrasenia"	varchar(20) NOT NULL,
	"dni"	varchar(9) NOT NULL,
	PRIMARY KEY("codigoEmpleado" AUTOINCREMENT),
	FOREIGN KEY("dni") REFERENCES "Persona"("dni")
);