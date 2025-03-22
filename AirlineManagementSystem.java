import java.io.IOException;
import java.util.Scanner;

public class AirlineManagementSystem {
    private static FlightDAO flightDAO = new FlightDAO();
    private static PassengerDAO passengerDAO = new PassengerDAO();
    private static BookingDAO bookingDAO = new BookingDAO();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Airline Management System =====");
            System.out.println("1. Add Flight");
            System.out.println("2. Add Passenger");
            System.out.println("3. Add Booking");
            System.out.println("4. View Flights");
            System.out.println("5. View Passengers");
            System.out.println("6. View Bookings");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            try {
                switch (choice) {
                    case 1:
                        flightDAO.insertData(scanner);
                        break;
                    case 2:
                        passengerDAO.insertData(scanner);
                        break;
                    case 3:
                        bookingDAO.insertData(scanner);
                        break;
                    case 4:
                        flightDAO.displayAll();
                        break;
                    case 5:
                        passengerDAO.displayAll();
                        break;
                    case 6:
                        bookingDAO.displayAll();
                        break;
                    case 7:
                        System.out.println("Exiting system...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice, try again.");
                }
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
