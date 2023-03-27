DROP DATABASE IF EXISTS Palestre;
CREATE DATABASE Palestre;
USE Palestre;

CREATE TABLE Corsi (
	idCorso INTEGER PRIMARY KEY AUTO_INCREMENT,
    codiceCorso VARCHAR(5) NOT NULL UNIQUE,
    nome VARCHAR(50) NOT NULL,
    durataCorso INTEGER NOT NULL,
    dataCorso DATETIME NOT NULL,
    livelloCorso ENUM("Beginner", "Intermediate", "Pro") NOT NULL
);

CREATE TABLE Utenti (
	idUtente INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    pass VARCHAR(32) NOT NULL,
    isAdmin BOOLEAN DEFAULT(0)
);

CREATE TABLE PersonaCorso (
	idCorsoRIF INTEGER NOT NULL,
    idUtenteRIF INTEGER NOT NULL,
    FOREIGN KEY (idCorsoRIF) REFERENCES Corsi(idCorso) ON DELETE CASCADE,
    FOREIGN KEY (idUtenteRIF) REFERENCES Utenti(idUtente) ON DELETE CASCADE,
    PRIMARY KEY(idCorsoRIF, idUtenteRIF)
);

INSERT INTO Corsi(codiceCorso, nome, duratacorso, datacorso, livellocorso) VALUE ("ABCDE", "Test", 120, "2023-12-12", "Pro");

INSERT INTO Utenti(nome, cognome, email, pass) VALUE ("Test", "eqfwef", "Pro", "feffe");
INSERT INTO Utenti(nome, cognome, email, pass, isAdmin) VALUE ("ewewrewrewrewr", "werwerewr", "twtewtwet", "feffe", 1);

INSERT INTO PersonaCorso(idCorsoRIF, idUtenteRIF) VALUE (1, 1);

SELECT * FROM Utenti;
SELECT * FROM Corsi;