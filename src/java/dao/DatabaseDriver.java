/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sakib
 */
public class DatabaseDriver {
    private static final String URL = "jdbc:mysql://localhost:3306/med";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    public static Connection connect(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }
}
