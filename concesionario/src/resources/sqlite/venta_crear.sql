CREATE TABLE "Venta" (
	"identificador"	INTEGER NOT NULL,
	"dniEmpleado"	varchar(30) NOT NULL,
	"dniCliente"	varchar(30) NOT NULL,
	"bastidor"	varchar(30) NOT NULL,
	PRIMARY KEY("identificador" AUTOINCREMENT),
	FOREIGN KEY("bastidor") REFERENCES "Vehiculo"("bastidor"),
	FOREIGN KEY("dniCliente") REFERENCES "Cliente"("dni"),
	FOREIGN KEY("dniEmpleado") REFERENCES "Empleado"("dni")
);