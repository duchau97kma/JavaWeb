package DBconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnector {
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String str="jdbc:mysql://localhost:3307/ProjectManager";
        return DriverManager.getConnection(str,"root","anhhaubk97");

    }
}
