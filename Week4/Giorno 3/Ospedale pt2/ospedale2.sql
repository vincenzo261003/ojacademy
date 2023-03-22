DROP DATABASE IF EXISTS ospedale;
CREATE DATABASE ospedale;
USE ospedale;

CREATE TABLE Persone(
    idPersona INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(250) NOT NULL,
    cognome VARCHAR(250) NOT NULL,
    codiceFiscale VARCHAR(16) NOT NULL UNIQUE
);
 
CREATE TABLE Visite(
    idVisita INTEGER PRIMARY KEY AUTO_INCREMENT,
    codice VARCHAR(36) NOT NULL UNIQUE,
    secret VARCHAR(36) NOT NULL,
    esito LONGTEXT,
    dataVisita DATE,
    personaRIF INTEGER,
    FOREIGN KEY (personaRIF) REFERENCES Persone(idPersona) ON DELETE CASCADE
);

INSERT INTO Persone(nome, cognome, codiceFiscale) VALUE ("prova", "prova 1", "123456");

INSERT INTO Visite(codice, secret, esito, dataVisita, personaRIF) VALUE ("12143", "343214", "fewef", "2000-12-22", 1);

SELECT * FROM Visite
JOIN Persone ON Persone.idPersona = personaRIF;
