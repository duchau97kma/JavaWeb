/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Winter
 */
public class DBconnect {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String conStr = "jdbc:mysql://localhost:3307/qlysv?autoReconnect=true&useSSL=false";
        Connection conn = DriverManager.getConnection(conStr, "root", "anhhaubk97");

        return conn;
    }

}
