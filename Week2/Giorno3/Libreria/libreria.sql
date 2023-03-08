DROP DATABASE IF EXISTS libreria;
CREATE DATABASE libreria;
USE libreria;

CREATE TABLE libro (
	idLibro INTEGER PRIMARY KEY AUTO_INCREMENT,
    titolo VARCHAR(250),
    descrizione VARCHAR(250),
    dataPubblicazione INTEGER,
    prezzo FLOAT,
    autore VARCHAR(250),
    ISBN VARCHAR(250) UNIQUE
);

INSERT INTO libro(titolo, descrizione, dataPubblicazione, prezzo, autore, ISBN) VALUES 
("Harry Potter", "Fantasy", 2000, 13.5, "Manuel", "42743982784"),
("Prova", "prova 2", 1900, 10, "io", "328409832904");
