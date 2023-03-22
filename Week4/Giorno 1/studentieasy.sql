DROP DATABASE IF EXISTS studentieasy;
CREATE DATABASE studentieasy;
USE studentieasy;
 
CREATE TABLE Studenti(
    studenteID INTEGER PRIMARY KEY AUTO_INCREMENT,
    nominativo VARCHAR(250) NOT NULL,
    matricola VARCHAR(250) NOT NULL UNIQUE
);

SELECT * FROM Studenti;