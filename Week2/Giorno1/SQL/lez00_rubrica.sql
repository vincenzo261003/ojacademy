-- DDL Data Definition Language
-- DROP DATABASE lez00_rubrica;				-- Eliminazione del DB
CREATE DATABASE lez00_rubrica;
USE lez00_rubrica;

CREATE TABLE Persona(
	nome VARCHAR(250),
    cognome VARCHAR(250),
    cod_fis VARCHAR(16)
);

-- DML Data Manipulation Language
INSERT INTO Persona (nome, cognome, cod_fis) VALUES
("Giovanni", "Pace", "PAGNN"),
("Mario", "Rossi", "MRRSS");

-- QL Query Language
SELECT * FROM Persona;
