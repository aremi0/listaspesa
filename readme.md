# ListaSpesa

Micro servizio per l'acquisto di spesa online.

## entity
Utente (**id_utente**, nomeUtente)  
Articolo (**id_articolo**, nomeArticolo)  
ListaSpesa (**id_lista**, ***id_utente***, nomeArticolo, quantita)  
Market (**id_market**, nomeMarket)  
Inventario (**id_inventario**, ***id_market***, articolo, quantita)

## endpoint
### articolo
**GET** "*/api/articoli*" getAllArticoli()  
**POST** "*/api/articoli*" insertArticoli()

### utente
**GET** "*/api/utente*" getAllUtenti()  
**POST** "*/api/utente*" insertUtenti()

### listaSpesa
**GET** "*/api/utente/{id_utente}/listaspesa*" getListaSpesaOfUtente()  
**POST** "*/api/utente/{id_utente}/listaspesa*" insertListaSpesaForUtente()

