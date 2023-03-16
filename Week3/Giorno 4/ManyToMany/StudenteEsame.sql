DROP DATABASE IF EXISTS lez04_mtm_studente_esame;
CREATE DATABASE lez04_mtm_studente_esame;
USE lez04_mtm_studente_esame;

CREATE TABLE Studente(
	studenteID INTEGER PRIMARY KEY AUTO_INCREMENT,
    nominativo VARCHAR(250) NOT NULL,
    matricola VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE Esame(
	esameID INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(250) NOT NULL,
    crediti INTEGER DEFAULT 1,
    data_esame DATE				-- "YYYY-MM-DD"
);

CREATE TABLE Studente_Esame(
	studenteRIF INTEGER NOT NULL,
    esameRIF INTEGER NOT NULL,
    FOREIGN KEY (studenteRIF) REFERENCES Studente(studenteID) ON DELETE CASCADE,
    FOREIGN KEY (esameRIF) REFERENCES Esame(esameID) ON DELETE CASCADE,
    PRIMARY KEY(studenteRIF, esameRIF)
);

INSERT INTO Studente(nominativo, matricola) VALUES
("Giovanni Pace", "AB12345"),
("Valeria Verdi", "AB12346"),
("Mario Rossi", "AB12347");

INSERT INTO Esame(nome, crediti, data_esame) VALUES
("Analisi", 6, "2020-02-01"),
("Analisi", 6, "2020-02-02"),
("Fisica", 6, "2020-02-03"),
("Fisica", 6, "2020-02-04"),
("Informatica", 6, "2020-02-05");

INSERT INTO Studente_Esame(studenteRIF, esameRIF) VALUES
(1, 1),
(1, 3),
(2, 1),
(2, 4);

-- Studenti iscritti ad almeno un esame e studenti non iscritti
SELECT * 
	FROM Studente
    LEFT JOIN Studente_Esame ON Studente.studenteID = Studente_Esame.studenteRIF
    LEFT JOIN Esame ON Studente_Esame.esameRIF = Esame.esameID;
    
SELECT * 
	FROM Studente
    JOIN Studente_Esame ON Studente.studenteID = Studente_Esame.studenteRIF
    RIGHT JOIN Esame ON Studente_Esame.esameRIF = Esame.esameID;
    
-- INVERTIAMO

SELECT * 
	FROM Esame
    LEFT JOIN Studente_Esame ON Esame.esameID = Studente_Esame.esameRIF
    LEFT JOIN Studente ON Studente_Esame.studenteRIF = Studente.studenteID;
    
SELECT * 
	FROM Esame
    JOIN Studente_Esame ON Esame.esameID = Studente_Esame.esameRIF
    RIGHT JOIN Studente ON Studente_Esame.studenteRIF = Studente.studenteID;
    
