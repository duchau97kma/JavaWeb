/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBconnector;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Winter
 */
public class DBconnect {
    public Connection getConnection(){
       Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String conStr = "jdbc:mysql://localhost:3307/bookmanger?autoReconnect=true&useSSL=false";
            conn = DriverManager.getConnection(conStr, "root", "anhhaubk97");
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
