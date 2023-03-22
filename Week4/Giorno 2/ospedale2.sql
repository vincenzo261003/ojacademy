DROP DATABASE IF EXISTS ospedale;
CREATE DATABASE ospedale;
USE ospedale;
 
CREATE TABLE Visite(
    idVisita INTEGER PRIMARY KEY AUTO_INCREMENT,
    nominativo VARCHAR(250) NOT NULL,
    codiceFiscale VARCHAR(16) NOT NULL,
    codice VARCHAR(36) NOT NULL UNIQUE,
    secret VARCHAR(36) NOT NULL,
    esito LONGTEXT,
    dataVisita DATE
);

SELECT * FROM Visite;