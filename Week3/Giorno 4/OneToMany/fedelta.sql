DROP DATABASE IF EXISTS lez04_otm_carte_fedelta;
CREATE DATABASE lez04_otm_carte_fedelta;
USE lez04_otm_carte_fedelta;

CREATE TABLE Persona(
	personaID INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(250) NOT NULL,
    cognome VARCHAR(250) NOT NULL,
    cod_fis VARCHAR(16) NOT NULL UNIQUE,
    email VARCHAR(250)
);

CREATE TABLE Carta(
	cartaID INTEGER PRIMARY KEY AUTO_INCREMENT,
    codice VARCHAR(10) NOT NULL UNIQUE,
    negozio VARCHAR(100) NOT NULL,
    personaRIF INTEGER NOT NULL,
    FOREIGN KEY (personaRIF) REFERENCES Persona(personaID) ON DELETE CASCADE
);

INSERT INTO Persona(nome, cognome, cod_fis, email) VALUES
("Giovanni", "Pace", "PCAGNN", "gio@pace.com"),
("Mario", "Rossi", "MRRRSS", "mario@rossi.com"),
("Valeria", "Verdi", "VLRVRD", "valeria@verdi.com");

INSERT INTO Persona(nome, cognome, cod_fis, email) VALUE
("Marika", "Mariko", "MRKMRK", "marika@mariko.com");

INSERT INTO Carta(codice, negozio, personaRIF) VALUES
("12345", "Coop", 1), 
("12346", "Coop", 2), 
("12347", "Coop", 3), 
("TT123", "Tigotà", 1), 
("TT124", "Tigotà", 2);

SELECT * FROM Persona;
SELECT * FROM Carta;

SELECT *
	FROM Persona
    JOIN Carta ON Persona.personaID = Carta.personaRIF;

    

    
