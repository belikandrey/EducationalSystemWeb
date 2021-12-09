package by.itoverone.util;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DBUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Not found driver");
        }
    }
    public Connection getConnection() throws SQLException {
         return DriverManager.getConnection("jdbc:mysql://localhost:3306/educational_system",
                 DBLoginInfo.DB_USERNAME, DBLoginInfo.DB_PASSWORD);
    }
}
