# HackHub: Sistema di Gestione Hackathon

**HackHub** è una REST API sviluppata con **Spring Boot** per la gestione completa degli hackathon. Il sistema supporta l'intero ciclo di vita dell'evento: registrazione utenti, iscrizione dei team, invio dei progetti, valutazione da parte dei giudici e chiusura dell'evento.

---

## Stack Tecnologico
* **Linguaggio & Framework**: Java 17 e Spring Boot 3.5.10.
* **Build Tool**: Maven.
* **Persistenza**: Spring Data JPA con database **H2** (basato su file in `./data/hackhubdb`).
* **Librerie**: **Lombok** per la riduzione del codice boilerplate.
* **Mapping**: Mapping manuale Entity-to-DTO tramite un'interfaccia personalizzata `ModelMapper`.

---

## Architettura e Design Pattern
Il progetto adotta un'architettura **Layered (a strati)** con una netta separazione delle responsabilità tra i package `controller`, `service` e `repository`.



### Pattern Implementati
1. **State Pattern**: Il ciclo di vita dell'hackathon è gestito tramite quattro stati: `REGISTRATION`, `RUNNING`, `EVALUATION` e `CLOSED`. Ogni stato ha un handler dedicato che definisce le operazioni consentite (es. iscrizioni consentite solo in `REGISTRATION`).
2. **Factory & Adapter Pattern**: Supportano le integrazioni esterne tramite la `ExternalAdapterFactory`. Sono disponibili adattatori per pagamenti e calendari (MOCK, STRIPE, GOOGLE_CALENDAR), permettendo di scambiare implementazioni reali con mock durante lo sviluppo.



---

## Guida all'Avvio
* **Esecuzione**: Utilizzare il comando `mvn spring-boot:run`.
* **Porta**: Il server è in ascolto sulla porta **8081**.
* **H2 Console**: Disponibile all'indirizzo `http://localhost:8081/h2-console` per l'ispezione del database.
* **JDBC URL**: `jdbc:h2:file:./data/hackhubdb`.

---

## Panoramica delle API
Tutti gli endpoint utilizzano il prefisso `/api/v1`.

| Endpoint | Metodo | Descrizione |
| :--- | :--- | :--- |
| `/users/register` | `POST` | Registrazione di un nuovo utente. |
| `/users/login` | `POST` | Autenticazione semplice (restituisce l'oggetto User). |
| `/teams/hackathon/{id}/register` | `POST` | Iscrizione di un team a un hackathon specifico. |
| `/submissions` | `POST` | Invio del progetto finale (Stato: RUNNING). |
| `/evaluations` | `POST` | Inserimento della valutazione da parte dei giudici (Stato: EVALUATION). |

---

## Regole di Business e Sicurezza
* **Autenticazione**: Semplice controllo delle credenziali senza token o sessioni.
* **Sicurezza**: Le password sono attualmente codificate in **Base64** (solo per sviluppo).
* **Autorizzazione**: I ruoli (`ADMIN`, `JUDGE`, ecc.) sono presenti nel modello ma non ancora forzati a livello di endpoint.
* **Integrità**: Username ed email devono essere univoci alla registrazione.

---

## Roadmap di Sviluppo
1. **Security**: Implementazione di Spring Security e hashing **BCrypt** per le password.
2. **Logica Vincitore**: Sviluppo dell'algoritmo per calcolare e assegnare il vincitore dopo le valutazioni.
3. **Validazione**: Controllo per impedire a un utente di appartenere a più team contemporaneamente.
4. **Testing**: Introduzione di Unit e Integration Test con JUnit e Mockito.