CREATE DATABASE IF NOT EXISTS banco;

USE banco;

CREATE TABLE persona (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    genero VARCHAR(255),
    edad INT,
    identificacion VARCHAR(255),
    direccion VARCHAR(255),
    telefono VARCHAR(255)
);

CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    contrasena VARCHAR(255),
    estado INT,
    fecha DATE,
    FOREIGN KEY (id) REFERENCES persona(id)
);

CREATE TABLE cuenta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numeroCuenta VARCHAR(255) UNIQUE,
    tipoCuenta VARCHAR(255),
    saldoInicial DOUBLE,
    estado Boolean,
    clienteId BIGINT,
    FOREIGN KEY (clienteId) REFERENCES cliente(Id)
);

CREATE TABLE movimiento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE,
    tipoMovimiento VARCHAR(255),
    valor DOUBLE,
    saldo DOUBLE,
    cuentaId BIGINT,
    FOREIGN KEY (cuentaId) REFERENCES cuenta(id)
);

INSERT INTO `persona` (`nombre`, `genero`, `edad`, `identificacion`, `direccion`, `telefono`)
VALUES
  ('Juan Perez', 'M', 32, '123456', 'Calle 123', '3001234567'),
  ('Maria Lopez', 'F', 25, '234567', 'Avenida 45', '3102345678'),
  ('Carlos Rodriguez', 'M', 40, '345678', 'Carrera 67', '3203456789'),
  ('Ana Torres', 'F', 28, '456789', 'Calle 89', '3304567890'),
  ('Luis Morales', 'M', 35, '567890', 'Avenida 12', '3405678901'),
  ('Pedro Gonzales', 'M', 45, '678901', 'Calle 34', '3506789012'),
  ('Lucia Ramirez', 'F', 30, '789012', 'Carrera 56', '3607890123');

INSERT INTO `cliente` (`id`, `contrasena`, `estado`, `fecha`)
VALUES
  (1,  'contrasena1', TRUE, '2023-01-01'),
  (2,  'contrasena2', TRUE, '2023-02-01'),
  (3,  'contrasena3', FALSE, '2023-03-01'),
  (4,  'contrasena4', TRUE, '2023-04-01'),
  (5, 'contrasena5', FALSE, '2023-05-01'),
  (6, 'contrasena6', TRUE, '2023-06-01'),
  (7, 'contrasena7', FALSE, '2023-07-01');

INSERT INTO `cuenta` (`numeroCuenta`, `tipoCuenta`, `saldoInicial`, `estado`, `clienteId`)
VALUES
  ('1234567890', 'Corriente', 5000.0, TRUE, 1),
  ('2345678901', 'Corriente', 15000.0, FALSE, 2),
  ('3456789012', 'Ahorros', 20000.0, TRUE, 3),
  ('4567890123', 'Corriente', 25000.0, FALSE, 4),
  ('5678901234', 'Ahorros', 30000.0, TRUE, 5),
  ('6789012345', 'Corriente', 35000.0, FALSE, 6),
  ('7890123456', 'Corriente', 40000.0, TRUE, 7);

  INSERT INTO `movimiento` (`fecha`, `tipoMovimiento`, `valor`, `saldo`, `cuentaId`)
VALUES
  ('2023-05-13', 'Depósito', 500.0, 5500.0, 1),
  ('2023-05-14', 'Retiro', 1000.0, 14000.0, 2),
  ('2023-05-15', 'Depósito', 1500.0, 21500.0, 3),
  ('2023-05-16', 'Retiro', 2000.0, 23000.0, 4),
  ('2023-05-17', 'Depósito', 2500.0, 32500.0, 5),
  ('2023-05-18', 'Retiro', 3000.0, 32000.0, 6),
  ('2023-05-19', 'Depósito', 3500.0, 43500.0, 7);