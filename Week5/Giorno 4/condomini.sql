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

-- Insert some data into the Utenti table
INSERT INTO Utenti (nominativo, email, telefono, pass, codiceAppartamento, isAdmin, idCondominioRIF) VALUES 
('Mario Rossi', 'mario.rossi@example.com', '+39 1234567890', 'password123', 'APT001', false, 1),
('Luigi Bianchi', 'luigi.bianchi@example.com', '+39 55555555', 'password789', 'APT003', false, 2),
('Giovanni Neri', 'giovanni.neri@example.com', '+39 11111111', 'password101', 'APT004', false, 3),
('Marco Verdi', 'marco.verdi@example.com', '+39 22222222', 'password222', 'APT005', false, 4),
('Carla Bianchi', 'carla.bianchi@example.com', '+39 33333333', 'password333', 'APT006', false, 4),
('Paola Neri', 'paola.neri@example.com', '+39 44444444', 'password444', 'APT007', false, 4),
('Valentina Rossi', 'valentina.rossi@example.com', '+39 77777777', 'password555', 'APT008', false, 1),
('Federico Verdi', 'federico.verdi@example.com', '+39 88888888', 'password666', 'APT009', false, 2),
('Alessandro Bianchi', 'alessandro.bianchi@example.com', '+39 99999999', 'password777', 'APT010', false, 3),
('Giuseppe Verdi', 'giuseppe.verdi@example.com', '+39 0987654321', 'password456', 'ADMIN', true, 1);

-- Insert some data into the Avvisi table
INSERT INTO Avvisi (dataAvviso, titolo, descrizione, idCondominioRIF) VALUES 
('2023-03-15', 'Manutenzione Ascensori', 'Si avvisano tutti i condomini che il giorno 25 marzo saranno effettuati lavori di manutenzione agli ascensori.', 1),
('2023-03-18', 'Chiusura portone ingresso', 'Si informa che a partire dal giorno 28 marzo il portone di ingresso del condominio resterà chiuso dalle 22:00 alle 06:00.', 2),
('2023-03-20', 'Riunione condominiale', 'Si comunica che il giorno 5 aprile si terrà una riunione condominiale per discutere le questioni riguardanti la gestione del condominio.', 3),
('2023-03-25', 'Lavori riscaldamento', 'Si informano i condomini che a partire dal giorno 1 aprile saranno effettuati lavori di manutenzione al sistema di riscaldamento.', 4),
('2023-03-28', 'Pulizia scale', 'Si comunica che il giorno 2 aprile saranno effettuate le pulizie delle scale del condominio.', 2),
('2023-03-29', 'Cambio amministratore', 'Si informa che a partire dal giorno 1 aprile sarà cambiato l\'amministratore del condominio.', 3);


-- Insert some data into the Condomini table
INSERT INTO Condomini (indirizzo, nome, codice) VALUES
('Via Vittorio Emanuele 256', 'Condominio E', 'COD005'),
('Piazza del Popolo 18', 'Condominio F', 'COD006'),
('Via delle Acacie 5', 'Condominio G', 'COD007'),
('Viale Europa 42', 'Condominio H', 'COD008');

-- Insert some data into the Utenti table
INSERT INTO Utenti (nominativo, email, telefono, pass, codiceAppartamento, isAdmin, idCondominioRIF) VALUES
('Elisa Conti', 'elisa.conti@example.com', '+39 9876543210', 'password800', 'APT011', false, 5),
('Fabio Orsini', 'fabio.orsini@example.com', '+39 55555566', 'password900', 'APT012', false, 6),
('Sara Colombo', 'sara.colombo@example.com', '+39 44444455', 'password1000', 'APT013', false, 7),
('Simone Rossi', 'simone.rossi@example.com', '+39 33333344', 'password1100', 'APT014', false, 8),
('Elena Gentile', 'elena.gentile@example.com', '+39 22222233', 'password1200', 'APT015', false, 5),
('Roberto Morelli', 'roberto.morelli@example.com', '+39 77777722', 'password1300', 'APT016', false, 6),
('Claudia Rinaldi', 'claudia.rinaldi@example.com', '+39 88888811', 'password1400', 'APT017', false, 7),
('Stefano Sanna', 'stefano.sanna@example.com', '+39 66666600', 'password1500', 'APT018', false, 8);

-- Insert some data into the Avvisi table
INSERT INTO Avvisi (dataAvviso, titolo, descrizione, idCondominioRIF) VALUES
('2023-04-01', 'Pulizia giardino', 'Si comunica che il giorno 10 aprile saranno effettuate le pulizie del giardino condominiale.', 5),
('2023-04-02', 'Installazione impianto fotovoltaico', 'Si informa che a partire dal giorno 15 aprile verrà installato un impianto fotovoltaico sul tetto del condominio.', 6),
('2023-04-03', 'Riunione condominiale', 'Si comunica che il giorno 12 aprile si terrà una riunione condominiale per discutere le questioni riguardanti la gestione del condominio.', 7),
('2023-04-05', 'Lavori di tinteggiatura', 'Si avvisano tutti i condomini che dal giorno 20 aprile saranno effettuati lavori di tinteggiatura delle parti comuni del condominio.', 8),
('2023-04-07', 'Controllo impianto elettrico', 'Si comunica che il giorno 14 aprile verrà effettuato un controllo dell\'impianto elettrico del condominio.', 5);


SELECT * FROM Utenti;
