package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konekcija {
    // Izmeniti podatke u skladu sa Vasom konfiguracijom
    private static final String url = "jdbc:mysql://localhost/assignment1_jda";
    private static final String username = "root";
    private static final String password = "nikiniki01";

    public static Connection uspostaviKonekciju() throws SQLException {

        return DriverManager.getConnection(url, username, password);

    }
}
