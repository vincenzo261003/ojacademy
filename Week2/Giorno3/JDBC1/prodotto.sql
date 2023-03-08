DROP DATABASE IF EXISTS prodotto;
CREATE DATABASE prodotto;
USE prodotto;
 
CREATE TABLE Prodotto(
    prodottoID INTEGER PRIMARY KEY AUTO_INCREMENT,
    codice VARCHAR(10) NOT NULL UNIQUE,
    nome VARCHAR(250) NOT NULL,
    quantita INTEGER,
    categoria VARCHAR(250),
    prezzo FLOAT
);
 
INSERT INTO Prodotto(codice, nome, quantita, categoria, prezzo) VALUES 
("BS1234", "Biscotti", 12, "Colazione", 0.15),
("NT1235", "Nutella", 5, "Colazione", 4.35);
 
SELECT * FROM Prodotto;