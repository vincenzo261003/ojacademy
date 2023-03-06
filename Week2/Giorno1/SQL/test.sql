-- DDL -> definisce la struttura
-- CREATE DATABASE lez00_rubrica;
-- DROP DATABASE lez00_rubrica;
USE lez00_rubrica;

CREATE TABLE Persona(
	nome VARCHAR(250),
    cognome VARCHAR(250),
    cf VARCHAR(16)
);

-- DML -> manipola i dati nel db
INSERT INTO Persona (nome, cognome, cf) 
VALUES ("Manuel", "Marinaro", "MRNVCN03R26D912X"),
("Prova", "Uno", "Due");


-- QL -> interroga il DB
SELECT * FROM Persona;
