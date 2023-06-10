/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hamza
 */
public class DBConnection {

    public static Statement statement;
    public static DBConnection dbConnection;

    private DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connetion = DriverManager.getConnection("jdbc:mysql://localhost:3306/final_java3", "root", "");
            statement = connetion.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public static DBConnection getInstanse() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }
}
