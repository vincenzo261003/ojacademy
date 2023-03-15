DROP DATABASE IF EXISTS libreriax;
CREATE DATABASE libreriax;
USE libreriax;
 
CREATE TABLE Libreria(
    libroID INTEGER PRIMARY KEY AUTO_INCREMENT,
    titolo VARCHAR(250) NOT NULL,
    descrizione VARCHAR(250) NOT NULL,
    autore VARCHAR(250) NOT NULL,
    data_pubblicazione VARCHAR(250) NOT NULL,
    isbn VARCHAR(32) NOT NULL UNIQUE,
    casaeditrice VARCHAR(250) NOT NULL,
    prezzo FLOAT NOT NULL
);
 
 INSERT INTO Libreria (titolo, descrizione, autore, data_pubblicazione, isbn, casaeditrice, prezzo) VALUES 
 ("Il nome della rosa", "Il romanzo è ambientato nel 1327, in un'abbazia benedettina situata in una valle tra le montagne dell'Italia settentrionale", "Umberto Eco", "1980", "9788845222777", "Editrice La nave di Teseo", 20)
;
 