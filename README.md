  =================================# ✈️ Airline Reservation System================================================================================================

A desktop-based Airline Reservation System built with **Java Swing** and **MySQL**, featuring user login, flight booking, and booking confirmation — packaged as a runnable JAR file.

---

## 📌 Overview

This project simulates a simplified airline booking workflow:
- Users log in through a secure login screen
- Browse and select available flights
- Book a flight and receive a booking confirmation
- All data is stored and retrieved from a MySQL database

Built as an academic micro-project to demonstrate Java Swing GUI development combined with JDBC-based database connectivity.

---

## 🚀 Features

- 🔐 User login system
- 🛫 View available flights
- 🎟️ Book flights with confirmation dialog
- 🗄️ MySQL database integration via JDBC
- 🖥️ Clean Swing-based desktop UI
- 📦 Packaged as a standalone runnable `.jar`

---

## 🛠️ Tech Stack

| Component     | Technology                  |
|---------------|------------------------------|
| Language       | Java (Swing, AWT)            |
| Database       | MySQL                        |
| DB Connector   | MySQL Connector/J 9.6.0      |
| Build/Run      | JDK, `javac` / `jar` CLI     |
| IDE            | Visual Studio Code           |

---

## 📁 Project Structure

```
javamicroproject/
├── airoplanereservation/     # Core reservation logic & UI
│   ├── AirplaneReservationSystem.java
│   ├── BookingConfirmationDialog.java
│   └── MultipaleAirplane.java
├── login/                    # Login screen
│   └── LoginApp.java
├── start/                    # Application entry point
│   └── start.java
├── lib/                      # External libraries (MySQL connector)
├── air.png / airicon.png / airplane.png   # UI assets
└── README.md
```

---

## ⚙️ Setup & Installation

### Prerequisites
- JDK 17 or later
- MySQL Server running locally
- MySQL Connector/J (`.jar`) — place inside a `lib/` folder

### 1. Clone the repository
```bash
git clone https://github.com/chetan270418-exe/microproject_java.git
cd microproject_java
```

### 2. Set up the database
Run your `database.sql` file (if included) in MySQL to create the required schema:
```bash
mysql -u root -p < database.sql
```

### 3. Configure DB credentials
Update the DB URL/username/password inside `LoginApp.java` if different from your local setup:
```java
private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/airindia_db";
private static final String DB_USER = "root";
private static final String DB_PASS = "your_password";
```

---

## ▶️ Running the Project (Development)

Run directly from your IDE using `start.java` as the entry point, **not** `LoginApp.java` — `start.java` launches the login screen internally.

Or via terminal:
```bash
javac -d out -cp "lib\*" @sources.txt
java -cp "out;lib\*" start.start
```

---

## 📦 Building a Runnable JAR

```bash
mkdir out
javac -d out -cp "lib\*" @sources.txt
jar cfm AirlineReservation.jar manifest.txt -C out .
java -jar AirlineReservation.jar
```

> ⚠️ Ensure the `lib/` folder (with the MySQL connector jar) sits next to `AirlineReservation.jar` when running it.

---

## 🖼️ Screenshots

*(Add screenshots of the login screen, flight listing, and booking confirmation here)*

---

## 📄 License

This project was created for academic purposes as part of a college micro-project submission.

---

## 👤 Author

**Chetan Sonawane**
GitHub: [@chetan270418-exe](https://github.com/chetan270418-exe)
