DROP DATABASE IF EXISTS lez07_rubrica;
CREATE DATABASE lez07_rubrica;
USE lez07_rubrica;
 
CREATE TABLE Persona(
    personaID INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(250) NOT NULL,
    cognome VARCHAR(250) NOT NULL,
    cod_fis VARCHAR(16) NOT NULL UNIQUE,
    telefono VARCHAR(100),
    email VARCHAR(100)
);
 
SELECT * FROM Persona;

INSERT INTO Persona(nome, cognome, cod_fis, telefono) VALUES 
("3r2", "Pace", "32r", "123456"),
("Giovanni", "Pace", "PCA32r3rGN3N", "123456");