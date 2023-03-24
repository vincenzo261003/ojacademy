DROP DATABASE IF EXISTS Palestre;
CREATE DATABASE Palestre;
USE Palestre;

CREATE TABLE Corsi (
	idCorso INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    durataCorso INTEGER NOT NULL,
    dataCorso DATETIME NOT NULL,
    livelloCorso ENUM("Beginner", "Intermediate", "Pro") NOT NULL,
    UNIQUE(nome, dataCorso)
);

CREATE TABLE Utenti (
	idUtente INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    pass VARCHAR(32) NOT NULL
);

CREATE TABLE PersonaCorso (
	idCorsoRIF INTEGER NOT NULL,
    idUtenteRIF INTEGER NOT NULL,
    FOREIGN KEY (idCorsoRIF) REFERENCES Corsi(idCorso) ON DELETE CASCADE,
    FOREIGN KEY (idUtenteRIF) REFERENCES Utenti(idUtente) ON DELETE CASCADE,
    PRIMARY KEY(idCorsoRIF, idUtenteRIF)
);

INSERT INTO Corsi(nome, duratacorso, datacorso, livellocorso) VALUE ("Test", 120, "2023-12-12", "Pro");

INSERT INTO Utenti(nome, cognome, email, pass) VALUE ("Test", "eqfwef", "Pro", "feffe");

INSERT INTO PersonaCorso(idCorsoRIF, idUtenteRIF) VALUE (1, 1);


SELECT * FROM Corsi;