✈️ Airline Reservation Backend System

A modular Java-based backend system simulating an airline reservation platform.
This project demonstrates object-oriented design, service-layer architecture, and real-world system modeling.


📌 Features (v1 – Core System)
-Flight management
-Passenger registration
-Reservation creation using PNR
-Seat map structure
-In-memory data storage (HashMap)


🧠 Architecture
model      → Domain objects (Flight, Passenger, Reservation, SeatMap)
service    → Business logic (ReservationService, FlightService)
util       → Helper classes (PNRGenerator)
exception  → Custom error handling


🎫 Reservation Flow
-Passenger selects a flight
-Seat label is assigned
-System generates a unique PNR
-Reservation is stored in memory


🧩 Technologies
-Java
-OOP principles
-Service Layer Pattern
-HashMap for storage


🚀 Planned Upgrades (Roadmap)
| Version | Feature                                                      |
| ------- | ------------------------------------------------------------ |
| v2      | Seat availability validation                                 |
| v2      | Reservation state machine (CREATED / CANCELLED / CHECKED_IN) |
| v3      | JSON persistence                                             |
| v4      | REST API (Spring Boot)                                       |
| v5      | Unit Testing (JUnit)                                         |


📂 Project Structure
src/
 ├── model/
 ├── service/
 ├── util/
 ├── exception/

👨‍💻 Purpose
This project was built to practice backend system design, state management, and scalable Java architecture.


📜 License
Educational project.
