CREATE TABLE "Venta" (
	"identificador"	INTEGER NOT NULL,
	"codigoEmpleado"	INTEGER NOT NULL,
	"codigoCliente"	INTEGER NOT NULL,
	"bastidor"	varchar(30) NOT NULL,
	PRIMARY KEY("identificador" AUTOINCREMENT),
	FOREIGN KEY("bastidor") REFERENCES "Vehiculo"("bastidor"),
	FOREIGN KEY("codigoCliente") REFERENCES "Cliente"("codigoCliente"),
	FOREIGN KEY("codigoEmpleado") REFERENCES "Empleado"("codigoEmpleado")
);