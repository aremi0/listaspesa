# ListaSpesa

Micro servizio per l'acquisto di spesa online.

---
ArticoloAcquisto è una entità di mezzo tra Articolo e ListaSpesa per inglobare la "quantita"
di Articoli da acquistare.

```http
POST http://localhost:8080/api/articoli
[
    {"nome":"bicchieri"},  
    {"nome":"tazze"},  
    {"nome":"caffe"},  
    {"nome":"pasta"}  
]
```

---

```http
POST http://localhost:8080/api/utente  
[  
    {"nome":"marco", "email":"asd@m.it"},  
    {"nome":"aremi", "email":"qwe@m.it"},  
    {"nome":"ciccio"},  
    {"nome":"giuseppe"}  
]  
```

---

```http
POST http://localhost:8080/api/utente/5/listaspesa  
{
    "nomeListaspesa": "cose di casa",  
    "articoli":  
    [
        {
        "articolo": {"id": 1},
        "quantita":10.0
        },
        {
        "articolo": {"id": 2},
        "quantita":5.0
        }
    ]
}
```


<details>
# Lo devo aggiornare, non leggerlo

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
</details>
