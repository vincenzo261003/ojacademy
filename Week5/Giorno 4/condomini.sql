DROP DATABASE IF EXISTS Amministrazionecondomini;
CREATE DATABASE Amministrazionecondomini;
USE Amministrazionecondomini;

CREATE TABLE Condomini (
	idCondominio INTEGER PRIMARY KEY AUTO_INCREMENT,
    indirizzo VARCHAR(100) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    codice VARCHAR(7) NOT NULL UNIQUE
);

CREATE TABLE Utenti (
	idUtente INTEGER PRIMARY KEY AUTO_INCREMENT,
    nominativo VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefono VARCHAR(50) NOT NULL,
    pass VARCHAR(32) NOT NULL,
    codiceAppartamento VARCHAR(7) NOT NULL UNIQUE,
    isAdmin BOOLEAN DEFAULT(0),
    idCondominioRIF INTEGER,
    FOREIGN KEY (idCondominioRIF) REFERENCES Condomini(idCondominio) ON DELETE CASCADE
);

CREATE TABLE Avvisi (
	idAvviso INTEGER PRIMARY KEY AUTO_INCREMENT,
	dataAvviso DATE NOT NULL,
    titolo VARCHAR(50) NOT NULL,
    descrizione VARCHAR(250) NOT NULL,
    idCondominioRIF INTEGER,
    FOREIGN KEY (idCondominioRIF) REFERENCES Condomini(idCondominio) ON DELETE CASCADE
);

INSERT INTO Condomini (indirizzo, nome, codice) VALUES 
('Via Roma 123', 'Condominio A', 'COD001'),
('Via dei Mille 45', 'Condominio B', 'COD002'),
('Piazza Garibaldi 1', 'Condominio C', 'COD003'),
('Corso Umberto I 78', 'Condominio D', 'COD004');

INSERT INTO Utenti (nominativo, email, telefono, pass, codiceAppartamento, isAdmin, idCondominioRIF) VALUES 
('Mario Rossi', 'mario.rossi@example.com', '+39 1234567890', 'password123', 'APT001', false, 1),
('Giuseppe Verdi', 'giuseppe.verdi@example.com', '+39 0987654321', 'password456', 'ADMIN', true, 1),
('Luigi Bianchi', 'luigi.bianchi@example.com', '+39 55555555', 'password789', 'APT003', false, 2),
('Giovanni Neri', 'giovanni.neri@example.com', '+39 11111111', 'password101', 'APT004', false, 3);

INSERT INTO Avvisi (dataAvviso, titolo, descrizione, idCondominioRIF) VALUES 
('2023-03-15', 'Manutenzione Ascensori', 'Si avvisano tutti i condomini che il giorno 25 marzo saranno effettuati lavori di manutenzione agli ascensori.', 1),
('2023-03-18', 'Chiusura portone ingresso', 'Si informa che a partire dal giorno 28 marzo il portone di ingresso del condominio resterà chiuso dalle 22:00 alle 06:00.', 2),
('2023-03-20', 'Riunione condominiale', 'Si comunica che il giorno 5 aprile si terrà una riunione condominiale per discutere le questioni riguardanti la gestione del condominio.', 3),
('2023-03-25', 'Lavori riscaldamento', 'Si informano i condomini che a partire dal giorno 1 aprile saranno effettuati lavori di manutenzione al sistema di riscaldamento.', 4);


SELECT * FROM Utenti;
