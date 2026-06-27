
use automotrizanthony;
-- SECRETARIO
INSERT INTO secretario VALUES
(1,'Anthony','Ramirez','1234567890','0991111111','Av. Principal 123',1),
(2,'Maria','Lopez','0987654321','0992222222','Calle Central 456',1);

-- PRODUCTO
INSERT INTO producto VALUES
(1,'Aceite Motor',50,25.50,'Aceite sintético para motor',1),
(2,'Filtro de Aire',30,15.00,'Filtro para vehículos',1),
(3,'Batería 12V',10,120.00,'Batería para automóvil',1);

-- CLIENTE
INSERT INTO cliente VALUES
('CLI001','Juan Perez',1),
('CLI002','Ana Torres',1),
('CLI003','Carlos Mendoza',1);

-- VENTA
INSERT INTO venta(idcliente,idproducto,fechaventa,subtotal,estado) VALUES
('CLI001',1,'2026-06-20',25.50,1),
('CLI002',2,'2026-06-20',15.00,1),
('CLI003',3,'2026-06-20',120.00,1);

-- FACTURA
INSERT INTO factura
(idventa,catidad,subtotal,fecha,correo,IVA,IRPF,idsecretario)
VALUES
(1,1,25.50,'2026-06-20','juan@gmail.com',3.06,0.00,1),
(2,1,15.00,'2026-06-20','ana@gmail.com',1.80,0.00,1),
(3,1,120.00,'2026-06-20','carlos@gmail.com',14.40,0.00,1);

-- REGUISTRO
INSERT INTO reguistro VALUES
('REG001','CLI001','SEC001'),
('REG002','CLI002','SEC001'),
('REG003','CLI003','SEC002');