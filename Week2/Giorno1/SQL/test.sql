-- DDL (Data Definition Language) -> definisce la struttura
DROP DATABASE IF EXISTS lez00_rubrica;
CREATE DATABASE lez00_rubrica;
USE lez00_rubrica;

CREATE TABLE Persona(
	nome VARCHAR(250) NOT NULL,
    cognome VARCHAR(250) NOT NULL,
    telefono VARCHAR(250) DEFAULT "N.D.",
    cf VARCHAR(16) UNIQUE
);

-- DML (Data Manipulation Language) -> manipola i dati nel db
INSERT INTO Persona (nome, cognome, cf) 
VALUES ("Manuel", "Marinaro", "efjoiew"),
("Prova", "Uno", "Due");


-- QL (Query Language) -> interroga il DB
SELECT * FROM Persona;

ALTER TABLE Persona ADD COLUMN email VARCHAR(250) DEFAULT "N.D.";
ALTER TABLE Persona DROP COLUMN email;
ALTER TABLE Persona MODIFY COLUMN telefono INTEGER;

