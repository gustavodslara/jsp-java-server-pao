package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gustavo
 */
public class ConnectionFactory {

    public static Connection getConnectionFactory() throws SQLException {
        try {
            String user = "root";
            String pwd = "root";
            String url = "jdbc:derby://localhost:1527/bancodepao";
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            return DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
