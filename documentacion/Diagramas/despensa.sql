-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-06-25 19:57:43.579

-- tables
-- Table: Cliente
CREATE TABLE Cliente (
    idCliente bigint NOT NULL,
    nombre varchar(500) NOT NULL,
    apellido varchar(150) NOT NULL,
    CONSTRAINT idCliente PRIMARY KEY (idCliente)
);

-- Table: Item_Venta
CREATE TABLE Item_Venta (
    idVenta bigint NOT NULL,
    idProducto bigint NOT NULL,
    cantidad int NOT NULL
);

-- Table: Producto
CREATE TABLE Producto (
    idProducto bigint NOT NULL,
    nombre varchar(45) NOT NULL,
    precio float NOT NULL,
    stock int NOT NULL,
    CONSTRAINT Producto_pk PRIMARY KEY (idProducto)
);

-- Table: Venta
CREATE TABLE Venta (
    idVenta bigint NOT NULL,
    idCliente bigint NOT NULL,
    fecha date NOT NULL,
    CONSTRAINT Venta_pk PRIMARY KEY (idVenta)
);

-- foreign keys
-- Reference: FACTURA_CLIENTE (table: Venta)
ALTER TABLE Venta ADD CONSTRAINT FACTURA_CLIENTE FOREIGN KEY FACTURA_CLIENTE (idCliente)
    REFERENCES Cliente (idCliente);

-- Reference: FACTURA_PRODUCTO_FACTURA (table: Item_Venta)
ALTER TABLE Item_Venta ADD CONSTRAINT FACTURA_PRODUCTO_FACTURA FOREIGN KEY FACTURA_PRODUCTO_FACTURA (idVenta)
    REFERENCES Venta (idVenta);

-- Reference: FACTURA_PRODUCTO_PRODUCTO (table: Item_Venta)
ALTER TABLE Item_Venta ADD CONSTRAINT FACTURA_PRODUCTO_PRODUCTO FOREIGN KEY FACTURA_PRODUCTO_PRODUCTO (idProducto)
    REFERENCES Producto (idProducto);

-- End of file.

