import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlightDAO implements DataAccessObject {
    private static final String FILE_NAME = "flights.txt";

    public FlightDAO() {
        ensureFileExists(FILE_NAME, "Flight Number,Origin,Destination,Time,Seats Available");
    }

    public void insertData(Scanner scanner) throws IOException {
        System.out.print("Enter Flight Number: ");
        String number = scanner.nextLine();
        System.out.print("Enter Origin: ");
        String origin = scanner.nextLine();
        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter Departure Time: ");
        String time = scanner.nextLine();
        System.out.print("Enter Seats Available: ");
        String seats = scanner.nextLine();

        addRecord(new String[]{number, origin, destination, time, seats});
        System.out.println("Flight added successfully!");
    }

    @Override
    public List<String[]> getAllRecords() throws IOException {
        return readFile(FILE_NAME);
    }

    @Override
    public void addRecord(String[] data) throws IOException {
        writeFile(FILE_NAME, data);
    }

    @Override
    public void displayAll() throws IOException {
        List<String[]> records = getAllRecords();
        System.out.println("\n--- Flight List ---");
        for (String[] record : records) {
            System.out.println(String.join(" | ", record));
        }
    }

    private void ensureFileExists(String fileName, String header) {
        File file = new File(fileName);
        if (!file.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
                bw.write(header);
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private List<String[]> readFile(String fileName) throws IOException {
        List<String[]> records = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        br.readLine(); // Skip header
        String line;
        while ((line = br.readLine()) != null) {
            records.add(line.split(","));
        }
        br.close();
        return records;
    }

    private void writeFile(String fileName, String[] data) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
        bw.write(String.join(",", data));
        bw.newLine();
        bw.close();
    }
}
