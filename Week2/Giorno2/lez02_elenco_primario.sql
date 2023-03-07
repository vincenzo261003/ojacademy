-- DDL
DROP DATABASE IF EXISTS lez02_elenco_primario;
CREATE DATABASE lez02_elenco_primario;
USE lez02_elenco_primario;

CREATE TABLE Persona(
	personaID INTEGER PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(250) NOT NULL,
    cognome VARCHAR(250) NOT NULL,
    telefono VARCHAR(250) DEFAULT "N.D.",
    cod_fis VARCHAR(16) UNIQUE NOT NULL
);

-- DML
/*
INSERT INTO Persona(nome, cognome, cod_fis, telefono) VALUES 
("Giovanni", "Pace", "PCAGNN", "123456");
INSERT INTO Persona(personaID, nome, cognome, cod_fis, telefono) VALUES 
(78, "Mario", "Rossi", "MRRRSS", "123457");
INSERT INTO Persona(nome, cognome, cod_fis, telefono) VALUES 
("Valeria", "Verdi", "VLRVRD", "123457");

-- ELiminazione
DELETE FROM Persona WHERE cod_fis = "MRRRSS";

-- Modifica
UPDATE Persona SET nome = "Valeriuccia", cognome = "Verdone" WHERE cod_fis = "VLRVRD";

-- QL
SELECT * FROM Persona;
SELECT cognome, nome FROM Persona;

SELECT * FROM Persona WHERE cod_fis = "VLRVRD"
*/

-- Statement non può avere effetti parziali, atomico ed autoconsistente.
INSERT INTO Persona(nome, cognome, cod_fis, telefono) VALUES 
("Giovanni", "Pace", "PCAGNN", "123456"),
("Giovanni", "Pace", "PCAGNN", "123456"),
("Mario", "Rossi", "MRRRSS", "123457");

SELECT * FROM Persona;










