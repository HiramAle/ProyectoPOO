-- Datos Prueba 

-- base de datos a utilizar 
use base_proyecto;

-- acceso administrador
INSERT INTO accesoAdmin (id_administrador, contrasenia) VALUES ('admin','admin');

-- datos de prueba clientes
INSERT INTO cliente (id_cliente, nombre, apP, apM, promociones) VALUES (11111, 'invitado', 'invitado', 'invitado', 1);
INSERT INTO cliente (id_cliente, nombre, apP, apM, promociones) VALUES (14567, 'Juan', 'Perez', 'Gonzalez', 1);
INSERT INTO cliente (id_cliente, nombre, apP, apM, promociones) VALUES (18942, 'Mariana', 'Flores', 'Galindo', 0);
INSERT INTO cliente (id_cliente, nombre, apP, apM, promociones) VALUES (14587, 'Guillermo', 'Olguin', 'Casas', 0);
INSERT INTO cliente (id_cliente, nombre, apP, apM, promociones) VALUES (14589, 'Florencia', 'Martinez', 'Lopez', 1);
 
-- datos prueba clientes estrella
INSERT INTO clienteestrella ( montoHistoricoCompra, id_cliente) VALUES (3400.0, 18942);
INSERT INTO clienteestrella (montoHistoricoCompra, id_cliente) VALUES (4000.0, 14567);

-- datos prueba clientes preferentes 
INSERT INTO clientepreferente (montoCredito, adeudo, id_cliente) VALUES (40000.0, 0.0, 14567);
INSERT INTO clientepreferente (montoCredito, adeudo, id_cliente) VALUES (10000.0, 5000.0, 14589);

-- datos prueba vendedor
INSERT INTO vendedor (id_vendedor, nombre, apP, apM, turno, horaEntrada, horaSalida) VALUES (29805, 'Pedro', 'Juarez', 'Mancera', 'M', '7:00', '13:00');
INSERT INTO vendedor (id_vendedor, nombre, apP, apM, turno, horaEntrada, horaSalida) VALUES (23569, 'Pablo', 'Martinez', 'Lopez', 'V', '13:30', '19:00');
INSERT INTO vendedor (id_vendedor, nombre, apP, apM, turno, horaEntrada, horaSalida) VALUES (29860, 'Adriana', 'Lopez', 'Ortega', 'M', '7:00', '13:00');
INSERT INTO vendedor (id_vendedor, nombre, apP, apM, turno, horaEntrada, horaSalida) VALUES (25678, 'Juanita', 'Herrera', 'Rodriguez', 'V', '13:00', '19:00');

-- datos pueba provedor
INSERT INTO provedor (id_provedor, compañia, direccion, telefono) VALUES (35680, 'Bachoco', 'Calle 32 Col.Juarez', '1256896214');
INSERT INTO provedor (id_provedor, compañia, direccion, telefono) VALUES (36789, 'Alpura', 'Calle 122 Col.Polanco', '4567981234');
INSERT INTO provedor (id_provedor, compañia, direccion, telefono) VALUES (39681, 'Lala', 'Calle 15 Col.Tlatelolco', '6723456555');

-- Datos prueba producto
INSERT INTO producto (id_producto, marca, descripcion, precioCompra, precioMayoreo, precioMenudeo, existencias, id_provedor) VALUES (47892, 'Crema Lala', 'Crema acida 250g ', 15, 18, 22, 84, 39681);
INSERT INTO producto (id_producto, marca, descripcion, precioCompra, precioMayoreo, precioMenudeo, existencias, id_provedor) VALUES (45678, 'Crema Alpura', 'Crema acida 500g', 18, 20, 24, 22,36789);
INSERT INTO producto (id_producto, marca, descripcion, precioCompra, precioMayoreo, precioMenudeo, existencias, id_provedor) VALUES (49673, 'Huevo', '18pzs', 20, 24, 28, 31, 35680);
INSERT INTO producto (id_producto, marca, descripcion, precioCompra, precioMayoreo, precioMenudeo, existencias, id_provedor) VALUES (46780, 'Leche Entera', 'Leche entera 1Lt', 15, 18, 20, 116, 39681);
INSERT INTO producto (id_producto, marca, descripcion, precioCompra, precioMayoreo, precioMenudeo, existencias, id_provedor) VALUES (46972, 'Leche Deslactosada', 'Leche deslactosada 2Lt', 20, 22, 24, 10, 36789);

-- Datos prueba Compra
INSERT INTO compra (id_compra, fecha, monto) VALUES (59845, '2020-05-14', 400.0);
INSERT INTO compra (id_compra, fecha, monto) VALUES (52789, '2020-04-28', 550.5);
INSERT INTO compra (id_compra, fecha, monto) VALUES (56789, '2020-03-10', 600.0);

-- Datos prueba Compra_Producto
INSERT INTO compra_producto (id_compra, id_producto, cantidad) VALUES (59845, 47892,  50);
INSERT INTO compra_producto (id_compra, id_producto, cantidad) VALUES (59845, 46780,  60);
INSERT INTO compra_producto (id_compra, id_producto, cantidad) VALUES (52789, 46972,  25);
INSERT INTO compra_producto (id_compra, id_producto, cantidad) VALUES (52789, 47892,  45);
INSERT INTO compra_producto (id_compra, id_producto, cantidad) VALUES (52789, 49673,  34);
INSERT INTO compra_producto (id_compra, id_producto, cantidad) VALUES (56789, 46780,  60);
INSERT INTO compra_producto (id_compra, id_producto, cantidad) VALUES (56789, 45678,  26);

-- Datos prueba Ventas 
INSERT INTO venta (id_venta, fecha, monto, id_vendedor, id_cliente) VALUES (67893, '2020-04-29', 72, 23569, 14589);
INSERT INTO venta (id_venta, fecha, monto, id_vendedor, id_cliente) VALUES (60395, '2020-06-16', 116, 25678, 14567);
INSERT INTO venta (id_venta, fecha, monto, id_vendedor, id_cliente) VALUES (64896, '2020-05-24', 168, 29860, 18942);
INSERT INTO venta (id_venta, fecha, monto, id_vendedor, id_cliente) VALUES (68937, '2020-07-11', 110, 23569, 14567);
INSERT INTO venta (id_venta, fecha, monto, id_vendedor, id_cliente) VALUES (64928, '2020-07-05', 286, 25678, 14587);

-- Datos prueba Venta_Producto
INSERT INTO venta_producto (id_venta, id_producto, cantidad) VALUES (64896, 46780, 4);
INSERT INTO venta_producto (id_venta, id_producto, cantidad) VALUES (64896, 45678, 3);
INSERT INTO venta_producto (id_venta, id_producto, cantidad) VALUES (64896, 47892, 2);
INSERT INTO venta_producto (id_venta, id_producto, cantidad) VALUES (60395, 46780, 4);
INSERT INTO venta_producto (id_venta, id_producto, cantidad) VALUES (60395, 46972, 2);
INSERT INTO venta_producto (id_venta, id_producto, cantidad) VALUES (68937, 46972, 5);
INSERT INTO venta_producto (id_venta, id_producto, cantidad) VALUES (64928, 45678, 1);
INSERT INTO venta_producto (id_venta, id_producto, cantidad) VALUES (64928, 47892, 5);
INSERT INTO venta_producto (id_venta, id_producto, cantidad) VALUES (64928, 46972, 8);
INSERT INTO venta_producto (id_venta, id_producto, cantidad) VALUES (67893, 49673, 3);

