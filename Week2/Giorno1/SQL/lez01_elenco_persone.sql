-- Primi step con il DDL
DROP DATABASE IF EXISTS lez01_elenco_persone;
CREATE DATABASE lez01_elenco_persone;
USE lez01_elenco_persone;

CREATE TABLE Persone(
	nome VARCHAR(250) NOT NULL,
    cognome VARCHAR(250) NOT NULL,
    telefono VARCHAR(250) DEFAULT "N.D.",
    cod_fis VARCHAR(16) UNIQUE NOT NULL
);

ALTER TABLE Persone ADD COLUMN email VARCHAR(250) DEFAULT "N.D."; 				-- Aggiunge all'ultimo
ALTER TABLE Persone ADD COLUMN email VARCHAR(250) DEFAULT "N.D." AFTER cognome; -- Aggiunge dopo...
ALTER TABLE Persone DROP COLUMN email;
ALTER TABLE Persone MODIFY COLUMN telefono VARCHAR(100) NOT NULL;
