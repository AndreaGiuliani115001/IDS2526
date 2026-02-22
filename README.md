# 🚀 HackHub

> **Piattaforma per la gestione completa del ciclo di vita di un Hackathon**

![Java](https://img.shields.io/badge/Java-17-blue?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.10-brightgreen?logo=spring)
![Maven](https://img.shields.io/badge/Maven-3.9-red?logo=apachemaven)
![H2 Database](https://img.shields.io/badge/Database-H2-lightgrey?logo=h2)
![JPA](https://img.shields.io/badge/JPA-Hibernate-orange?logo=hibernate)

Progetto sviluppato per il corso di **Ingegneria del Software – A.A. 2025/2026**
Università degli Studi di Camerino

---

## 🎯 Descrizione

**HackHub** è una piattaforma backend sviluppata in Java e Spring Boot per la gestione strutturata di hackathon.

Il sistema copre l’intero ciclo di vita di un evento:

* creazione hackathon
* registrazione team
* invio submission
* valutazione progetti
* proclamazione vincitore
* integrazione con servizi esterni (Calendar e Payment)

L’architettura è progettata per essere **modulare, estendibile, testabile e conforme ai principi SOLID**.

---

## 🏗️ Architettura

Il sistema segue una struttura **Layered Architecture**:

* **Presentation Layer** → Controller REST (`/api/v1`)
* **Application Layer** → Service + gestione stati
* **Domain Layer** → Entità e regole di business
* **Infrastructure Layer** → Persistenza H2 file-based

Il dominio è modellato per garantire:

* isolamento della logica di business
* separazione tra dominio e infrastruttura
* alta coesione e basso accoppiamento

---

## 🧠 Design Pattern Implementati

* **State Pattern** → gestione del ciclo di vita dell’hackathon (REGISTRATION, RUNNING, EVALUATION, CLOSED)
* **Factory + Adapter Pattern** → integrazione servizi esterni (Calendar e Payment)
* **Singleton** → gestione istanze condivise dove necessario

---

## 👥 Attori del Sistema

* **Visitatore** → consulta hackathon pubblici
* **Utente Registrato** → crea o partecipa a un team
* **Membro Team** → iscrive team e invia submission
* **Mentore** → supporta team e propone call
* **Giudice** → valuta submission
* **Organizzatore** → crea hackathon e proclama vincitore

---

## ⚙️ Funzionalità Principali

* Gestione multi-hackathon
* Controllo stati tramite logica applicativa
* Vincolo: un utente può appartenere a un solo team
* Valutazione con punteggio numerico (0–10)
* Integrazione Calendar Service (call mentore-team)
* Integrazione Payment Service (erogazione premio)

---

## 📁 Struttura del Repository

```
hackhub/
│
├── src/main/java/it/unicam/cs/hackhub/
│   ├── common/        # Astrazioni condivise
│   ├── core/          # Controller, Service, State Pattern
│   └── model/         # Entity JPA, DTO, Mapper
│
├── dataBase/          # Database H2 (file-based)
├── documentazioni/    # Documentazione e diagrammi UML
├── pom.xml
├── LICENSE
├──.gitignore
└── README.md
```

---

## 📊 Diagrammi e Modellazione

Il progetto include:

* Diagramma delle Classi UML
* Diagrammi di Sequenza
* Modellazione del dominio
* Diagrammi architetturali
* State Diagram del ciclo di vita


---

## 🛠️ Avvio del Progetto

### Configurazione Database (H2 file-based)

Nel file `application.properties`:

```properties
spring.datasource.url=jdbc:h2:file:./data/hackhubdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
```

### Compilazione ed esecuzione

```bash
mvn clean install
mvn spring-boot:run
```

---

## 🌍 Accesso

* Server: `http://localhost:8081`
* API Base Path: `http://localhost:8081/api/v1`
* H2 Console: `http://localhost:8081/h2-console`

---

## 🧪 Testing

* Unit Test → servizi e state handler
* Integration Test → repository JPA e controller REST
* Mock Adapter → simulazione servizi esterni

Strumenti utilizzati:
* JUnit 5
* Mockito

---

## 📦 Dipendenze Principali

* Spring Boot Web
* Spring Data JPA
* Hibernate
* H2 Database
* Lombok
* Maven

---

## 👨‍💻 Autori

* Andrea Giuliani – 115001
* Juliano Sinaj – 120007
* Giovanni Luongo – 118863

---

Se vuoi posso farti una versione ancora più “pulita e minimal GitHub style” oppure una leggermente più “da 30 e lode accademica”.
