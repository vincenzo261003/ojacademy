CREATE SCHEMA IF NOT EXISTS `uosap` DEFAULT CHARACTER SET utf8 ;
USE `uosap` ;

DROP TABLE IF EXISTS `uosap`.`Utenti` ;

CREATE TABLE IF NOT EXISTS `uosap`.`Utenti` (
  `idUtente` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL UNIQUE,
  `password` VARCHAR(45) NOT NULL,
  `isAdmin` TINYINT NULL DEFAULT 0,
  `propiclink` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (`idUtente`)
  );


DROP TABLE IF EXISTS `uosap`.`Chatrooms` ;

CREATE TABLE IF NOT EXISTS `uosap`.`Chatrooms` (
  `idChatroom` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `admin` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idChatroom`)
  );


DROP TABLE IF EXISTS `uosap`.`Utenti_has_Chatrooms` ;

CREATE TABLE IF NOT EXISTS `uosap`.`Utenti_has_Chatrooms` (
  `Utenti_idUtente` INT NOT NULL,
  `Chatrooms_idChatroom` INT NOT NULL,
  PRIMARY KEY (`Utenti_idUtente`, `Chatrooms_idChatroom`),
    FOREIGN KEY (`Utenti_idUtente`)
    REFERENCES `uosap`.`Utenti` (`idUtente`),
    FOREIGN KEY (`Chatrooms_idChatroom`)
    REFERENCES `uosap`.`Chatrooms` (`idChatroom`));

DROP TABLE IF EXISTS `uosap`.`Messaggi` ;

CREATE TABLE IF NOT EXISTS `uosap`.`Messaggi` (
  `idMessaggio` INT NOT NULL AUTO_INCREMENT,
  `orario` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `username` VARCHAR(45) NOT NULL,
  `testo` VARCHAR(9999) NULL,
  PRIMARY KEY (`idMessaggio`));

DROP TABLE IF EXISTS `uosap`.`Chatrooms_has_Messaggi` ;

CREATE TABLE IF NOT EXISTS `uosap`.`Chatrooms_has_Messaggi` (
  `Chatrooms_idChatroom` INT NOT NULL,
  `Messaggi_idMessaggio` INT NOT NULL,
  PRIMARY KEY (`Chatrooms_idChatroom`, `Messaggi_idMessaggio`),
    FOREIGN KEY (`Chatrooms_idChatroom`)
    REFERENCES `uosap`.`Chatrooms` (`idChatroom`),
    FOREIGN KEY (`Messaggi_idMessaggio`)
    REFERENCES `uosap`.`Messaggi` (`idMessaggio`));
