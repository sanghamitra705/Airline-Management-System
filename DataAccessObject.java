import java.io.IOException;
import java.util.List;

public interface DataAccessObject {
    List<String[]> getAllRecords() throws IOException;
    void addRecord(String[] data) throws IOException;
    void displayAll() throws IOException;
}
