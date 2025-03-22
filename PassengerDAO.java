import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PassengerDAO implements DataAccessObject {
    private static final String FILE_NAME = "passengers.txt";

    public PassengerDAO() {
        ensureFileExists(FILE_NAME, "First Name,Last Name,Email,Phone");
    }

    public void insertData(Scanner scanner) throws IOException {
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();

        addRecord(new String[]{firstName, lastName, email, phone});
        System.out.println("Passenger added successfully!");
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
        System.out.println("\n--- Passenger List ---");
        for (String[] record : records) {
            System.out.println(String.join(" | ", record));
        }
    }

    // 🔴 Missing Methods (Now Added)

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
