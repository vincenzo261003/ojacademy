DROP DATABASE IF EXISTS GestioneAlberghi;
CREATE DATABASE GestioneAlberghi;
USE GestioneAlberghi;

CREATE TABLE Alberghi (
	idAlbergo INTEGER AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(200) NOT NULL,
    contattoTelefonico VARCHAR(20) NOT NULL,
    stelle INTEGER NOT NULL
);

CREATE TABLE Stanze (
	idStanza INTEGER AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    codice VARCHAR(50) NOT NULL,
    idAlbergoRIF INTEGER NOT NULL,
    statoOccupazione BOOLEAN DEFAULT(0),
    FOREIGN KEY (idAlbergoRIF) REFERENCES Alberghi(idAlbergo) ON DELETE CASCADE
);

INSERT INTO Alberghi(nome, email, contattoTelefonico, stelle) VALUE ("AlbergoProva", "albergo@prova.it", "+39 1234567890", 4);

INSERT INTO Stanze(nome, codice, idAlbergoRIF) VALUE ("StanzaProva", "SP2022", 1);


SELECT * FROM Alberghi;

SELECT * FROM Stanze;
