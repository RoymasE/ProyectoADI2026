
use automotrizanthony;

create table secretario (
idsecretario varchar(100)  not null, 
nombre varchar(100),
apellido varchar(100),
cedula varchar(100),
telefono varchar(100),
direccion varchar(100),
estado int,
primary key (idsecretario)

);

create table producto(
idproducto varchar(100),
nombre varchar(100),
cantidad int,
precio double,
descripcion varchar(100),
estado varchar(100),
primary key (idproducto)
);

create table cliente(
idcliente varchar(100) not null,
nombre varchar(100),
estado int,
primary key (idcliente)
);

create table venta(
idventa int unsigned not null auto_increment,
idcliente varchar(100) not null,
idproducto varchar(100),
fechaventa varchar(100),
subtotal double,
estado varchar(100),
primary key(idventa),
foreign key (idcliente) references cliente (idcliente) ON DELETE CASCADE,
foreign key (idproducto) references producto (idproducto) ON DELETE CASCADE
);

create table factura(
idfactura int unsigned not null AUTO_INCREMENT,
idventa int unsigned not null, 
catidad int,
subtotal double,
fecha varchar(100),
correo varchar(100),
IVA double,
IRPF DOUBLE,
idsecretario int unsigned not null,
primary key (idfactura),
foreign key(idventa) references venta(idventa) ON DELETE CASCADE

);


create table reguistro(
idreguistro varchar(100) not null,
idcliente varchar(100),
idsecretario varchar(100),
primary key (idreguistro),
foreign key (idcliente) references cliente(idcliente) ON DELETE CASCADE,
foreign key (idsecretario) references secretario(idsecretario) ON DELETE CASCADE
);
