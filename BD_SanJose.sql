CREATE DATABASE BD_HospitalSanJose;
USE BD_HospitalSanJose;

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255),
    rol ENUM('COORDINADOR', 'GESTOR'),
    activo BOOLEAN DEFAULT TRUE
);



CREATE TABLE paciente (
    idPaciente INT AUTO_INCREMENT PRIMARY KEY,
    nombrePac VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    dni VARCHAR(8) UNIQUE NOT NULL,
    direccion VARCHAR(255),
    telefono VARCHAR(20),
    correo VARCHAR(255)
    
)
;