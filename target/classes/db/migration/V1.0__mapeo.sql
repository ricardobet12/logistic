--create database logistic
create table if not exists clientes(
id_cliente serial,
nombre varchar(50),
apellido varchar(50),
telefono varchar(20),
correo varchar(50),
primary key(Id_cliente));

create table envio(
id_envio serial,
fecha_registro date,
fecha_entrada date,
precio_envio decimal(3,0),
descuento double precision,
fk_cliente int,
numero_guia varchar(10),
bodega int,
constraint producto_cliente foreign key(fk_cliente) references clientes(id_cliente),
primary key(id_envio));

create table if not exists logistica_maritima(
id_logistica_maritima serial,
bodega_entrega varchar(5),
placa_vehiculo varchar(10),
fk_envio int,
tipo_producto varchar(10),
cantidad_producto int,
constraint logistica_maritima_envio foreign key(fk_envio) references envio(id_envio),
primary key(id_logistica_maritima));

create table if not exists logistica_terrestre(
id_logistica_terrestre serial,
puerto_entrega int,
numero_flota int,
tipo_producto varchar(10),
cantidad_producto int,
fk_envio int,
constraint logistica_maritima_envio foreign key(fk_envio) references envio(id_envio),
primary key(id_logistica_terrestre));
