DROP DATABASE IF EXISTS blockbuster;
CREATE DATABASE blockbuster;
USE blockbuster;

CREATE TABLE Regista (
	idRegista INTEGER PRIMARY KEY AUTO_INCREMENT,
    cognome VARCHAR(50) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    dataNascita DATE NOT NULL,
    luogoNascita VARCHAR(250) NOT NULL
);

CREATE TABLE Attore (
	idAttore INTEGER PRIMARY KEY AUTO_INCREMENT,
    cognome VARCHAR(50) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    dataNascita DATE NOT NULL,
    luogoNascita VARCHAR(250) NOT NULL,
    linkImmagine VARCHAR(250)
);

CREATE TABLE Film (
	idFilm INTEGER PRIMARY KEY AUTO_INCREMENT,
    titolo VARCHAR(50) NOT NULL,
    annoProduzione INTEGER NOT NULL,
    nazionalita VARCHAR(50) NOT NULL,
    lingua VARCHAR(50) NOT NULL,
    registaRIF INTEGER NOT NULL,
    FOREIGN KEY(registaRIF) REFERENCES Regista(idRegista) ON DELETE CASCADE
);

CREATE TABLE Dvd (
	idDVD INTEGER PRIMARY KEY AUTO_INCREMENT,
    posizioneVideoteca VARCHAR(250),
    filmRIF INTEGER NOT NULL,
    FOREIGN KEY(filmRIF) REFERENCES Film(idFilm) ON DELETE CASCADE
);

CREATE TABLE Film_attore(
	attoreRIF INTEGER NOT NULL,
    filmRIF INTEGER NOT NULL,
    FOREIGN KEY (attoreRIF) REFERENCES Attore(idAttore) ON DELETE CASCADE,
    FOREIGN KEY (filmRIF) REFERENCES Film(idFilm) ON DELETE CASCADE,
    PRIMARY KEY(attoreRIF, filmRIF)
);


INSERT INTO Regista(cognome, nome, dataNascita, luogoNascita) VALUES
("Marinaro", "Manuel", "2003-10-26", "Milano"),
("Marinaro2", "Manuel2", "2003-10-28", "Roma");

INSERT INTO Attore(cognome, nome, dataNascita, luogoNascita) VALUES
("Marinaro3", "Manuel3", "2001-10-26", "Varese"),
("Marinaro4", "Manuel4", "2002-10-28", "Como");

INSERT INTO Film(titolo, annoProduzione, nazionalita, lingua, registaRIF) VALUES
("prova", 2000, "efjie", "italiano", 1),
("wawdwqd", 2200, "q3oijrqjfe", "russo", 2);

INSERT INTO Dvd(posizioneVideoteca, filmRIF) VALUES 
 


SELECT * FROM Film;
