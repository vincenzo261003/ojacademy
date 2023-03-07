DROP DATABASE IF EXISTS lez03_universita;       -- DA FARE SOLO IN FASE DI SVILUPPO DELLO SCHEMA
CREATE DATABASE lez03_universita;
USE lez03_universita;

CREATE TABLE Studente(
	studenteID INTEGER PRIMARY KEY AUTO_INCREMENT,
    codice_fiscale VARCHAR(16) NOT NULL,
    nome VARCHAR(250) NOT NULL,
    cognome VARCHAR(250) NOT NULL,
    matricola VARCHAR(10) NOT NULL,
    anno_immatr INTEGER CHECK (anno_immatr > 1900 AND anno_immatr < 2100),
    corso_laurea VARCHAR(250) DEFAULT "N.D.",
    UNIQUE(matricola),
    UNIQUE(codice_fiscale)
);


-- DML
INSERT INTO Studente(nome, cognome, codice_fiscale, matricola, anno_immatr) VALUES
("Giovanni", "Pace", "PCAGNN", "AB12345", 2005),
("Mario", "Rossi", "MRRRSS", "AB12346", 2004),
("Valeria", "Verdi", "VLRVRD", "AB12347", 2012),
("Giovanna", "Micochero", "GVNMCC", "AB12348", 2013),
("Maria", "Rossa", "MRRMRS", "AB12349", 2005);

INSERT INTO Studente(nome, cognome, codice_fiscale, matricola, anno_immatr) VALUES
("Giovannino", "Rossano", "GNNRSN", "AB12350", 2005);

UPDATE Studente SET corso_laurea = "Fisica" WHERE matricola = "AB12347";
UPDATE Studente SET corso_laurea = "Fisica" WHERE matricola = "AB12348";
UPDATE Studente SET corso_laurea = "Informatica" WHERE matricola = "AB12349";

-- QL
SELECT * FROM Studente;

SELECT nome, cognome, corso_laurea AS "Corso di laurea", matricola 
	FROM Studente;
    
SELECT *
	FROM Studente
    WHERE corso_laurea = "Fisica" OR corso_laurea = "Informatica";

SELECT *
	FROM Studente
    WHERE corso_laurea IN ("Informatica", "Fisica");
    
SELECT *
	FROM Studente
    WHERE corso_laurea NOT IN ("Informatica", "Fisica");
    
SELECT *
	FROM Studente
    WHERE corso_laurea <> "N.D.";
    
-- RIcerche parziali
SELECT *
	FROM Studente
    WHERE nome LIKE "Giov%";
    
SELECT *
	FROM Studente
    WHERE nome LIKE "%ia";
    
SELECT *
	FROM Studente
    WHERE nome LIKE "%va%";
    
SELECT *
	FROM Studente
    WHERE nome LIKE "Gio_ann___";

-- Tutti gli iscritti ad almeno un corso di laurea immatricolati dopo il 2005
SELECT *
	FROM Studente
    WHERE corso_laurea <> "N.D." AND anno_immatr > 2005;
    
SELECT COUNT(matricola) AS "contatore"
	FROM Studente
    WHERE corso_laurea = "Fisica";
    
SELECT corso_laurea, COUNT(matricola) AS contatore
	FROM Studente
    GROUP BY corso_laurea
    ORDER BY contatore DESC;
    
SELECT *
	FROM Studente
    ORDER BY anno_immatr, cognome ASC;