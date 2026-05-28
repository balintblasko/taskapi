# Task API

Eine kleine Backend REST API mit Java und Spring Boot zur Verwaltung von Aufgaben.

## Technologien

* Java
* Spring Boot
* Maven
* H2 Database
* REST APIs
* Git/GitHub

## Features

* Alle Aufgaben anzeigen
* Aufgabe per ID anzeigen
* Aufgabe erstellen
* Aufgabe aktualisieren
* Aufgabe löschen
* HTTP-Statuscodes mit ResponseEntity
* Einfache Validierung von Eingaben

## API Endpoints

### GET alle Tasks

```http
GET /tasks
```

### GET Task per ID

```http
GET /tasks/{id}
```

### POST neue Task

```http
POST /tasks
```

### PUT Task aktualisieren

```http
PUT /tasks/{id}
```

### DELETE Task löschen

```http
DELETE /tasks/{id}
```

## Ziel des Projekts

Dieses Projekt wurde erstellt, um Backend-Entwicklung mit Spring Boot und REST APIs praktisch zu lernen.
