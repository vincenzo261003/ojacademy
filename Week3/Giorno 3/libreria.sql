DROP DATABASE IF EXISTS libreria;
CREATE DATABASE libreria;
USE libreria;
 
CREATE TABLE Libri(
    libroID INTEGER PRIMARY KEY AUTO_INCREMENT,
    titolo VARCHAR(250) NOT NULL,
    descrizione VARCHAR(250) NOT NULL,
    autore VARCHAR(250) NOT NULL,
    data_pubblicazione VARCHAR(250) NOT NULL,
    isbn VARCHAR(32) NOT NULL UNIQUE,
    casaeditrice VARCHAR(250) NOT NULL,
    prezzo FLOAT NOT NULL
);
 
 
 SELECT * FROM Libri;
 
 
 
 
 
 
 
 