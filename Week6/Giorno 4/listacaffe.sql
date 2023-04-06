DROP DATABASE IF EXISTS ListaCaffe;
CREATE DATABASE ListaCaffe;
USE ListaCaffe;

CREATE TABLE Caffe (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    codice VARCHAR(7) NOT NULL UNIQUE,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    caffe INTEGER NOT NULL,
    moltiplicatori INTEGER NOT NULL
);

INSERT INTO Caffe (codice, nome, cognome, caffe, moltiplicatori)
VALUES 
    ('CF001', 'Marco', 'Rossi', 2, 3),
    ('CF002', 'Paolo', 'Bianchi', 1, 1),
    ('CF003', 'Luisa', 'Verdi', 3, 2),
    ('CF004', 'Giulia', 'Neri', 1, 1),
    ('CF005', 'Luca', 'Gialli', 2, 2);
    
SELECT * FROM Caffe;