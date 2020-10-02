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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to connect to the DataBase to get a greeting
 * @author Aingeru
 * @author Bryssa
 */
public class Dao {
    
    private Connection con = null;
    private PreparedStatement stat = null;
    private ResourceBundle configFile = null;
    private String driverBD = "";
    private String urlBD = "";
    private String userBD = "";
    private String passwordBD = "";
    
    private final String sql = "select * from greeting";
    
    /**
     * Constructor of the Dao
     */
    public Dao() {
        this.configFile = ResourceBundle.getBundle("reto0dintxt.properties.config");
        this.driverBD = this.configFile.getString("Driver");
        this.urlBD = this.configFile.getString("Conn");
        this.userBD = this.configFile.getString("DBUser");
        this.passwordBD = this.configFile.getString("DBPass");
    }
    
    /**
     * Metod to open the connection with the DB
     */
    private void openConnection() {
        try {
            Class.forName(this.driverBD);
            con = DriverManager.getConnection(this.urlBD, this.userBD, this.passwordBD);
        } catch (SQLException e) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException e1) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, e1);
        }
    }
     
     /**
      * Metod to close the connection with the DB
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
            System.out.println("ERROR CLOSING CONNECTION");
        }
    }
     
     /**
      * Metod to execute an SQL to get the greeting
      * @return The greeting 
      */
    public String getGreeting (){
        String greeting = null;
        this.openConnection();
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                greeting = rs.getString("greeting");
            }
            stmt.execute();
            rs.close();
            stmt.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return greeting;
    }
}
