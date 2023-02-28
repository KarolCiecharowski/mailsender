Mikroserwis EmailService
Mikroserwis EmailService to aplikacja, która umożliwia przechowywanie i zarządzanie adresami e-mail użytkowników, a także wysyłanie wiadomości e-mail do wszystkich odbiorców znajdujących się w bazie danych.

Wymagania
Java 11 lub wyższa
Maven
Baza danych MySQL
Instalacja i uruchamianie
Sklonuj repozytorium:

bash
Copy code
git clone https://github.com/<nazwa_uzytkownika>/email-service.git
Przejdź do katalogu z projektem:

bash
Copy code
cd email-service
Zaktualizuj plik konfiguracyjny application.properties w celu skonfigurowania połączenia z bazą danych:

php
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/<nazwa_bazy_danych>?useSSL=false&serverTimezone=UTC
spring.datasource.username=<nazwa_uzytkownika>
spring.datasource.password=<haslo_uzytkownika>
Uzupełnij powyższe wartości odpowiednimi danymi, takimi jak nazwa bazy danych, nazwa użytkownika i hasło.

Uruchom aplikację:

Copy code
mvn spring-boot:run
Aplikacja zostanie uruchomiona na porcie 8080.

Użycie
REST API
Dodawanie użytkowników
Aby dodać użytkownika do bazy danych, należy wysłać żądanie POST na adres /users, zawierające dane użytkownika w formacie JSON. Przykład:

bash
Copy code
POST /users HTTP/1.1
Content-Type: application/json

{
    "email": "jan.kowalski@example.com"
}
Pobieranie użytkowników
Aby pobrać wszystkich użytkowników z bazy danych, należy wysłać żądanie GET na adres /users. Przykład:

bash
Copy code
GET /users HTTP/1.1
Aktualizowanie użytkowników
Aby zaktualizować dane użytkownika, należy wysłać żądanie PUT na adres /users/{id}, gdzie {id} to identyfikator użytkownika. Żądanie powinno zawierać nowe dane użytkownika w formacie JSON. Przykład:

bash
Copy code
PUT /users/1 HTTP/1.1
Content-Type: application/json

{
    "email": "jan.kowalski@example.com"
}
Usuwanie użytkowników
Aby usunąć użytkownika z bazy danych, należy wysłać żądanie DELETE na adres /users/{id}, gdzie {id} to identyfikator użytkownika. Przykład:

bash
Copy code
DELETE /users/1 HTTP/1.1
Wysyłanie wiadomości e-mail
Aby wysłać wiadomość e-mail do wszystkich użytkowników znajdujących się w bazie danych,
