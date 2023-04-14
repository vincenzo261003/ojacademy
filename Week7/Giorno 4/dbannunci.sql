DROP DATABASE IF EXISTS ListaAnnunci;
CREATE DATABASE ListaAnnunci;
USE ListaAnnunci;

CREATE TABLE Utenti (
	idUtente INTEGER PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(50) NOT NULL,
    pass VARCHAR(50) NOT NULL,
    telefono VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL
);

CREATE TABLE Annunci (
	idAnnuncio INTEGER PRIMARY KEY AUTO_INCREMENT,
    codice VARCHAR(7) NOT NULL UNIQUE,
    titolo VARCHAR(50) NOT NULL,
    descrizione VARCHAR(900) NOT NULL,
    dataInserimento DATETIME DEFAULT CURRENT_TIMESTAMP,
    idUtenteRIF INTEGER NOT NULL,
    FOREIGN KEY (idUtenteRIF) REFERENCES Utenti(idUtente) ON UPDATE CASCADE
);


INSERT INTO Utenti (username, pass, telefono, email)
VALUES
    ('MarioRossi', 'mario123', '3331112233', 'mario.rossi@email.com'),
    ('LuigiBianchi', 'luigi123', '3334445566', 'luigi.bianchi@email.com');

INSERT INTO Annunci (codice, titolo, descrizione, idUtenteRIF)
VALUES
    ('ABC123', 'Oggetto inutile', 'Vendo oggetto completamente inutile. Prezzo trattabile. Non accetto offerte ridicole.', 1),
    ('DEF456', 'Bicicletta rubata', 'Ho trovato questa bicicletta in un vicolo, credo sia stata rubata. Se qualcuno la riconosce, mi contatti.', 1),
    ('GHI789', 'Smartphone rotto', 'Vendo smartphone rotto a prezzo scontato. Potrebbe essere utile per ricambi o per riparazioni.', 2),
    ('JKL012', 'Offesa gratuita', 'Vendo offesa gratuita a chiunque la voglia. Se siete degli imbecilli, questa è l\'offesa giusta per voi!', 2);
    
SELECT * FROM Annunci;