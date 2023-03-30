# Gestione condomini

Creare un sistema di **gestione stabili** in grado di gestire e servire le richieste di Inquilini ed Amministratori.
Lo studio di amministratori ha in gestione "n" stabili, ogni stabile è caratterizzato da:
 - Indirizzo
 - Nome Stabile
 - Codice univoco

Ogni stabile è composto da più inquilini.

Ogni appartamento è caratterizzato da:
 - Identificativo appartamento
 - Nominativo
 - Telefono
 - Email

Un amministratore può accedere al sistema tramite **Username** e **Password**, esattamente come un inquilino può accedere al sistema con il numero identificativo dell'appartamento ed una password generata randomicamente dall'amministratore (max 5 caratteri).

Un amministratore può creare un numero indefinito di avvisi sullo stabile. Ogni avviso sarà visualizzabile dagli inquilini nella propria bacheca.
Un avviso è caratterizzato da:
 - Data dell'avviso
 - Titolo
 - Descrizione dell'avviso

Ogni inquilino, utilizzando le credenziali generate dell'amministratore, accedendo alla propria bacheca, oltre a visualizzare gli avvisi creati dall'amministratore, avrà la possibilità di creare una richiesta di intervento.
Ogni richiesta di intervento è caratterizzata da:
 - Data della richiesta
 - Descrizione della richiesta
 - Codice univoco (assegnato automaticamente)
 - Stato (Creato/In lavorazione/Risolto/Respinto)
 - Appartamento che ha effettuato la richiesta
