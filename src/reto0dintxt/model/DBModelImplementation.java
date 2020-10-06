/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto0dintxt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementation of the model that gets a text message from a database
 * @author Aingeru
 */
public class DBModelImplementation implements Model{

    private Connection con = null;
    private PreparedStatement stat = null;
    private ResourceBundle configFile = null;
    private String driverBD = "";
    private String urlBD = "";
    private String userBD = "";
    private String passwordBD = "";
    private final String getGreeting = "SELECT * FROM greetingtable";

    public DBModelImplementation() {
        this.configFile = ResourceBundle.getBundle("reto0dintxt.model.ModelFile");
        this.driverBD = this.configFile.getString("Driver");
        this.urlBD = this.configFile.getString("Conn");
        this.userBD = this.configFile.getString("DBUser");
        this.passwordBD = this.configFile.getString("DBPass");
    }

    /**
     * Open Database connection.
     */
    private void openConnection() {
        try {
            Class.forName(this.driverBD);
            con = DriverManager.getConnection(this.urlBD, this.userBD, this.passwordBD);
        } catch (SQLException e) {
            Logger.getLogger(DBModelImplementation.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e1) {
            Logger.getLogger(DBModelImplementation.class.getName()).log(Level.SEVERE, null, e1);
        }
    }

    /**
     * Close Database connection.
     */
    private void closeConnection() {
        try {
            if (stat != null) {
                stat.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("ERROR trying to close the connection");
        }
    }
    /**
     * This method makes a query that shows the greeting from database.
     * @return a string with the "greeting" column data.
     */
    public String getGreeting(){

        String text = "";
        this.openConnection();
        try {

           Statement s = con.createStatement();
            s.executeQuery(getGreeting);
            ResultSet rs = s.getResultSet();

            while (rs.next()) {
                text = rs.getString("greeting");
            }

            rs.close();
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return text;

    }
}
