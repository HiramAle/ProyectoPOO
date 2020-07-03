drop database if exists base_proyecto;
#base de datos proyecto poo
CREATE DATABASE IF NOT EXISTS base_proyecto;
#selecionar BD a usar 
USE base_proyecto;
  
#Creacion de tablas cliente
CREATE TABLE IF NOT EXISTS vendedor (
	id_vendedor INT NOT NULL PRIMARY KEY,
    nombre VARCHAR(40) NOT NULL,
    apP VARCHAR(20) NOT NULL,
    apM VARCHAR(20) NOT NULL,
    turno VARCHAR(1) ,
    horaEntrada VARCHAR(6) NOT NULL,
    horaSalida VARCHAR(6) NOT NULL
); 

CREATE TABLE IF NOT EXISTS cliente (
	id_cliente INT NOT NULL PRIMARY KEY,
    nombre VARCHAR(40) NOT NULL,
    apP VARCHAR(20) NOT NULL,
    apM VARCHAR(20) NOT NULL,
    promociones boolean
); 

CREATE TABLE IF NOT EXISTS provedor (
	id_provedor INT NOT NULL PRIMARY KEY,
    compañia VARCHAR(40) NOT NULL,
    direccion VARCHAR(150),
    telefono VARCHAR(10)
); 

CREATE TABLE IF NOT EXISTS producto (
	id_producto INT NOT NULL PRIMARY KEY,
    marca VARCHAR(40) NOT NULL,
    descripcion VARCHAR(150),
    precioCompra DOUBLE NOT NULL,
    precioMayoreo DOUBLE NOT NULL,
    precioMenudeo DOUBLE NOT NULL,
    existencias  INT,
    id_provedor INT,
    foreign key (id_provedor) references provedor(id_provedor) on delete cascade on update cascade
); 

CREATE TABLE IF NOT EXISTS compra (
	id_compra INT NOT NULL PRIMARY KEY,
    fecha DATE NOT NULL,
    monto DOUBLE NOT NULL
); 

CREATE TABLE IF NOT EXISTS clienteEstrella (
	id_clienteE INT auto_increment NOT NULL PRIMARY KEY,
    montoHistoricoCompra DOUBLE NOT NULL,
    id_cliente INT,
    foreign key (id_cliente) references cliente(id_cliente) on delete cascade on update cascade
); 

CREATE TABLE IF NOT EXISTS clientePreferente (
	id_clienteP INT auto_increment NOT NULL PRIMARY KEY,
    montoCredito DOUBLE NOT NULL,
    adeudo DOUBLE NOT NULL,
    id_cliente INT,
    foreign key (id_cliente) references cliente(id_cliente) on delete cascade on update cascade
); 

CREATE TABLE IF NOT EXISTS venta (
	id_venta INT NOT NULL PRIMARY KEY,
    fecha DATE NOT NULL,
    monto DOUBLE NOT NULL,
    id_vendedor INT NOT NULL,
    id_cliente INT NOT NULL,
    foreign key (id_vendedor) references vendedor(id_vendedor) on delete cascade on update cascade,
    foreign key (id_cliente) references cliente(id_cliente) on delete cascade on update cascade
); 

CREATE TABLE IF NOT EXISTS venta_producto (
	id_venta INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    primary key (id_venta, id_producto),
    foreign key (id_venta) references venta(id_venta) on delete cascade on update cascade,
    foreign key (id_producto) references producto(id_producto) on delete cascade on update cascade
); 

CREATE TABLE IF NOT EXISTS compra_producto (
	id_compra INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    primary key (id_compra, id_producto),
    foreign key (id_compra) references compra(id_compra) on delete cascade on update cascade,
    foreign key (id_producto) references producto(id_producto) on delete cascade on update cascade
); 

CREATE TABLE IF NOT EXISTS accesoAdmin (
	id_administrador VARCHAR(15) NOT NULL PRIMARY KEY,
    contrasenia VARCHAR(15)
);



