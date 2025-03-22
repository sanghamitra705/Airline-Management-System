✈ Airline Management System

A simple Java-based Airline Management System that stores flights, passengers, and bookings in text files instead of a database. The system allows adding and viewing data through a command-line menu using Java file handling and OOP principles.
📌 Features

✅ Store and retrieve flights, passengers, and bookings in .txt files
✅ Command-line interface for interactive input
✅ File handling using BufferedReader and BufferedWriter
✅ Modular OOP design with DAO classes and an interface
✅ Menu-driven system with options to add/view data
📂 File Structure

📦 Airline-Management-System  
 ┣ 📜 AirlineManagementSystem.java  # Main CLI  
 ┣ 📜 DataAccessObject.java          # Interface for DAOs  
 ┣ 📜 FlightDAO.java                 # Flight data handling  
 ┣ 📜 PassengerDAO.java              # Passenger data handling  
 ┣ 📜 BookingDAO.java                # Booking data handling  
 ┣ 📜 flights.txt                    # Stores flight data  
 ┣ 📜 passengers.txt                  # Stores passenger data  
 ┣ 📜 bookings.txt                    # Stores booking data  
 ┣ 📜 README.md                      # Documentation  

🛠 Installation & Setup

    Clone the repository

git clone https://github.com/your-username/Airline-Management-System.git
cd Airline-Management-System

Compile the Java files

javac *.java

Run the program

    java AirlineManagementSystem

📌 Usage Guide

    Run the program and choose an option:

    ===== Airline Management System =====
    1. Add Flight
    2. Add Passenger
    3. Add Booking
    4. View Flights
    5. View Passengers
    6. View Bookings
    7. Exit
    Choose an option: 

    Add/View Flights, Passengers, and Bookings interactively

    All data is saved in text files (flights.txt, passengers.txt, bookings.txt)

📂 Sample Data Format
flights.txt

Flight Number,Origin,Destination,Time,Seats Available
AI101,New York,London,10:00 AM,200

passengers.txt

First Name,Last Name,Email,Phone
John,Doe,john@example.com,1234567890

bookings.txt

Flight ID,Passenger ID,Seat Number
AI101,1,A1

💡 Skills Applied

✔ Java File Handling (BufferedReader, BufferedWriter)
✔ Object-Oriented Programming (OOP) (DAO pattern, interfaces)
✔ User Interaction with CLI (Scanner, Switch-Case)
✔ Debugging & Problem Solving
📜 License

This project is open-source and available under the MIT License.

🚀 Contributions are welcome! Fork the repo, make improvements, and submit a pull request.
