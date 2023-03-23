DROP DATABASE IF EXISTS studentiez;
CREATE DATABASE studentiez;
USE studentiez;

CREATE TABLE Studenti(
	idStudente INTEGER PRIMARY KEY AUTO_INCREMENT,
    nominativo VARCHAR(250) NOT NULL,
    matricola VARCHAR(10) NOT NULL UNIQUE
);

SELECT * FROM Studenti;

INSERT INTO Studenti(nominativo, matricola) VALUES ("Manuel uno", "12345"), ("Manuel due", "123456");